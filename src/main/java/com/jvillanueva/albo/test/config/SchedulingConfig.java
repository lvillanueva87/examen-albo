package com.jvillanueva.albo.test.config;

import com.jvillanueva.albo.test.constants.Constants;
import com.jvillanueva.albo.test.service.CharacterInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Clase que Define la calendarización de la ejecución de actualización.
 * 
 * @author J. Villanueva
 *
 */
@Component
public class SchedulingConfig {

  /**
   * Inyección servicio de actualización.
   */
  @Autowired
  private CharacterInformationService service;

  /**
   * Método que orquesta el llamado a la API de Marvel y la actualización de la BD cada cierto
   * tiempo.
   */
  @Scheduled(cron = Constants.CRON_EXP)
  public void scheduleUpdateInformation() {
    service.getCharacterInformation(Constants.IRON_MAN);
    service.getCharacterInformation(Constants.CAP_AMERICA);
  }
}
