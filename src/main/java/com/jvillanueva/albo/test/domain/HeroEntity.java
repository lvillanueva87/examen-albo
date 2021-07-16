package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que reporesenta la tabla heros.
 * 
 * @author J. Villanueva
 *
 */
@Getter
@Setter
@Entity
@Table(name = H2Constants.TABLE_HERO)
public class HeroEntity extends CommonEntity {

  /**
   * Columna resource_name.
   */
  @Column(name = H2Constants.RESOURCE_NAME)
  private String resourceName;
}
