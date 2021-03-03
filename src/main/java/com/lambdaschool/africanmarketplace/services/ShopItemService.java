package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.models.ShopItem;

import java.util.List;

public interface ShopItemService {
    ShopItem addToStock(long userid, long itemid);

    ShopItem removeFromStock(long userid, long itemid);
}
