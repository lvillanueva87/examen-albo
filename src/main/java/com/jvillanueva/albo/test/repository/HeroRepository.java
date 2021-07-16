package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.constants.H2Constants;
import com.jvillanueva.albo.test.domain.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/**
 * Repositorio para la tabla Heros.
 * 
 * @author J. Villanueva
 *
 */
public interface HeroRepository extends JpaRepository<HeroEntity, String> {

  /**
   * Método que obtiene el heroe dado un nombre.
   * 
   * @param pName
   * @return optionalHeroEntity
   */
  @Query(value = H2Constants.FIND_BY_NAME_HERO, nativeQuery = true)
  Optional<HeroEntity> findHeroByName(String pName);
}
