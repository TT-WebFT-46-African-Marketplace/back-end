package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> findALl();

    Item findItemById(long id);

    void delete(long id);

    Item save(Item item);

    Item update(long id, Item item);

    void deleteAll();
}
