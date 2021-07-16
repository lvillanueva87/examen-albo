package com.jvillanueva.albo.test.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa la Primary key compuesta de la relación heros_colaborators.
 * 
 * @author J. Villanueva
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeroColaboratorId implements Serializable {

  /**
   * Uuid autogenerado.
   */
  private static final long serialVersionUID = -4012248821549960135L;

  /**
   * Id Heroe.
   */
  private String idHero;

  /**
   * Id Colaborador.
   */
  private String idColaborator;
}
