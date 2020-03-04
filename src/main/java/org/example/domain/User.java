package org.example.domain;

public class User {
    private String fullname;
    private String phone;
    private String mail;
    public User(){}

    public User(String fullname, String phone, String mail) {
        this.fullname = fullname;
        this.phone = phone;
        this.mail = mail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
}
