package com.example.recycleviewapp;

public class Product {
    private long id;
    private String name;
    private int thumbnail;
    private double price;

    public Product() {
    }

    public Product(long id, String name, int thumbnail, double price) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
