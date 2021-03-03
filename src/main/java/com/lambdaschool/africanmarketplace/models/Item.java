package com.lambdaschool.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "items")
@JsonIgnoreProperties(value = "hasPrice")
public class Item extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;

    @Column(nullable = false, unique = true)
    private String name;

    @Transient
    public boolean hasPrice = false;

    private double price;

    private String description;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "item", allowSetters = true)
    private Set<ShopItem> stock = new HashSet<>();

    public Item(){
    }

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        hasPrice = true;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ShopItem> getStock() {
        return stock;
    }

    public void setStock(Set<ShopItem> stock) {
        this.stock = stock;
    }
}

