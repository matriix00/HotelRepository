package com.example.hotelapp.pojo;

public class Guest {
    private int id;
    private int passid;
    private String name;
    private String email;
    private int mobile;
    private String nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guest(int passid, String name, String email, int mobile, String nationality) {
        this.passid = passid;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.nationality = nationality;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
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

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
