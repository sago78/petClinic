package com.sago.springframework.petclinic.bootstrap;

import com.sago.springframework.petclinic.model.Owner;
import com.sago.springframework.petclinic.model.Pet;
import com.sago.springframework.petclinic.model.PetType;
import com.sago.springframework.petclinic.model.Vet;
import com.sago.springframework.petclinic.services.OwnerService;
import com.sago.springframework.petclinic.services.PetService;
import com.sago.springframework.petclinic.services.PetTypeService;
import com.sago.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##DataLoader Running...");
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Roberto Carlos");
        owner.setLastName("da Silva");
        ownerService.save(owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Sergio");
        owner.setLastName("Pérez");
        ownerService.save(owner);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Moroco");
        vet1.setLastName("Rocco");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zeth");
        vet2.setLastName("du jakarta");
        vetService.save(vet2);

        System.out.println("Vets Loaded...");

        PetType petType = new PetType();
        petType.setId(1L);
        petType.setName("Dog");
        petTypeService.save(petType);

        petType.setName("Cat");
        petTypeService.save(petType);

        petType.setName("Bird");
        petTypeService.save(petType);

        System.out.println("Pet Types Loaded...");

        Pet pet = new Pet();
        pet.setId(78L);
        pet.setName("Cherry");
        petService.save(pet);

        pet = new Pet();
        pet.setId(1L);
        pet.setName("Sam");
        petService.save(pet);

        System.out.println("Pets Loaded...");


    }
}
