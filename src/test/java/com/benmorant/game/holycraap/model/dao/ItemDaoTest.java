package com.benmorant.game.holycraap.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.benmorant.game.holycraap.model.entity.Item;
import java.util.Collection;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemDaoTest {

  @Autowired private ItemDao itemDao;

  @Test
  public void shouldReturnAllItems() {
    final String name = "SomeItemDao";
    final int slot = 2;
    final double price = 1.45;

    final Collection<Item> firstList = itemDao.findAll();
    assertThat(firstList).isNotNull();

    final Item input = new Item();
    input.setPrice(price);
    input.setSlot(slot);
    input.setName(name);

    final Item result = itemDao.save(input);
    assertThat(result).isNotNull();
    assertThat(result.getPrice()).isEqualTo(price);
    assertThat(result.getSlot()).isEqualTo(slot);
    assertThat(result.getName()).isEqualTo(name);

    final Collection<Item> resultList = itemDao.findAll();
    assertThat(firstList).doesNotContain(result);
    assertThat(resultList).contains(result);
  }

  @Test
  public void findByName_shouldReturnPeople_whenEntryIsAdded() {
    String name = "Vase Ming";
    Item item = new Item();
    item.setName(name);
    itemDao.save(item);
    Optional<Item> actual = itemDao.findByName(name);
    assertThat(actual).isNotEmpty();
    assertThat(actual).contains(item);
  }

  @Test
  public void save_shouldUpdateName_whenEntryIsSettedandSaved() {
    String name1 = "Poudre de Perlimpimpin";
    Item item = new Item();
    item.setName(name1);
    itemDao.save(item);
    Optional<Item> actual1 = itemDao.findByName(name1);
    assertThat(actual1).isNotEmpty();
    assertThat(actual1).contains(item);
    String name2 = "de la DroGUe";
    item.setName(name2);
    itemDao.save(item);
    Optional<Item> actual2 = itemDao.findByName(name2);
    assertThat(actual2).isNotEmpty();
    assertThat(actual2).contains(item);
  }
}
