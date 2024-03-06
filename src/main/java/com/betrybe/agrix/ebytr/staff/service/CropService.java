package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que representa a serice para crop.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
  }

  public List<Crop> getAllCrops() {
    return this.cropRepository.findAll();
  }

  /**
   * Retorna um crop.
   */
  public Crop getCrop(Long id) {
    Optional<Crop> cropDb = Optional.ofNullable(
        this.cropRepository.findById(id).orElseThrow(CropNotFoundException::new));
    return cropDb.get();
  }

  /**
   * Retorna uma lsita de crop.
   */
  public List<Crop> getCropsId(Long id) {
    Optional<Farm> farm = Optional.ofNullable(this.farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new));

    return farm.get().getCrops();
  }

  /**
   * Cria uma nova crop.
   */
  public Crop saveCrop(Long id, Crop crop) {
    Optional<Farm> farm = Optional.ofNullable(this.farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new));
    crop.setFarmId(farm.get());
    return cropRepository.save(crop);
  }

  /**
   * Metodo que deve retornar uma lista com as plantações nas quais o campo harvestDate esteja entre
   * as data de início e de fim.
   */

  public List<Crop> findBtween(LocalDate start, LocalDate end) {
    return this.cropRepository.findByHarvestDateBetween(start, end);
  }
}