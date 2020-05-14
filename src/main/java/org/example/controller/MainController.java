package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private UserService userService;
    private List<User> allAccounts = new ArrayList<>();

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getData(Model model) {
        return "main";
    }

    @GetMapping("users")
    public String get(@RequestParam(required = false) String param, Model model) {

        if (param != null) {
            switch (param) {
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
        } else {
            if (allAccounts.isEmpty()) {
                allAccounts = new ArrayList<>(userService.getAllAccounts());
            }
        }
        model.addAttribute("userList", allAccounts);
        return "users";
    }

    @PostMapping("search")
    public String getUsersBy(String param, String searchField, double cutoff_frequency, Model model) {
        allAccounts = new ArrayList<>(userService.getAccountsBy(param, searchField, cutoff_frequency));
        model.addAttribute("userList", allAccounts);
        return "redirect:/users";
    }

    @PostMapping("save")
    public String save(User user, Model model) {
        user.generateId();
        userService.save(user);
        allAccounts.add(user);
        model.addAttribute("userList", allAccounts);
        return "redirect:/users";
    }

    @PostMapping("delete")
    public String delete(String id, Model model) {
        userService.remove(id);
        User reqUser = allAccounts.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        allAccounts.remove(reqUser);
        model.addAttribute("userList", allAccounts);
        return "redirect:/users";
    }

    @PostMapping("update")
    public String update(User user, Model model) {
        userService.save(user);
        User reqUser = allAccounts.stream().filter(x -> x.getId().equals(user.getId())).findFirst().get();
        int index = allAccounts.indexOf(reqUser);
        allAccounts.set(index, user);
        model.addAttribute("userList", allAccounts);
        return "redirect:/users";
    }
}
