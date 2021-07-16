package com.jvillanueva.albo.test.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la primary key compuesta de la relación heros_characters.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroCharacterJoinId implements Serializable {

  /**
   * Uuid autogenerado.
   */
  private static final long serialVersionUID = -8193590679803504667L;

  /**
   * Nombre del personaje.
   */
  private String characterName;

  /**
   * Título del comic.
   */
  private String title;
}
