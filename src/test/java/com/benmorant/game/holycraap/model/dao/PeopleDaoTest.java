package com.benmorant.game.holycraap.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.benmorant.game.holycraap.model.entity.Item;
import com.benmorant.game.holycraap.model.entity.People;
import java.util.Collection;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class PeopleDaoTest {

  @Autowired private PeopleDao peopleDao;

  @Autowired private DataSource dataSource;
  @Autowired private JdbcTemplate jdbcTemplate;
  @Autowired private EntityManager entityManager;

  @Test
  public void contextLoads() {
    assertThat(dataSource).isNotNull();
    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(peopleDao).isNotNull();
  }

  @Test
  public void shouldReturnAllPeople() {
    final String name = "somePeopleDao";
    final int hp = 10;
    final int hpMax = 11;
    final int mp = 12;
    final int mpMax = 13;
    final Item item = new Item();

    final Collection<People> firstList = peopleDao.findAll();
    assertThat(firstList).isNotNull();

    final People input = new People();
    input.setCurrentHp(hp);
    input.setCurrentMp(mp);
    input.setHpMax(hpMax);
    input.setMpMax(mpMax);
    input.setName(name);
    input.addItem(item);

    final People result = peopleDao.save(input);
    assertThat(result).isNotNull();
    assertThat(result.getCurrentHp()).isEqualTo(hp);
    assertThat(result.getCurrentMp()).isEqualTo(mp);
    assertThat(result.getHpMax()).isEqualTo(hpMax);
    assertThat(result.getMpMax()).isEqualTo(mpMax);
    assertThat(result.getName()).isEqualTo(name);
    assertThat(result.getInventory()).contains(item);

    final Collection<People> resultList = peopleDao.findAll();
    assertThat(firstList).doesNotContain(result);
    assertThat(resultList).contains(result);
  }

  @Test
  public void findByName_shouldReturnPeople_whenEntryIsAdded() {
    final String name = "LeChuck";
    final People leChuck = new People();
    leChuck.setName(name);
    peopleDao.save(leChuck);
    final Optional<People> actual = peopleDao.findByName(name);
    assertThat(actual).isNotEmpty();
    assertThat(actual).contains(leChuck);
  }

  @Test
  public void save_shouldUpdateName_whenEntryIsSettedandSaved() {
    final String name1 = "LeChuck";
    final People leChuck = new People();
    leChuck.setName(name1);
    peopleDao.save(leChuck);
    final Optional<People> actual1 = peopleDao.findByName(name1);
    assertThat(actual1).isNotEmpty();
    assertThat(actual1).contains(leChuck);
    String name2 = "Elaine Marley";
    leChuck.setName(name2);
    peopleDao.save(leChuck);
    final Optional<People> actual2 = peopleDao.findByName(name2);
    assertThat(actual2).isNotEmpty();
    assertThat(actual2).contains(leChuck);
  }
}
