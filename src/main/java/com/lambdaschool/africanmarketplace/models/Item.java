package com.lambdaschool.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "items")
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long itemcode;


    private String name;
    private String type;
    private String description;
    private String location;
    private double itemcost;

    public Item() {
    }

    public Item(String name, String type, String description, String location, double itemcost, User user) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.location = location;
        this.itemcost = itemcost;
        this.user = user;
    }


    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    @JsonIgnoreProperties("items")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getItemcode() {
        return itemcode;
    }

    public void setItemcode(long itemcode) {
        this.itemcode = itemcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getItemcost() {
        return itemcost;
    }

    public void setItemcost(double itemcost) {
        this.itemcost = itemcost;
    }
}


