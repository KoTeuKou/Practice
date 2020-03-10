package org.example.domain;

import java.util.Comparator;
import java.util.UUID;

public class User {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String mail;

    public User() {
    }

    public User(String surname, String name, String patronymic, String phone, String mail) {
        id = UUID.randomUUID().toString();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.mail = mail;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void generateId() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static final Comparator<User> COMPARE_BY_NAME = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return user1.getName().compareTo(user2.getName());
        }
    };
    public static final Comparator<User> COMPARE_BY_SURNAME = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return user1.getSurname().compareTo(user2.getSurname());
        }
    };
    public static final Comparator<User> COMPARE_BY_PATRONYMIC = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return user1.getPatronymic().compareTo(user2.getPatronymic());
        }
    };
    public static final Comparator<User> COMPARE_BY_ID = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            return Integer.parseInt(user1.getId()) - Integer.parseInt(user2.getId());
        }
    };
}
