package com.benmorant.game.holycraap.model.dao;

import com.benmorant.game.holycraap.model.entity.People;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People, Integer> {
  Optional<People> findByName(String name);
}
