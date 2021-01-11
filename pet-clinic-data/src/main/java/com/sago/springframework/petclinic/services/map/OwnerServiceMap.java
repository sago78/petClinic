package com.sago.springframework.petclinic.services.map;

import com.sago.springframework.petclinic.model.Owner;
import com.sago.springframework.petclinic.model.Pet;
import com.sago.springframework.petclinic.services.OwnerService;
import com.sago.springframework.petclinic.services.PetService;
import com.sago.springframework.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long>  implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object!=null){
            if (object.getPets() !=null){
                object.getPets().forEach( pet -> {
                    if (pet.getPetType()!=null)
                    {
                        if (pet.getPetType().getId()  == null ){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw  new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId()== null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }

            return super.save(object);
        }else {
        return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByName(String name) {
        return null;
    }
}
