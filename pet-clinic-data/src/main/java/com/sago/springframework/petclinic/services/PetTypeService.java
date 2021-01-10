package com.sago.springframework.petclinic.services;

import com.sago.springframework.petclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType,Long> {
    PetType findByName(String name);
}
