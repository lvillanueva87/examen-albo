package com.jvillanueva.albo.test.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la primary key compuesta de la tabla heros_characters.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroCharacterId implements Serializable {

  /**
   * Uuid autogenerada.
   */
  private static final long serialVersionUID = -4012248821549960135L;

  /**
   * Id del heroe.
   */
  private String idHero;

  /**
   * Id del personaje.
   */
  private String idCharacter;

  /**
   * Título.
   */
  private String title;
}
