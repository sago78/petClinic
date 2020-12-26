package com.sago.springframework.petclinic.services;


import com.sago.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet findByName(String name);
    Vet save(Vet vet);

    Set<Vet> findAll();
}
