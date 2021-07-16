package com.jvillanueva.albo.test.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Clase para almacenar las propiedades de la Api.
 * 
 * @author J. Villanueva
 *
 */
@Component
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiValues {

  /**
   * Timestamp.
   */
  @Value("${constants.api.ts}")
  private String ts;

  /**
   * Llave pública.
   */
  @Value("${constants.api.public.key}")
  private String publicKey;

  /**
   * Llave privada.
   */
  @Value("${constants.api.private.key}")
  private String privateKey;

  /**
   * Límite registros.
   */
  @Value("${constants.api.maxlimit}")
  Long limit;
}
