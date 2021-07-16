package com.jvillanueva.albo.test.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa los personajes del response de la Api de Marvel.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class Character {

  /**
   * Lista de personajes.
   */
  private List<Item> items;
}
