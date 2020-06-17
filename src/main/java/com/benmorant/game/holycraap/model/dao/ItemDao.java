package com.benmorant.game.holycraap.model.dao;

import com.benmorant.game.holycraap.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {

  Item findByName(String name);

}