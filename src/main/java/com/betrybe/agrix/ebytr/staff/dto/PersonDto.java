package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Classe para dto.
 */
public record PersonDto(Long id, String username, Role role) {
}
