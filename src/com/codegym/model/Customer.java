package com.codegym.model;

public class Customer {
    private int id;
    private String name;
    private String image;
    private Province province;

    public Customer() {
    }

    public Customer(int id, String name, String image, Province province) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
