package org.example.controller;

import org.example.service.ElasticService;
import org.example.util.BulkToJsonParser;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class MainController {
    private ElasticService elasticService;
    public MainController(ElasticService elasticService){
        this.elasticService = elasticService;
    }
    @GetMapping()
    public String getData(Model model){
        return "main";
    }
    @GetMapping("users")
    public String get(Model model) throws IOException {
        String indexedData = elasticService.getAllAccounts().toString();
        String data = BulkToJsonParser.parse(indexedData);
        model.addAttribute("users", data);
        return "users";
    }
    @PostMapping("search")
    public String getUsersBy(String param, String reqString, double cutoff_frequency, Model model) throws IOException {
        String indexedData = elasticService.getAccountsBy(param, reqString, cutoff_frequency).toString();
        String data = BulkToJsonParser.parse(indexedData);
        model.addAttribute("users", data);
        return "users";
    }
}
