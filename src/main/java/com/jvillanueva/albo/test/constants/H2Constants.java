package com.jvillanueva.albo.test.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Constantes para H2.
 * 
 * @author J. Villanueva
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class H2Constants {

  /**
   * Query busqueda heroe por nombre.
   */
  public static final String FIND_BY_NAME_HERO =
      "SELECT id, name, resource_name FROM HEROS WHERE resource_name = :pName";

  /**
   * Query busqueda personajes por nombre.
   */
  public static final String FIND_BY_NAME_CHARACTER =
      "SELECT id, name FROM CHARACTERS WHERE name = :pName";

  /**
   * Query busqueda colaboradores por nombre.
   */
  public static final String FIND_BY_NAME_COLABORATOR =
      "SELECT id, name, role FROM COLABORATORS WHERE name = :pName";

  /**
   * Query busqueda colaboradores por id_hero.
   */
  public static final String FIND_COLABORATORS_BY_IDHERO =
      "SELECT id, name, role FROM COLABORATORS WHERE id IN(SELECT id_colaborator FROM HEROS_COLABORATORS WHERE id_hero = :pIdHero)";

  /**
   * Query busqueda personajes y comics por id_hero.
   */
  public static final String FIND_CHARACTERS_BY_IDHERO =
      "SELECT c.name as character_name, hc.title FROM HEROS_CHARACTERS hc, CHARACTERS c WHERE hc.id_hero = :pHeroId AND hc.id_character = c.id AND c.name != :pName";

  /**
   * Query que obtiene la última fecha de syncronización de la BD con la API de Marvel.
   */
  public static final String FIND_LAST_SYNC =
      "SELECT id, last_sync FROM SYNC ORDER BY last_sync DESC LIMIT 1";

  /**
   * Nombre tabla heroe.
   */
  public static final String TABLE_HERO = "HEROS";

  /**
   * Nombre tabla personajes.
   */
  public static final String TABLE_CHARACTERS = "CHARACTERS";

  /**
   * Nombre tabla colaboradores.
   */
  public static final String TABLE_COLABORATORS = "COLABORATORS";

  /**
   * Nombre tabla Sync.
   */
  public static final String TABLE_SYNC = "SYNC";

  /**
   * Nombre tabla heroes_colaboradores.
   */
  public static final String TABLE_HEROS_COLABORATORS_REL = "HEROS_COLABORATORS";

  /**
   * Nombre tabla heros_personajes.
   */
  public static final String TABLE_HEROS_CHARACTERS_REL = "HEROS_CHARACTERS";

  /**
   * Nombre columna id heroe.
   */
  public static final String ID_HERO = "id_hero";

  /**
   * Nombre columna id colaborador.
   */
  public static final String ID_COLABORATOR = "id_colaborator";

  /**
   * Nombre columna id personaje.
   */
  public static final String ID_CHARACTER = "id_character";

  /**
   * Nombre columna título.
   */
  public static final String TITLE = "title";

  /**
   * Nombre columna character_name.
   */
  public static final String CHARACTER_NAME = "character_name";

  /**
   * Nombre columna resource_name.
   */
  public static final String RESOURCE_NAME = "resource_name";
}
