package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.entity.People;
import java.util.List;

public interface PeopleService {

  People saveInBase(People people);

  People getByName(String name);

  List<People> getAllPeople();

}
