package com.jvillanueva.albo.test.component;

import com.jvillanueva.albo.test.constants.Constants;
import com.jvillanueva.albo.test.exceptions.NoDataFoundException;
import com.jvillanueva.albo.test.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * Clase que maneja la respuesta del servicio, dada una excepción.
 * 
 * @author J. Villanueva
 *
 */
@RestControllerAdvice
public class ErrorResolver {

  /**
   * Método que maneja la excepción NoDataFoundException.
   * 
   * @param ex
   * @return errorResponse
   */
  @ExceptionHandler(NoDataFoundException.class)
  public ResponseEntity<ErrorResponse> resolveFeignException(HttpServletRequest req,
      HttpServletResponse resp, NoDataFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setPath(req.getRequestURI());
    errorResponse.setDetails(ex.getMessage());
    errorResponse.setCode(Constants.CODE_NOT_FOUND);
    errorResponse.setTimestamp(LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
