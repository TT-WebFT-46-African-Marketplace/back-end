package com.lambdaschool.africanmarketplace.repositories;

import com.lambdaschool.africanmarketplace.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
