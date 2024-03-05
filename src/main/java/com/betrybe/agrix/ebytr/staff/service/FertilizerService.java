package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service para fertilizers.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository repository;

  @Autowired
  public FertilizerService(FertilizerRepository repository) {
    this.repository = repository;
  }

  public List<Fertilizer> getAllFarms() {
    return this.repository.findAll();
  }

  public Optional<Fertilizer> findById(Long id) {
    return Optional.ofNullable(
        this.repository.findById(id).orElseThrow(FertilizerNotFoundException::new));
  }

  public Fertilizer create(Fertilizer newFertilizer) {
    return this.repository.save(newFertilizer);
  }
}