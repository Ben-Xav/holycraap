package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.entity.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {

  Item saveInBase(Item item);

  Item getByName(String name);

  Optional<Item> getById(Integer id);

  List<Item> getAllItems();

  void removeById(Integer id);
}
