package com.jvillanueva.albo.test.business;

import com.jvillanueva.albo.test.client.MarvelApiFeign;
import com.jvillanueva.albo.test.constants.ApiValues;
import com.jvillanueva.albo.test.constants.Constants;
import com.jvillanueva.albo.test.domain.CharacterEntity;
import com.jvillanueva.albo.test.domain.ColaboratorEntity;
import com.jvillanueva.albo.test.domain.HeroCharacterJoinEntity;
import com.jvillanueva.albo.test.domain.HeroCharacterRelEntity;
import com.jvillanueva.albo.test.domain.HeroColaboratorRelEntity;
import com.jvillanueva.albo.test.domain.HeroEntity;
import com.jvillanueva.albo.test.domain.SyncEntity;
import com.jvillanueva.albo.test.exceptions.NoDataFoundException;
import com.jvillanueva.albo.test.model.CharacterInteraction;
import com.jvillanueva.albo.test.model.CharactersResponse;
import com.jvillanueva.albo.test.model.ColaboratorsResponse;
import com.jvillanueva.albo.test.model.MarvelApiResponse;
import com.jvillanueva.albo.test.repository.CharacterRepository;
import com.jvillanueva.albo.test.repository.ColaboratorRepository;
import com.jvillanueva.albo.test.repository.HeroCharacterJoinRepository;
import com.jvillanueva.albo.test.repository.HeroCharacterRepository;
import com.jvillanueva.albo.test.repository.HeroColaboratorRepository;
import com.jvillanueva.albo.test.repository.HeroRepository;
import com.jvillanueva.albo.test.repository.SyncRepository;
import com.jvillanueva.albo.test.service.CharacterInformationService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que implementa la lógica de CharacterInformationService.
 * 
 * @author J. Villanueva
 *
 */
@Service
@Slf4j
public class CharacterInformationBusiness implements CharacterInformationService {
  /**
   * Inyección cliente feign.
   */
  @Autowired
  private MarvelApiFeign client;

  /**
   * Inyección HeroRepository.
   */
  @Autowired
  private HeroRepository heroRepository;

  /**
   * Inyección CharacterRepository.
   */
  @Autowired
  private CharacterRepository characterRepository;

  /**
   * Inyección HeroChacarcterRepository.
   */
  @Autowired
  private HeroCharacterRepository heroCharacterRepository;

  /**
   * Inyección ColaboratorRepository.
   */
  @Autowired
  private ColaboratorRepository colaboratorRepository;

  /**
   * Inyección HeroColaboratorRepository.
   */
  @Autowired
  private HeroColaboratorRepository heroColaboratorRepository;

  /**
   * Inyección HeroCharacterJoinRepository.
   */
  @Autowired
  private HeroCharacterJoinRepository heroCharacterJoinRepository;

  /**
   * Inyección SyncRepository.
   */
  @Autowired
  private SyncRepository syncRepository;

  /**
   * Inyección valores de la api.
   */
  @Autowired
  private ApiValues apiValues;

  /**
   * Método que orquesta el llamado al APi y actualización de la base de datos.
   * 
   * @param heroName
   */
  @Override
  public void getCharacterInformation(String heroName) {
    Optional<HeroEntity> optHero = getHero(heroName);

    log.info(Constants.INIT_UPDATE_SERVICE, heroName);

    HeroEntity hero = optHero.get();

    MarvelApiResponse capAmericaResponse = getInfoFromApi(hero.getId(), 0L);

    if (Objects.nonNull(capAmericaResponse)) {
      log.info(Constants.INIT_BD_UPDATE, hero.getId());

      updateBD(hero.getId(), capAmericaResponse);

      if (apiValues.getLimit() < capAmericaResponse.getData().getTotal()) {
        do {
          capAmericaResponse = getInfoFromApi(hero.getId(),
              capAmericaResponse.getData().getOffset() + apiValues.getLimit());

          updateBD(hero.getId(), capAmericaResponse);
        } while (capAmericaResponse.getData().getOffset() < capAmericaResponse.getData()
            .getTotal());
      }
      log.info(Constants.END_BD_UPDATE, hero.getId());
    }

    SyncEntity sync = SyncEntity.builder().lastSync(LocalDateTime.now()).build();
    syncRepository.save(sync);

    log.info(Constants.END_UPDATE_SERVICE, heroName);
  }


  /**
   * Método que orquesta el repositorio para obtener los colaboradores en los comics del heroe.
   * 
   * @param heroName
   * @return colaboratorResponse
   */
  @Override
  public ColaboratorsResponse getColaboratorsFromDbByHero(String heroName) {
    log.info(Constants.INIT_GET_COLABORATORS_SERVICE, heroName);

    Optional<HeroEntity> optHero = getHero(heroName);

    Optional<SyncEntity> sync = getLastSync();

    HeroEntity hero = optHero.get();
    List<ColaboratorEntity> colaborators =
        colaboratorRepository.findColaboratorsByIdHero(hero.getId());

    ColaboratorsResponse colaboratorsResponse = new ColaboratorsResponse();
    colaboratorsResponse.setLast_sycn(
        DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT).format(sync.get().getLastSync()));

