package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla sync.
 * 
 * @author J. Villanueva
 *
 */
@Entity
@Table(name = H2Constants.TABLE_SYNC)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SyncEntity {

  /**
   * Primary key.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  /**
   * Última actualización.
   */
  @Column(name = "last_sync")
  private LocalDateTime lastSync;
}
