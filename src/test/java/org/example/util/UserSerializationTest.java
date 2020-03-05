package org.example.util;

import org.example.domain.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserSerializationTest {

    @Test
    void deserialization() {
        System.out.println(UserSerialization.fromJson("[{\"fullname\":\"DVD\",\"phone\":\"8800553535\",\"mail\":\"DIMA@CAT.CAT\"}]\n"));
    }

    @Test
    void serialization() {
        User user = new User("DVD","8800553535", "DIMA@CAT.CAT");
        String s = UserSerialization.toJson(Collections.singletonList(user));
        System.out.println(s);
    }
}