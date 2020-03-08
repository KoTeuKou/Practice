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
        List<User> allAccounts = userService.getAllAccounts();
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
    public void save(String userString) throws IOException, JSONException {
        String[] splittedUser = userString.split(";");
        User user = new User(splittedUser[0], splittedUser[1], splittedUser[2]);
        userService.save(user);
    }
    @PostMapping("delete")
    public void delete(String id) throws IOException {
        userService.remove(id);
    }
    @PostMapping("update")
    public void update(String id, String userString) throws IOException {
        String[] splittedUser = userString.split(";");
        User user = new User(splittedUser[0], splittedUser[1], splittedUser[2]);
        userService.update(id, user);
    }
}
