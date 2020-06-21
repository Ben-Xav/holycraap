package com.benmorant.game.holycraap.model.dao;

import com.benmorant.game.holycraap.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleDao extends JpaRepository<People, Integer> {

  People findByName(String name);
}
