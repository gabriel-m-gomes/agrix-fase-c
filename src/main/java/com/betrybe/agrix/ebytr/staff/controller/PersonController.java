package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe para controller person.
 */
@RestController
@RequestMapping("persons")
public class PersonController {

  private final PersonService service;


  @Autowired
  public PersonController(PersonService service) {
    this.service = service;
  }

  /**
   * Método para cadastrar uma pessoa.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody PersonCreationDto personCreationDto) {
    Person savedPerson = service.create(personCreationDto.toEntity());

    return new PersonDto(savedPerson.getId(), savedPerson.getUsername(), savedPerson.getRole());
  }
}
