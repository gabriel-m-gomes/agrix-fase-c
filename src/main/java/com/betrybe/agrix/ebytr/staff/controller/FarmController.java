package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import com.betrybe.agrix.ebytr.staff.utils.ConvertDtoCrop;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe que representa o controller para farm.
 */
@RestController
@RequestMapping("farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;


  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
  @ResponseStatus(HttpStatus.OK)
  public List<Farm> getAllFarms() {
    return this.farmService.getAllFarms();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Farm getFarm(@PathVariable Long id) {
    return this.farmService.getFarm(id).get();
  }

  @GetMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getCropsId(@PathVariable Long id) {
    return ConvertDtoCrop.convertListCrop(cropService.getCropsId(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Farm saveFarm(@RequestBody Farm newFarm) {
    return this.farmService.saveFarm(newFarm);
  }

  @PostMapping("/{id}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto saveCrop(@PathVariable Long id, @RequestBody Crop crop) {
    Crop cropDb = this.cropService.saveCrop(id, crop);
    return ConvertDtoCrop.convertCrop(cropDb);
  }

}