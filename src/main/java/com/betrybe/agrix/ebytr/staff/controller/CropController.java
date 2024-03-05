package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.utils.ConvertDtoCrop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop controller.
 */
@RestController
@RequestMapping("crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCrops() {
    return ConvertDtoCrop.convertListCrop(this.cropService.getAllCrops());
  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> expiresCrop(@RequestParam LocalDate start, @RequestParam LocalDate end) {
    return ConvertDtoCrop.convertListCrop(this.cropService
        .findBtween(start, end));
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto getCrop(@PathVariable Long id) {
    return ConvertDtoCrop.convertCrop(this.cropService.getCrop(id));
  }

}