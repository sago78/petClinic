package com.sago.springframework.petclinic.services;

import com.sago.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet,Long> {
    Pet findByName(String name);
}
