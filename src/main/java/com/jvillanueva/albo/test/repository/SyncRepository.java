package com.jvillanueva.albo.test.repository;

import com.jvillanueva.albo.test.constants.H2Constants;
import com.jvillanueva.albo.test.domain.SyncEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/**
 * Repositorio para Sycn.
 * 
 * @author J. Villanueva
 *
 */
public interface SyncRepository extends JpaRepository<SyncEntity, String> {

  /**
   * Método para obtener la última fecha de actualización.
   * 
   * @return Sync
   */
  @Query(value = H2Constants.FIND_LAST_SYNC, nativeQuery = true)
  Optional<SyncEntity> getLastSyncDate();
}
