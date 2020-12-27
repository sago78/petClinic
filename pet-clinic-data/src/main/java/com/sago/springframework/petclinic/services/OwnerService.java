package com.sago.springframework.petclinic.services;

import com.sago.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByName(String name);
}
