package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Comparator;
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
    public String get(@RequestParam(required = false) String param, Model model)  {
        List<User> allAccounts = userService.getAllAccounts();
        if (param != null){
            switch (param){
                case "surname":
                    allAccounts.sort(Comparator.comparing(User::getSurname));
                    break;
                case "name":
                    allAccounts.sort(Comparator.comparing(User::getName));
                    break;
                case "patronymic":
                    allAccounts.sort(Comparator.comparing(User::getPatronymic));
                    break;
                default:
                    System.out.println("WTF???");
                    break;
            }
        }
        model.addAttribute("userList", allAccounts);
        return "users";
    }

    @PostMapping("search")
    public String getUsersBy(String param, String reqString, double cutoff_frequency, Model model) throws IOException, JSONException {
        List<User> users = userService.getAccountsBy(param, reqString, cutoff_frequency);
        model.addAttribute("userList", users);
        return "redirect:/users";
    }

    @PostMapping("save")
    public String save(User user, Model model) throws IOException, JSONException {
        user.generateId();
        userService.save(user);
        List<User> accounts = userService.getAllAccounts();
        accounts.add(user);
        model.addAttribute("userList", accounts);
        return "redirect:/users";
    }

    @PostMapping("delete")
    public String delete(String id, Model model) {
        userService.remove(id);
        model.addAttribute("userList", userService.getAllAccounts());
        return "redirect:/users";
    }

    @PostMapping("update")
    public String update(User user, Model model)  {
        userService.save(user);
        model.addAttribute("userList", userService.getAllAccounts());
        return "redirect:/users";
    }
}
