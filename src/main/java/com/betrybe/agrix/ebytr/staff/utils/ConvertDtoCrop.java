package com.betrybe.agrix.ebytr.staff.utils;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe statica para converter crop em CropDto.
 */
public final class ConvertDtoCrop {
  public static CropDto convertCrop(Crop crop) {
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
        crop.getPlantedDate(), crop.getHarvestDate(), crop.getFarm().getId());
  }

  /**
   * Metodo statico para converter crop em uma lista de cropDto.
   */
  public static List<CropDto> convertListCrop(List<Crop> crops) {
    return crops.stream().map(c -> new CropDto(c.getId(), c.getName(),
        c.getPlantedArea(), c.getPlantedDate(), c.getHarvestDate(),
        c.getFarm().getId())).collect(Collectors.toList());
  }
}