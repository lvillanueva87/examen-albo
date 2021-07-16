package com.jvillanueva.albo.test.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constantes para el cliente feign.
 * 
 * @author J. Villanueva
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FeignConstants {

  /**
   * Nombre del feign.
   */
  public static final String FEIGN_NAME = "MarvelFeign";

  /**
   * Url base del APi de Marvel.
   */
  public static final String URL_MARVEL_API = "https://gateway.marvel.com";

  /**
   * Recurso que se consume.
   */
  public static final String CHARACTER_COMICS_RESOURCE =
      "/v1/public/characters/{idCharacter}/comics";

  /**
   * Constante para el chacarcter id.
   */
  public static final String CHARACTER_ID = "idCharacter";

  /**
   * Constante para characters.
   */
  public static final String CHARACTERS = "characters";
}
