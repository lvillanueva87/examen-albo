package com.jvillanueva.albo.test.client;

import com.jvillanueva.albo.test.constants.FeignConstants;
import com.jvillanueva.albo.test.model.MarvelApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Cliente feign para el consumo del Api de Marvel.
 * 
 * @author J. Villanueva
 *
 */
@FeignClient(name = FeignConstants.FEIGN_NAME, url = FeignConstants.URL_MARVEL_API)
public interface MarvelApiFeign {

  /**
   * Método que realiza el llamado a la API.
   * 
   * @param characterId
   * @param apikey
   * @param ts
   * @param hash
   * @param limit
   * @param offset
   * @return MarvelApiResponse response
   */
  @GetMapping(path = FeignConstants.CHARACTER_COMICS_RESOURCE)
  MarvelApiResponse getCharacterInformation(
      @PathVariable(FeignConstants.CHARACTER_ID) String characterId, @RequestParam String apikey,
      @RequestParam String ts, @RequestParam String hash, @RequestParam Long limit,
      @RequestParam Long offset);
}