    colaborators.forEach(c -> {
      switch (c.getRole()) {
        case Constants.EDITOR:
          colaboratorsResponse.getEditors().add(c.getName());
          break;
        case Constants.COLORIST:
        case Constants.COLORIST_COVER:
          colaboratorsResponse.getColorists().add(c.getName());
          break;
        case Constants.PENCILER:
        case Constants.PENCILER_COVER:
        case Constants.PENCILLER:
        case Constants.PENCILLER_COVER:
          colaboratorsResponse.getPencilers().add(c.getName());
          break;
        case Constants.ARTIST:
          colaboratorsResponse.getArtists().add(c.getName());
          break;
        case Constants.WRITER:
          colaboratorsResponse.getWriters().add(c.getName());
          break;
        case Constants.INKER:
          colaboratorsResponse.getInkers().add(c.getName());
          break;
        case Constants.OTHER:
          colaboratorsResponse.getOthers().add(c.getName());
          break;
        default:
          colaboratorsResponse.getOthers().add(c.getName());
      }
    });

    log.info(Constants.END_GET_COLABORATORS_SERVICE, heroName);

    return colaboratorsResponse;
  }

  /**
   * Método que orquesta el llamado al repositorio para obtener los personajes asociados al heroe.
   * 
   * @param heroName
   * @return characterResponse
   */
  @Override
  public CharactersResponse getCharactersFromDbByHero(String heroName) {
    log.info(Constants.INIT_GET_CHARACTERS_SERVICE, heroName);

    Optional<HeroEntity> optHero = getHero(heroName);

    HeroEntity hero = optHero.get();

    Optional<SyncEntity> sync = getLastSync();

    List<HeroCharacterJoinEntity> listHeroCharacters =
        heroCharacterJoinRepository.getHeroInteractionWithCharacters(hero.getId(), hero.getName());

    Map<String, List<HeroCharacterJoinEntity>> charactersGroupTitle = listHeroCharacters.stream()
        .collect(Collectors.groupingBy(HeroCharacterJoinEntity::getCharacterName));

    CharactersResponse charactersResponse = new CharactersResponse();

    charactersGroupTitle.forEach((k, v) -> {
      CharacterInteraction characterInteraction = new CharacterInteraction();
      characterInteraction.setCharacter(k);
      v.forEach(hcje -> {
        characterInteraction.getComics().add(hcje.getTitle());
      });
      charactersResponse.getCharacters().add(characterInteraction);
    });

    charactersResponse.setLast_sync(
        DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT).format(sync.get().getLastSync()));

    log.info(Constants.END_GET_CHARACTERS_SERVICE, heroName);

    return charactersResponse;
  }

  /**
   * Método que actualiza la base de datos H2 con la información que se obtiene del Api de Marvel.
   * 
   * @param idHero
   * @param capAmericaResponse
   */
  private void updateBD(String idHero, MarvelApiResponse capAmericaResponse) {
    capAmericaResponse.getData().getResults().forEach(c -> {
      c.getCharacters().getItems().forEach(ch -> {
        Optional<CharacterEntity> optCharacter =
            characterRepository.findCharacterByName(ch.getName());

        CharacterEntity character = null;

        if (!optCharacter.isPresent()) {
          character = CharacterEntity.builder().name(ch.getName()).build();

          character = characterRepository.save(character);
        } else {
          character = optCharacter.get();
        }

        HeroCharacterRelEntity heroCharacterRel = HeroCharacterRelEntity.builder().idHero(idHero)
            .idCharacter(character.getId()).title(c.getTitle()).build();

        heroCharacterRepository.save(heroCharacterRel);
      });

      c.getCreators().getItems().forEach(cr -> {
        Optional<ColaboratorEntity> optColaborator =
            colaboratorRepository.findColaboratorByName(cr.getName());

        if (!optColaborator.isPresent()) {
          ColaboratorEntity colaborator =
              ColaboratorEntity.builder().name(cr.getName()).role(cr.getRole()).build();

          colaborator = colaboratorRepository.save(colaborator);

          HeroColaboratorRelEntity heroColaboratorRel = HeroColaboratorRelEntity.builder()
              .idHero(idHero).idColaborator(colaborator.getId()).build();

          heroColaboratorRepository.save(heroColaboratorRel);
        }
      });
    });
  }

  /**
   * Método que consume el Api de Marvel.
   * 
   * @param characterId
   * @param offset
   * @return MarvelApiResponse response
   */
  private MarvelApiResponse getInfoFromApi(String characterId, Long offset) {
    return client.getCharacterInformation(characterId, apiValues.getPublicKey(), apiValues.getTs(),
        DigestUtils
            .md5Hex(apiValues.getTs() + apiValues.getPrivateKey() + apiValues.getPublicKey()),
        apiValues.getLimit(), offset);
  }

  /**
   * Método que busca en BD el Heroe con base en el nombre.
   * 
   * @param heroName
   * @return hero
   * @throws NoDataFoundException
   */
  private Optional<HeroEntity> getHero(String heroName) throws NoDataFoundException {
    log.info(Constants.INIT_GET_IDHERO);

    Optional<HeroEntity> hero = heroRepository.findHeroByName(heroName);

    if (!hero.isPresent()) {
      throw new NoDataFoundException(Constants.MSG_ERROR_HERO_NOT_FOUND);
    }

    log.info(Constants.END_GET_IDHERO, hero.get().getId());

    return hero;
  }

  /**
   * Método que orquesta el repositrio para obtener la fecha de actualización.
   * 
   * @return sync
   * @throws NoDataFoundException
   */
  private Optional<SyncEntity> getLastSync() throws NoDataFoundException {
    log.info(Constants.INIT_GET_LASTSYNC);

    Optional<SyncEntity> sync = syncRepository.getLastSyncDate();

    if (!sync.isPresent()) {
      throw new NoDataFoundException(Constants.MSG_ERROR_LASTSYNC_NOT_FOUND);
    }

    log.info(Constants.END_GET_LASTSYNC,
        DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT).format(sync.get().getLastSync()));

    return sync;
  }
}
