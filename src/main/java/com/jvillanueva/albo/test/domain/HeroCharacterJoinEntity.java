package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad para obtener la relación
 * 
 * @author J. Villanueva
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@IdClass(HeroCharacterJoinId.class)
public class HeroCharacterJoinEntity implements Serializable {

  /**
   * Uuid autogenerado.
   */
  private static final long serialVersionUID = 3798371018766365721L;

  /**
   * Nombre del personaje.
   */
  @Id
  @Column(name = H2Constants.CHARACTER_NAME)
  private String characterName;

  /**
   * Título del comic.
   */
  @Id
  private String title;
}
