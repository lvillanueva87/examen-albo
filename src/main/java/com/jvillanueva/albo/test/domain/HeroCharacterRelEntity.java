package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla heros_characters.
 * 
 * @author J. Villanueva
 *
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = H2Constants.TABLE_HEROS_CHARACTERS_REL)
@IdClass(HeroCharacterId.class)
public class HeroCharacterRelEntity {

  /**
   * Id Heroe.
   */
  @Id
  @Column(name = H2Constants.ID_HERO)
  private String idHero;

  /**
   * Id personaje.
   */
  @Id
  @Column(name = H2Constants.ID_CHARACTER)
  private String idCharacter;

  /**
   * Título.
   */
  @Id
  private String title;
}
