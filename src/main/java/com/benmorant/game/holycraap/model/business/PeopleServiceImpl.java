package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.dao.PeopleDao;
import com.benmorant.game.holycraap.model.entity.People;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

  @Autowired PeopleDao peopleDao;

  @Override
  public People saveInBase(People people) {
    return peopleDao.save(people);
  }

  @Override
  public Optional<People> getByName(String name) {
    return peopleDao.findByName(name);
  }

  @Override
  public Optional<People> getById(Integer id) {
    return peopleDao.findById(id);
  }

  @Override
  public List<People> getAllPeople() {
    return peopleDao.findAll();
  }

  @Override
  public void removeById(Integer id) {
    peopleDao.deleteById(id);
  }
}
