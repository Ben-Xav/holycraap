package com.benmorant.game.holycraap.model.dao;

import com.benmorant.game.holycraap.model.entity.Item;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

  Optional<Item> findByName(String name);
}
