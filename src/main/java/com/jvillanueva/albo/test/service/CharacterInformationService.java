package com.jvillanueva.albo.test.service;

import com.jvillanueva.albo.test.model.CharactersResponse;
import com.jvillanueva.albo.test.model.ColaboratorsResponse;

/**
 * Interfáz que declara los métodos de la capa de negocio.
 * 
 * @author J. Villanueva
 *
 */
public interface CharacterInformationService {

  /**
   * Declaración método obtener información de la APi de Marvel.
   * 
   * @param heroName
   */
  void getCharacterInformation(String heroName);

  /**
   * Declaración método obtener colaboradores de comic del heroe.
   * 
   * @param heroName
   * @return colaboratorsResponse
   */
  ColaboratorsResponse getColaboratorsFromDbByHero(String heroName);

  /**
   * Delcaración método obtener personajes que interactuaron con el héroe.
   * 
   * @param heroName
   * @return characterResponse
   */
  CharactersResponse getCharactersFromDbByHero(String heroName);
}
