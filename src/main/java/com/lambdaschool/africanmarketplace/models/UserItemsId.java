package com.lambdaschool.africanmarketplace.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserItemsId implements Serializable {
    private long user;

    private long item;

    public UserItemsId() {
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserItemsId that = (UserItemsId) o;
        return user == that.user &&
            item == that.item;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
