package com.jvillanueva.albo.test.api;

import com.jvillanueva.albo.test.constants.Constants;
import com.jvillanueva.albo.test.model.CharactersResponse;
import com.jvillanueva.albo.test.model.ColaboratorsResponse;
import com.jvillanueva.albo.test.service.CharacterInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que expone los endpoints para consultar la información de la BD.
 * 
 * @author J. Villanueva
 *
 */
@RestController
@RequestMapping(Constants.BASE_PATH)
public class CharacterInformationApi {

  /**
   * Inyección servicio de actualización.
   */
  @Autowired
  private CharacterInformationService service;

  /**
   * Método que obtiene los colaboradores dado un personaje de Marvel.
   * 
   * @param character
   * @return ResponseEntity response
   */
  @GetMapping(path = Constants.COLABORATORS_RESOURCE)
  public ResponseEntity<ColaboratorsResponse> getColaboratorsByCharacter(
      @PathVariable(name = Constants.PATH_CHARACTER) String character) {
    service.getColaboratorsFromDbByHero(character);
    return new ResponseEntity<>(service.getColaboratorsFromDbByHero(character), HttpStatus.OK);
  }

  /**
   * Método que obtiene los personales con los que ha interactuado cierto Avenger.
   * 
   * @param character
   * @return ResponseEntity response
   */
  @GetMapping(path = Constants.CHARACTERS_RESOURCE)
  public ResponseEntity<CharactersResponse> getCharactersRelations(
      @PathVariable(name = Constants.PATH_CHARACTER) String character) {
    return new ResponseEntity<>(service.getCharactersFromDbByHero(character), HttpStatus.OK);
  }
}
