package org.example.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.domain.User;

import java.lang.reflect.Type;
import java.util.List;

public class UserSerialization {
    private static Gson gson = new Gson();

    public static List<User> deserialization(String jsonArray) {
        Type type = new TypeToken<List<User>>() {
        }.getType();
        return gson.fromJson(jsonArray, type);
    }

    public static String serialization(List<User> users) {
        return gson.toJson(users);
    }
}
