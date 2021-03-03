package com.lambdaschool.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass (ShopItemId.class)
@Table (name = "shopitems")
public class ShopItem extends Auditable implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "shops", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "itemid")
    @JsonIgnoreProperties(value = "shops", allowSetters = true)
    private Item item;

    private long quantity;

    public ShopItem(){
    }

    public ShopItem(User user, Item item, long quantity) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopItem shopItem = (ShopItem) o;
        return ((user == null) ? 0 : user.getUserid()) == ((shopItem.user == null) ? 0 : shopItem.user.getUserid()) &&
            ((item == null) ? 0: item.getItemid()) == ((shopItem.item == null) ? 0 : shopItem.item.getItemid());
    }

    @Override
    public int hashCode() {
        return 7;
    }
}

