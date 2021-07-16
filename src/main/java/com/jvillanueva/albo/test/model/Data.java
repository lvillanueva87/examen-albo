package com.jvillanueva.albo.test.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa el response de la Api de Marvel al más alto nivel.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class Data {

  /**
   * Offset.
   */
  private int offset;

  /**
   * Límite registros por página.
   */
  private int limit;

  /**
   * Total de resultados.
   */
  private Long total;

  /**
   * lista de creadores, carácteres y comics.
   */
  private List<CharacterComic> results;
}
