package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.models.Item;


import java.util.List;

public interface ItemService {
    List<Item> listAllItems();
    Item save(Item item);
    void deleteAllItems();
    Item findItemById(long id);

    List<Item> findAll();

    void delete(long itemcode);
}