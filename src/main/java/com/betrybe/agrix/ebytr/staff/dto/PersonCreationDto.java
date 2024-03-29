package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Classe para dto.
 */
public record PersonCreationDto(
    String username,
    String password,

    Role role) {

  public Person toEntity() {
    return new Person(null, username, password, role);
  }
}