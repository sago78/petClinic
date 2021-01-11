package com.sago.springframework.petclinic.services.map;

import com.sago.springframework.petclinic.model.Vet;
import com.sago.springframework.petclinic.services.SpecialtyService;
import com.sago.springframework.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    @Autowired
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object!= null) {
            if ( object.getSpecialties().size() > 0 ) {

                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        specialty = (specialtyService.save(specialty));
                    }
                });

            }
            return super.save(object);
        }else {
            return null;
        }

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findByName(String name) {
        return null;
    }
}
