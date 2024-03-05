package com.betrybe.agrix.ebytr.staff.repository;


import com.betrybe.agrix.ebytr.staff.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface farm repository.
 */
public interface FarmRepository extends JpaRepository<Farm, Long> {

}