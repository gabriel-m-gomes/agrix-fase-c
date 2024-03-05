package com.betrybe.agrix.ebytr.staff.utils;


import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe statica para converter fertilizer em fertilizerDto.
 */
public final class ConvertDtoFertilizer {
  public static FertilizerDto convertFertilizer(Fertilizer fertilizer) {
    return new FertilizerDto(fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
        fertilizer.getComposition());
  }

  /**
   * Metodo statico para converter crop em uma lista de FertilizerDto.
   */
  public static List<FertilizerDto> convertListFertilizers(List<Fertilizer> fertilizers) {
    return fertilizers.stream().map(f -> new FertilizerDto(f.getId(),
            f.getName(), f.getBrand(), f.getComposition()))
        .collect(Collectors.toList());
  }
}