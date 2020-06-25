package com.benmorant.game.holycraap.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "people")
public class People implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NonNull private String name;
  private int currentHp;
  private int hpMax;
  private int currentMp;
  private int mpMax;

  public int getCurrentHp() {
    return currentHp;
  }

  public int getCurrentMp() {
    return currentMp;
  }

  public int getHpMax() {
    return hpMax;
  }

  public Integer getId() {
    return id;
  }

  public int getMpMax() {
    return mpMax;
  }

  public String getName() {
    return name;
  }

  public void setCurrentHp(final int currentHp) {
    this.currentHp = currentHp;
  }

  public void setCurrentMp(final int currentMp) {
    this.currentMp = currentMp;
  }

  public void setHpMax(final int hpMax) {
    this.hpMax = hpMax;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setMpMax(final int mpMax) {
    this.mpMax = mpMax;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
