package com.jvillanueva.albo.test.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase error para respuesta del controlador.
 */
@Getter
@Setter
public class ErrorResponse {

  /**
   * Path.
   */
  private String path;

  /**
   * Código del error.
   */
  private String code;

  /**
   * Detalles del error.
   */
  private String details;

  /**
   * Fecha y hora cuando ocurre el error.
   */
  private LocalDateTime timestamp;
}
