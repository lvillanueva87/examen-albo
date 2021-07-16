package com.jvillanueva.albo.test.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase para representar una exepción cuando no se encuentran datos.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoDataFoundException extends RuntimeException {

  /**
   * Uuid autogenerado.
   */
  private static final long serialVersionUID = -7402088471583550317L;
  /**
   * Mensahe
   */
  private String message;
}
