package com.betrybe.agrix.ebytr.staff.dto;

import java.time.LocalDate;

/**
 * Dto para crop.
 */
public record CropDto(Long id, String name, Double plantedArea, LocalDate
    plantedDate, LocalDate harvestDate, Long farmId) {
}