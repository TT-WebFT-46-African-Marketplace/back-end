package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.exceptions.ResourceNotFoundException;
import com.lambdaschool.africanmarketplace.models.Item;
import com.lambdaschool.africanmarketplace.models.ShopItem;
import com.lambdaschool.africanmarketplace.models.ShopItemId;
import com.lambdaschool.africanmarketplace.models.User;
import com.lambdaschool.africanmarketplace.repositories.ItemRepository;
import com.lambdaschool.africanmarketplace.repositories.ShopItemRepository;
import com.lambdaschool.africanmarketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service ("shopService")
public class ShopItemServiceImpl implements ShopItemService {
    @Autowired
    private UserRepository userrepos;

    @Autowired
    private ItemRepository itemrepos;

    @Autowired
    private ShopItemRepository shopitemrepos;

    @Override
    public ShopItem addToStock(long userid, long itemid){
        User workingUser = userrepos.findById(userid)
            .orElseThrow(()-> new ResourceNotFoundException("User id " + userid + " not found!"));

        Item workingItem = itemrepos.findById(itemid)
            .orElseThrow(()-> new ResourceNotFoundException("Item id " + itemid + " not found!"));

        ShopItem workingShopItem = shopitemrepos.findById(new ShopItemId(userid, itemid))
            .orElse(new ShopItem(workingUser, workingItem, 0));

        workingShopItem.setQuantity(workingShopItem.getQuantity() + 1);
        return shopitemrepos.save(workingShopItem);
    }

    @Override
    public ShopItem removeFromStock(long userid, long itemid){
        User workingUser = userrepos.findById(userid)
            .orElseThrow(()-> new ResourceNotFoundException("User id " + userid + " not found!"));

        Item workingItem = itemrepos.findById(itemid)
            .orElseThrow(()-> new ResourceNotFoundException("Item id " + itemid + " not found!"));

        ShopItem workingShopItem = shopitemrepos.findById(new ShopItemId(userid, itemid))
            .orElseThrow(()-> new ResourceNotFoundException("Item " + itemid + " not found in stock"));

        workingShopItem.setQuantity(workingShopItem.getQuantity() - 1);

        if(workingShopItem.getQuantity() <= 0){
            shopitemrepos.deleteById(new ShopItemId(userid, itemid));
            return null;
        } else {
            return shopitemrepos.save(workingShopItem);
        }
    }
}
