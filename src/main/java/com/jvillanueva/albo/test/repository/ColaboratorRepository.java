package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.constants.H2Constants;
import com.jvillanueva.albo.test.domain.ColaboratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para búsquedas en la tabla colaboradores.
 * 
 * @author J. Villanueva
 *
 */
public interface ColaboratorRepository extends JpaRepository<ColaboratorEntity, String> {

  /**
   * Método que busca colaborador por nombre.
   * 
   * @param pName
   * @return colaborator
   */
  @Query(value = H2Constants.FIND_BY_NAME_COLABORATOR, nativeQuery = true)
  Optional<ColaboratorEntity> findColaboratorByName(String pName);

  /**
   * Método que busca los colaboradores asociados a un heroe.
   * 
   * @param pHeroName
   * @return colaboratorList
   */
  @Query(value = H2Constants.FIND_COLABORATORS_BY_IDHERO, nativeQuery = true)
  List<ColaboratorEntity> findColaboratorsByIdHero(String pIdHero);
}
