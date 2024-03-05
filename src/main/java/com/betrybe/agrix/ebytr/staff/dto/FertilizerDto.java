package com.betrybe.agrix.ebytr.staff.dto;

/**
 * Dto para segurança em fertilizers.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {
}