package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.domain.HeroCharacterRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para búsquedas en la tabla heros_colaborators.
 * 
 * @author J. Villanueva
 *
 */
public interface HeroCharacterRepository extends JpaRepository<HeroCharacterRelEntity, String> {
}
