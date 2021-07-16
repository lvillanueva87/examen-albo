package com.jvillanueva.albo.test.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Base para entidades que comparten las mismas columnas.
 * 
 * @author J. Villanueva
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
public class CommonEntity {

  /**
   * Primary key.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  /**
   * Nombre.
   */
  private String name;
}
