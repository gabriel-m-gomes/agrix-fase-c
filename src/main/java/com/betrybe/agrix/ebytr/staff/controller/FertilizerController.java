package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import com.betrybe.agrix.ebytr.staff.utils.ConvertDtoFertilizer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para fertilizers.
 */
@RestController
@RequestMapping("fertilizers")
public class FertilizerController {

  private final FertilizerService service;

  @Autowired
  public FertilizerController(FertilizerService service) {
    this.service = service;
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getAll() {
    return ConvertDtoFertilizer.convertListFertilizers(this.service.getAllFarms());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto findById(@PathVariable Long id) {
    return ConvertDtoFertilizer.convertFertilizer(this.service.findById(id).get());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto create(@RequestBody Fertilizer newFertilizer) {
    return ConvertDtoFertilizer.convertFertilizer(this.service.create(newFertilizer));
  }

}