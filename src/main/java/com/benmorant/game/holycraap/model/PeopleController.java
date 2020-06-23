package com.benmorant.game.holycraap.model;

import com.benmorant.game.holycraap.model.business.PeopleService;
import com.benmorant.game.holycraap.model.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/people")
public class PeopleController {
  @Autowired private PeopleService peopleService;

  /** This class just served as an attempt to follow one of Spring.io guides. */
  @PostMapping(path = "/add")
  public @ResponseBody String addNewPeople(
      @RequestParam String name,
      @RequestParam int currentHp,
      @RequestParam int hpMax,
      @RequestParam int currentMp,
      @RequestParam int mpMax) {

    People p = new People();
    p.setName(name);
    p.setCurrentHp(currentHp);
    p.setHpMax(hpMax);
    p.setCurrentMp(currentMp);
    p.setMpMax(mpMax);
    peopleService.saveInBase(p);
    return name + "added to database !";
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<People> getAllPeople() {

    return peopleService.getAllPeople();
  }
}
