package com.jvillanueva.albo.test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un objeto parte de la respuesta de CharacterResponse.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class CharacterInteraction {

  /**
   * Nombre del personaje.
   */
  private String character;

  /**
   * Lista de comics donde aparece.
   */
  private List<String> comics;

  /**
   * Constructor NoArgs
   */
  public CharacterInteraction() {
    this.comics = new ArrayList<>();
  }
}
