package com.benmorant.game.holycraap.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "people")
public class People implements Serializable {

  private static final long serialVersionUID = 2284045645181170802L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NonNull private String name;
  private int currentHp;
  private int hpMax;
  private int currentMp;
  private int mpMax;

  @OneToMany(mappedBy = "people")
  @JsonManagedReference
  private List<Item> inventory = new ArrayList<>();

  public void addItem(Item item) {
    inventory.add(item);
    item.setPeople(this);
  }

  public void removeItem(Item item) {
    inventory.remove(item);
    item.setPeople(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof People)) {
      return false;
    }
    return id != null && id.equals(((People) o).getId());
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "People{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", currentHp="
        + currentHp
        + ", hpMax="
        + hpMax
        + ", currentMp="
        + currentMp
        + ", mpMax="
        + mpMax
        + ", inventory="
        + inventory
        + '}';
  }
}
