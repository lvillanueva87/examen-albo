package com.jvillanueva.albo.test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase para representar la respuesta del recurso characters.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class CharactersResponse {

  /**
   * Fecha de última sincronización.
   */
  private String last_sync;

  /**
   * Lista de personajes y los comics donde hacen aparición.
   */
  private List<CharacterInteraction> characters;

  /**
   * Constructor NoArgs
   */
  public CharactersResponse() {
    characters = new ArrayList<>();
  }
}
