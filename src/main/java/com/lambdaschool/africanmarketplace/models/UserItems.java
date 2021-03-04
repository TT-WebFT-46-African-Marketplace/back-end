package com.lambdaschool.africanmarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "useritems")
@IdClass(UserItemsId.class)
public class UserItems extends Auditable implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "items", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "itemid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Item item;

    public UserItems(){
    }

    public UserItems(User user, Item item) {
        this.user = user;
        this.item = item;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserItems))
        {
            return false;
        }
        UserItems that = (UserItems) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
            ((item == null) ? 0 : item.getItemcode()) == ((that.item == null) ? 0 : that.item.getItemcode());
    }

    @Override
    public int hashCode()
    {
        // return Objects.hash(user.getUserid(), role.getRoleid());
        return 37;
    }
}
