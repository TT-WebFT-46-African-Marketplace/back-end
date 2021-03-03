package com.lambdaschool.africanmarketplace.controllers;

import com.lambdaschool.africanmarketplace.models.Item;
import com.lambdaschool.africanmarketplace.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
   @Autowired
    private ItemService itemService;

   @GetMapping(value = "/items", produces = {"application/json"})
    public ResponseEntity<?> listALlItems(){
       List<Item> myItems = itemService.findALl();
       return new ResponseEntity<>(myItems, HttpStatus.OK);
   }

    @GetMapping(value = "/item/{itemid}", produces = {"application/json"})
    public ResponseEntity<?> getItemById(@PathVariable Long itemid){
       Item i = itemService.findItemById(itemid);
       return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping(value = "/item")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item newItem){
       newItem.setItemid(0);
       newItem = itemService.save(newItem);

       HttpHeaders responseHeaders = new HttpHeaders();
       URI newItemURI = ServletUriComponentsBuilder.fromCurrentRequest()
           .path("/{userid}")
           .buildAndExpand(newItem.getItemid())
           .toUri();
       responseHeaders.setLocation(newItemURI);

       return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/item/{itemid}")
    public ResponseEntity<?> updateItemById(
       @RequestBody Item updateItem, @PathVariable long itemid){
       itemService.update(itemid, updateItem);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/item/{itemid}")
    public ResponseEntity<?> getItemById(@PathVariable long itemid){
       itemService.delete(itemid);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
