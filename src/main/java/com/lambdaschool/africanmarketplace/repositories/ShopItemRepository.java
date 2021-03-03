package com.lambdaschool.africanmarketplace.repositories;

import com.lambdaschool.africanmarketplace.models.ShopItem;
import com.lambdaschool.africanmarketplace.models.ShopItemId;
import org.springframework.data.repository.CrudRepository;

public interface ShopItemRepository extends CrudRepository<ShopItem, ShopItemId> {
}
