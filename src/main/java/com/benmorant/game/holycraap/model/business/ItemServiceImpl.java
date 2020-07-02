package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.dao.ItemDao;
import com.benmorant.game.holycraap.model.entity.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

  @Autowired ItemDao itemDao;

  @Override
  public Item saveInBase(Item item) {
    return itemDao.save(item);
  }

  @Override
  public Item getByName(String name) {
    return itemDao.findByName(name);
  }

  @Override
  public Optional<Item> getById(Integer id) {
    return itemDao.findById(id);
  }

  @Override
  public List<Item> getAllItems() {
    return itemDao.findAll();
  }

  @Override
  public void removeById(Integer id) {
    itemDao.deleteById(id);
  }
}
