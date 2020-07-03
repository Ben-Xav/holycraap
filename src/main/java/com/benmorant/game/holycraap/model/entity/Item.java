package com.benmorant.game.holycraap.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Data
// @NoArgsConstructor
@Entity
@Table(name = "item")
public class Item implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private int slot;

  private double price;

  public Item() {}

  public Item(String name, int slot, double price) {
    this.name = name;
    this.slot = slot;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSlot() {
    return slot;
  }

  public void setSlot(int slot) {
    this.slot = slot;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Item)) return false;
    return id != null && id.equals(((Item) o).getId());
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "Item{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", slot="
        + slot
        + ", price="
        + price
        + '}';
  }
}
