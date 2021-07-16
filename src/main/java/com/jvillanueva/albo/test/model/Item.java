package com.jvillanueva.albo.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase base para response de personajes y colaboradores.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class Item {

  /**
   * Nombre.
   */
  private String name;

  /**
   * Rol.
   */
  private String role;
}
