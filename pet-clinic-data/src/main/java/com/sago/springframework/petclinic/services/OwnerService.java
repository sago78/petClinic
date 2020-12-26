package com.sago.springframework.petclinic.services;

import com.sago.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);
    Owner findByName(String name);
    Owner save(Owner owner);

    Set<Owner> findAll();
}
