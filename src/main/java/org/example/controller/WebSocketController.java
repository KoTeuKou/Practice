package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketController {
    private UserService userService;

    public WebSocketController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/autocomplete")
    @SendTo("/topic/autocomplete")
    public List<User> autocomplete(String text) {
        String[] strings = text.split("`");
        return userService.getAccountsBy(strings[0], strings[1], 0.1);  // cutoffFrequency is not using
    }
}
