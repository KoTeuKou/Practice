package org.example.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.domain.User;

import java.lang.reflect.Type;
import java.util.List;

public class UserSerialization {
    private static Gson gson = new Gson();

    public static List<User> fromJson(String json) {
        Type type = new TypeToken<List<User>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public static String toJson(List<User> users) {
        return gson.toJson(users);
    }
}
