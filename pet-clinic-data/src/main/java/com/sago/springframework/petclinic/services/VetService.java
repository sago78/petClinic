package com.sago.springframework.petclinic.services;


import com.sago.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long> {
    Vet findByName(String name);
}
