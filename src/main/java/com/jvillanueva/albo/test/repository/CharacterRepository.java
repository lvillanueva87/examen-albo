package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.constants.H2Constants;
import com.jvillanueva.albo.test.domain.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/**
 * Repositorio para la tabla characters.
 * 
 * @author J. Villanueva
 *
 */
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {

  /**
   * Método que busca los personajes dado un nombre.
   * 
   * @param pName
   * @return character
   */
  @Query(value = H2Constants.FIND_BY_NAME_CHARACTER, nativeQuery = true)
  Optional<CharacterEntity> findCharacterByName(String pName);
}
