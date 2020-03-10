package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.json.JSONException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class WebSocketController {
    private UserService userService;

    public WebSocketController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/autocomplete")
    @SendTo("/topic/autocomplete")
    public List<User> autocomplete(String text) throws IOException, JSONException {
        return userService.getAccountsBy("name", text, 0.01d);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}