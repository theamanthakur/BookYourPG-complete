package com.example.bookyourpg.models;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.List;

public class NewModel {
    public NewModel() {
    }

    public double lng;

    private List<String> IMAGES;

    public String city;

    public String price;

    public String name;

    public String description;

    public int discount;

    public String location;

    public String neighbour;

    public String state;

    public String category;

    public double lat;

    public NewModel(double lng, List<String> IMAGES, String city, String price, String name, String description, int discount, String location, String neighbour, String state, String category, double lat) {
        this.lng = lng;
        this.IMAGES = IMAGES;
        this.city = city;
        this.price = price;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.location = location;
        this.neighbour = neighbour;
        this.state = state;
        this.category = category;
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public List<String> getIMAGES() {
        return IMAGES;
    }

    public String getCity() {
        return city;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscount() {
        return discount;
    }

    public String getLocation() {
        return location;
    }

    public String getNeighbour() {
        return neighbour;
    }

    public String getState() {
        return state;
    }

    public String getCategory() {
        return category;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "NewModel{" +
                "lng=" + lng +
                ", IMAGES=" + IMAGES +
                ", city='" + city + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", location='" + location + '\'' +
                ", neighbour='" + neighbour + '\'' +
                ", state='" + state + '\'' +
                ", category='" + category + '\'' +
                ", lat=" + lat +
                '}';
    }
}