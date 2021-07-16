package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Entidad de la tabla colaborators.
 * 
 * @author J. Villanueva
 *
 */
@Entity
@Table(name = H2Constants.TABLE_COLABORATORS)
@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
public class ColaboratorEntity extends CommonEntity {

  /**
   * Rol.
   */
  private String role;
}
