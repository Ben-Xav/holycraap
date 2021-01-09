package com.benmorant.game.holycraap.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item implements Serializable {

  private static final long serialVersionUID = -194265094836903844L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private int slot;

  private double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  private People people;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    return id != null && id.equals(((Item) o).getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, slot, price, people);
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
