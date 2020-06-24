package com.benmorant.game.holycraap.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private Integer id;
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @OneToOne @MapsId private People people;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Item> items;
}
