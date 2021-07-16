package com.jvillanueva.albo.test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase para representar el response de los colaboradores.
 */
@Getter
@Setter
@AllArgsConstructor
public class ColaboratorsResponse {

  /**
   * Fecha de actualización.
   */
  private String last_sycn;

  /**
   * Lista editores.
   */
  private List<String> editors;

  /**
   * Lista escritores.
   */
  private List<String> writers;

  /**
   * Lista colorists.
   */
  private List<String> colorists;

  /**
   * Lista inkers.
   */
  private List<String> inkers;

  /**
   * Lista pencilers.
   */
  private List<String> pencilers;

  /**
   * Lista artistas.
   */
  private List<String> artists;

  /**
   * Lista otros.
   */
  private List<String> others;

  /**
   * Constructor NoArgs.
   */
  public ColaboratorsResponse() {
    this.editors = new ArrayList<>();
    this.writers = new ArrayList<>();
    this.colorists = new ArrayList<>();
    this.inkers = new ArrayList<>();
    this.pencilers = new ArrayList<>();
    this.artists = new ArrayList<>();
    this.others = new ArrayList<>();
  }
}
