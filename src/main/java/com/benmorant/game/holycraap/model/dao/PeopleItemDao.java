package com.benmorant.game.holycraap.model.dao;

import com.benmorant.game.holycraap.model.entity.PeopleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleItemDao extends JpaRepository<PeopleItem, Integer> {

}