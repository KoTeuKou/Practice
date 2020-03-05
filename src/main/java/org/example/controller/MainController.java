package org.example.controller;

import org.example.domain.User;
import org.example.service.ElasticService;
import org.example.service.UserService;
import org.example.util.BulkToJsonParser;
import org.json.simple.JSONArray;
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
    public MainController(UserService userService){
        this.userService = userService;
    }
    @GetMapping()
    public String getData(Model model){
        return "main";
    }
    @GetMapping("users")
    public String get(Model model) throws IOException {
        List<User> indexedData = userService.getAllAccounts();
        JSONArray data = BulkToJsonParser.parse(indexedData);
        model.addAttribute("users", data);
        return "users";
    }
    @PostMapping("search")
    public String getUsersBy(String param, String reqString, double cutoff_frequency, Model model) throws IOException {
        List<User> indexedData = userService.getAccountsBy(param, reqString, cutoff_frequency);
        JSONArray data = BulkToJsonParser.parse(indexedData);
        model.addAttribute("users", data);
        return "users";
    }
}
