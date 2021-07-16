package com.jvillanueva.albo.test.component;

import com.jvillanueva.albo.test.constants.Constants;
import com.jvillanueva.albo.test.service.CharacterInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Clase que ejecuta la actualización cada que levanta la app.
 * 
 * @author J. Villanueva
 *
 */
@Component
public class StartAppResolver implements CommandLineRunner {

  /**
   * Inyección servicio de actualización.
   */
  @Autowired
  private CharacterInformationService service;

  /**
   * Método que orquesta el llamado para la actualización de Información de IronMan y Captain
   * América.
   */
  @Override
  public void run(String... args) throws Exception {
    service.getCharacterInformation(Constants.CAP_AMERICA);
    service.getCharacterInformation(Constants.IRON_MAN);
  }
}
