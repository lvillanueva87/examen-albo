package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.domain.HeroColaboratorRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la tabla heros_colaborators.
 * 
 * @author J. Villanueva
 *
 */
public interface HeroColaboratorRepository extends JpaRepository<HeroColaboratorRelEntity, String> {
}
