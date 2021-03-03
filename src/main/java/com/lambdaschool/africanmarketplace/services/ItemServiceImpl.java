package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.exceptions.ResourceFoundException;
import com.lambdaschool.africanmarketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.africanmarketplace.models.Item;
import com.lambdaschool.africanmarketplace.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service ("itemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    UserAuditing userAuditing;

    @Autowired
    ItemRepository itemrepos;

    @Autowired
    ShopItemService shopService;

    @Override
    public List<Item> findALl() {
        List<Item> list = new ArrayList<>();
        itemrepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Item findItemById(long id) {
        return itemrepos.findById(id)
            .orElseThrow(()-> new ResourceAccessException("Item with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id) {
        itemrepos.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Item id " + id + " not found!"));
    }

    @Transactional
    @Override
    public Item save(Item item) {
        if(item.getStock().size() > 0){
            throw new ResourceFoundException("Shops are not updates through Items");
        }
        Item newItem = new Item();
        if(item.getItemid() != 0){
            newItem = itemrepos.findById(item.getItemid())
                .orElseThrow(()-> new ResourceNotFoundException("Item id " + item.getItemid() + " not found"));
        }
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        return itemrepos.save(newItem);
    }

    @Transactional
    @Override
    public Item update(long id, Item item) {

        if(item.getStock().size() > 0){
            throw new ResourceFoundException("Shops.cannot be updated through this process");
        }

        Item currentItem = itemrepos.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Item id " + id + " not found"));

        if(item.getName() != null){
            currentItem.setName(item.getName());
        }
        if(item.hasPrice){
            currentItem.setPrice(item.getPrice());
        }
        if(item.getDescription() != null){
            currentItem.setDescription(item.getDescription());
        }
        return itemrepos.save(currentItem);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll() {
        itemrepos.deleteAll();
    }
}
