package com.jvillanueva.albo.test.domain;

import com.jvillanueva.albo.test.constants.H2Constants;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Entidad de la tabla characters.
 * 
 * @author J. Villanueva
 *
 */
@Entity
@Table(name = H2Constants.TABLE_CHARACTERS)
@SuperBuilder
@NoArgsConstructor
public class CharacterEntity extends CommonEntity {
}
