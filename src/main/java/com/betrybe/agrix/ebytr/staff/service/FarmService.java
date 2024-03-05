package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que representa a service farm.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm saveFarm(Farm farm) {
    return this.farmRepository.save(farm);
  }

  public Optional<Farm> getFarm(Long id) {
    return Optional.ofNullable(this.farmRepository.findById(id)
        .orElseThrow(FarmNotFoundException::new));
  }

  public List<Farm> getAllFarms() {
    return this.farmRepository.findAll();
  }

}