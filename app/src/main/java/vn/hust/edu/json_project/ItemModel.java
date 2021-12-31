package vn.hust.edu.json_project;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private int id;
    private String username;
    private String name;
    private String email;
    private String avatar;
    private String address;
    private String phone;
    private String company;

    public ItemModel(int id, String username, String name, String email, String avatar, String address, String phone, String company) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}