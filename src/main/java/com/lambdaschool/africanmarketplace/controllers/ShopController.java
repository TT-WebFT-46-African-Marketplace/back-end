package com.lambdaschool.africanmarketplace.controllers;

import com.lambdaschool.africanmarketplace.models.ShopItem;
import com.lambdaschool.africanmarketplace.models.User;
import com.lambdaschool.africanmarketplace.services.ShopItemService;
import com.lambdaschool.africanmarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private UserService userService;

    @GetMapping(value = " /user/{userid}", produces = {"apllication/json"})
    public ResponseEntity<?> listShopItemsByUserId(@PathVariable long userid){
        User u = userService.findUserById(userid);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping(value = "/add/user/{userid}/item/{itemid}", produces = {"apllication/json"})
    public ResponseEntity<?> addToStock(@PathVariable long userid, @PathVariable long itemid){
        ShopItem addShopItem = shopItemService.addToStock(userid, itemid);
        return new ResponseEntity<>(addShopItem, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/user/{userid}/item/{itemid}", produces = {"application/json"})
    public ResponseEntity<?> removeFromStock(@PathVariable long userid, @PathVariable long itemid){
        ShopItem removeShopItem = shopItemService.removeFromStock(userid, itemid);
        return new ResponseEntity<>(removeShopItem, HttpStatus.OK);
    }
}
