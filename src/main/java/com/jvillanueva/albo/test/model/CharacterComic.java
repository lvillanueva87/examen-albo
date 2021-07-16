package com.jvillanueva.albo.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa el response de la APi. de Marvel
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class CharacterComic {

  /**
   * Título.
   */
  private String title;

  /**
   * Colaboradores.
   */
  private Colaborator creators;

  /**
   * Personajes.
   */
  private Character characters;
}
