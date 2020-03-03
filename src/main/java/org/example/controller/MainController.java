package org.example.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.FileReader;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class MainController {

    @PostMapping("/users/put-message")
    public void post(@RequestBody String someMessage){
        String some = someMessage;
    }
    @GetMapping()
    public String getData(Model model){
        return "main";
    }
    @GetMapping("users")
    public String get(Model model){
        JSONArray data = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            data = (JSONArray) parser.parse(
                    new FileReader("src/main/resources/data/users.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("users", data);
        return "users";
    }
}
