package com.jvillanueva.albo.test.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constantes generales.
 * 
 * @author J. Villanueva
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  /**
   * Constante Path base del ms.
   */
  public static final String BASE_PATH = "/marvel";

  /**
   * Constante recurso colaboradores.
   */
  public static final String COLABORATORS_RESOURCE = "/colaborators/{character}";

  /**
   * Constante recurso personajes.
   */
  public static final String CHARACTERS_RESOURCE = "/characters/{character}";

  /**
   * Constante para la Path variable character.
   */
  public static final String PATH_CHARACTER = "character";

  /**
   * Constante paquete base.
   */
  public static final String PACKAGE_ALL = "com.jvillanueva.albo.test";

  /**
   * Constante String vacío.
   */
  public static final String EMPTY_STRING = "";

  /**
   * Constante nombre Iron Man.
   */
  public static final String IRON_MAN = "ironman";

  /**
   * Constante nombre Captain America.
   */
  public static final String CAP_AMERICA = "capamerica";

  /**
   * Constante que representa editors.
   */
  public static final String EDITOR = "editor";

  /**
   * Constante que representa inker.
   */
  public static final String INKER = "inker";

  /**
   * Constante que representa penciler.
   */
  public static final String PENCILER = "penciler";

  /**
   * Constante que representa penciler (cover).
   */
  public static final String PENCILER_COVER = "penciler (cover)";

  /**
   * Constante que representa penciller.
   */
  public static final String PENCILLER = "penciller";

  /**
   * Constante que representa penciller (cover).
   */
  public static final String PENCILLER_COVER = "penciller (cover)";

  /**
   * Constante que representa writer.
   */
  public static final String WRITER = "writer";

  /**
   * Constante que representa colorist.
   */
  public static final String COLORIST = "colorist";

  /**
   * Constante que representa colorist (cover).
   */
  public static final String COLORIST_COVER = "colorist (cover)";

  /**
   * Constante que representa other.
   */
  public static final String OTHER = "other";

  /**
   * Constante que representa artist.
   */
  public static final String ARTIST = "artist";

  /**
   * Constante formato fecha hora.
   */
  public static final String DATETIME_FORMAT = "dd/MM/yyyy hh:mm:ss";

  /**
   * Constante Cron Expresion.
   */
  public static final String CRON_EXP = "${constants.api.cron.expression}";

  /**
   * Constante log inicio servicio de actualización.
   */
  public static final String INIT_UPDATE_SERVICE =
      "Inicia llamado a servicio de actualización del personaje: {}";

  /**
   * Constante log fin servicio de actualización.
   */
  public static final String END_UPDATE_SERVICE =
      "Finaliza llamado a servicio de actualización del personaje: {}";

  /**
   * Constante log inicio servicio de obtención de colaboradores.
   */
  public static final String INIT_GET_COLABORATORS_SERVICE =
      "Inicia llamado a servicio de obtención colaboradores de comics del personaje: {}";

  /**
   * Constante log fin servicio de obtención de colaboradores.
   */
  public static final String END_GET_COLABORATORS_SERVICE =
      "Finaliza llamado a servicio de obtención colaboradores de comics del personaje: {}";

  /**
   * Constante log inicio servicio de obtención de personajes.
   */
  public static final String INIT_GET_CHARACTERS_SERVICE =
      "Inicia llamado a servicio de obtención personajes que interactuaron en comics del personaje: {}";

  /**
   * Constante log fin servicio de obtención de personajes.
   */
  public static final String END_GET_CHARACTERS_SERVICE =
      "Finaliza llamado a servicio de obtención personajes que interactuaron en comics del personaje: {}";

  /**
   * Constante log inicio método actualización BD.
   */
  public static final String INIT_BD_UPDATE = "Inicia actualización Base de datos del id_hero: {}";

  /**
   * Constante log fin método actualización DB.
   */
  public static final String END_BD_UPDATE = "Finaliza actualización Base de datos del id_hero: {}";

  /**
   * Constante log inicio método obtener idhero.
   */
  public static final String INIT_GET_IDHERO = "Inicia obtención idHero";

  /**
   * Constante log fin método obtener idhero.
   */
  public static final String END_GET_IDHERO = "Finaliza obtención idHero - result: {}";

  /**
   * Constante log inicio método obtener last_sync.
   */
  public static final String INIT_GET_LASTSYNC = "Inicia obtención última syncronización";

  /**
   * Constante log fin método obtener last_sync.
   */
  public static final String END_GET_LASTSYNC =
      "Finaliza obtención última syncronización - result: {}";

  /**
   * Constante mensaje Error Heroe no encontrado.
   */
  public static final String MSG_ERROR_HERO_NOT_FOUND =
      "El héroe solicitado no existe en Base de Datos";

  /**
   * Constante mensaje Error última sincronización no encontrada.
   */
  public static final String MSG_ERROR_LASTSYNC_NOT_FOUND =
      "No se encontró información de la última sincronización en Base de Datos";
  /**
   * Constante codigo not found.
   */
  public static final String CODE_NOT_FOUND = "404";
}
