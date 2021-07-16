package com.jvillanueva.albo.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa el response del Api de Marvel.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
public class MarvelApiResponse {

  /**
   * Objetos del response.
   */
  private Data data;
}
