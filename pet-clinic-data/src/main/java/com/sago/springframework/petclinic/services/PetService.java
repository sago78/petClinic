package com.sago.springframework.petclinic.services;

import com.sago.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet findByName(String name);
    Pet save(Pet pet);

    Set<Pet> findAll();
}
