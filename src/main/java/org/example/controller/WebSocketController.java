package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        HashMap<String, String> params = new HashMap<>();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("SURNAME", "NAME", "PATRONYMIC", "PHONE", "MAIL"));
        for (String name : names){
            params.put(name, "");
        }
        params.put(strings[0], strings[1]);
        return userService.getAccountsBy(params.get("SURNAME"),params.get("NAME"),params.get("PATRONYMIC"),
                params.get("PHONE"),params.get("MAIL"));
    }
}
