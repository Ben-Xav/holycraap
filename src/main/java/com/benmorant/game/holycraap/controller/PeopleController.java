package com.benmorant.game.holycraap.controller;

import com.benmorant.game.holycraap.model.business.PeopleService;
import com.benmorant.game.holycraap.model.entity.People;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PeopleController {

  private final Logger log = LoggerFactory.getLogger(PeopleController.class);

  @Autowired private PeopleService peopleService;

  public PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @GetMapping("/people")
  Collection<People> peopleCollection() {
    return peopleService.getAllPeople();
  }

  @GetMapping("/people/{id}")
  ResponseEntity<?> getPeople(@PathVariable Integer id) {
    Optional<People> peopleOptional = peopleService.getById(id);
    return peopleOptional
        .map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/people")
  ResponseEntity<People> createPeople(@Valid @RequestBody People people) throws URISyntaxException {
    log.info("Request to create group: {}", people);
    People result = peopleService.saveInBase(people);
    return ResponseEntity.created(new URI("/api/people/" + result.getId())).body(result);
  }

  @PutMapping("/people/{id}")
  ResponseEntity<People> updatePeople(@Valid @RequestBody People people) {
    log.info("Request to update people: {}", people);
    People result = peopleService.saveInBase(people);
    return ResponseEntity.ok().body(result);
  }

  /** Method for deleting a people by id. */
  @DeleteMapping("/people/{id}")
  public ResponseEntity<?> deletePeople(@PathVariable Integer id) {
    log.info("Request to delete people: {}", id);
    peopleService.removeById(id);
    return ResponseEntity.ok().build();
  }
}
