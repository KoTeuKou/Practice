package org.example.domain;

public class User {
    private transient String id;
    private String full_name;
    private String phone;
    private String mail;

    public User() {
    }

    public User(String full_name, String phone, String mail) {
        this.full_name = full_name;
        this.phone = phone;
        this.mail = mail;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
