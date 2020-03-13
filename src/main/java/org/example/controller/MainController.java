package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getData(Model model) {
        return "main";
    }

    @GetMapping("users")
    public String get(Model model) throws IOException, JSONException {
        List<User> allAccounts = userService.getAllAccounts().subList(0, 100);
        model.addAttribute("userList", allAccounts);
        return "users";
    }

    @GetMapping("sort")
    public String getUsersSortedBy(String param, Model model) throws IOException, JSONException {
        List<User> allAccounts = userService.getAllAccounts();
        switch (param){
            case "surnameSort":
                allAccounts.sort(User.COMPARE_BY_SURNAME);
                break;
            case "nameSort":
                allAccounts.sort(User.COMPARE_BY_NAME);
                break;
            case "patronymicSort":
                allAccounts.sort(User.COMPARE_BY_PATRONYMIC);
                break;
            case "idSort":
                allAccounts.sort(User.COMPARE_BY_ID);
                break;
        }
        model.addAttribute("userList", allAccounts);
        return "users";
    }

    @PostMapping("search")
    public String getUsersBy(String param, String reqString, double cutoff_frequency, Model model) throws IOException, JSONException {
        List<User> users = userService.getAccountsBy(param, reqString, cutoff_frequency);
        model.addAttribute("userList", users);
        return "users";
    }

    @PostMapping("save")
    public String save(User user, Model model) throws IOException, JSONException {
        user.generateId();
        userService.save(user);
        List<User> accounts = userService.getAllAccounts();
        model.addAttribute("userList", accounts);
        return "users";
    }

    @PostMapping("delete")
    public String delete(String id, Model model) throws IOException, JSONException {
        userService.remove(id);
        model.addAttribute("userList", userService.getAllAccounts());
        return "users";
    }

    @PostMapping("update")
    public String update(String id, User user, Model model) throws IOException, JSONException {
        user.setId(id);
        userService.save(user);
        model.addAttribute("userList", userService.getAllAccounts());
        return "users";
    }
}
