package com.jvillanueva.albo.test.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Calse que representa el response de la APi de Marvel colaboradores.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class Colaborator {

  /**
   * Lista de colaboradores.
   */
  private List<Item> items;
}
