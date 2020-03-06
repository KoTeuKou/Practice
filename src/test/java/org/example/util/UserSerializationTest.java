package org.example.util;

import org.example.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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