package com.benmorant.game.holycraap.controller;

import com.benmorant.game.holycraap.model.business.ItemService;
import com.benmorant.game.holycraap.model.entity.Item;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ItemController {

  @Autowired private ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/items")
  Collection<Item> itemCollection() {
    return itemService.getAllItems();
  }

  @GetMapping("/items/{id}")
  ResponseEntity<?> getItem(@PathVariable Integer id) {
    Optional<Item> itemOptional = itemService.getById(id);
    return itemOptional
        .map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/items")
  ResponseEntity<Item> createItem(@Valid @RequestBody Item item) throws URISyntaxException {
    log.info("Request to create item: {}", item);
    Item result = itemService.saveInBase(item);
    return ResponseEntity.created(new URI("/api/items/" + result.getId())).body(result);
  }

  @PutMapping("/items/{id}")
  ResponseEntity<Item> updateItem(@Valid @RequestBody Item item) {
    log.info("Request to update item: {}", item);
    Item result = itemService.saveInBase(item);
    return ResponseEntity.ok().body(result);
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
    log.info("Request to delete item: {}", id);
    itemService.removeById(id);
    return ResponseEntity.ok().build();
  }
}
