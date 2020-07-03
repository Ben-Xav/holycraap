package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.entity.People;
import java.util.List;
import java.util.Optional;

public interface PeopleService {

  People saveInBase(People people);

  Optional<People> getByName(String name);

  Optional<People> getById(Integer id);

  List<People> getAllPeople();

  void removeById(Integer id);
}
