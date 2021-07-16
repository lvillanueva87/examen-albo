package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.constants.H2Constants;
import com.jvillanueva.albo.test.domain.HeroCharacterJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Repositorio para obtener la relación de personales y comics con el heroe.
 * 
 * @author J. Villanueva
 *
 */
public interface HeroCharacterJoinRepository
    extends JpaRepository<HeroCharacterJoinEntity, String> {

  /**
   * Método para obtener la relación de personajes y sus comics de aparición junto con el héroe.
   * 
   * @param pHeroId
   * @param pName
   * @return listCharacters
   */
  @Query(value = H2Constants.FIND_CHARACTERS_BY_IDHERO, nativeQuery = true)
  List<HeroCharacterJoinEntity> getHeroInteractionWithCharacters(String pHeroId, String pName);
}
