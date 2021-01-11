package com.sago.springframework.petclinic.bootstrap;

import com.sago.springframework.petclinic.model.*;
import com.sago.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##DataLoader Running...");

        int petCount  = petService.findAll().size();

        if (petCount == 0 ) {
            dataLoad();
        }


    }

    private void dataLoad() {
        PetType dogType = new PetType();
        dogType.setId(1L);
        dogType.setName("Dog");
        petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        petTypeService.save(catType);

        PetType birdType = new PetType();
        birdType.setName("Bird");
        petTypeService.save(birdType);

        System.out.println("Pet Types Loaded...");


        Pet pet = new Pet();

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Roberto Carlos");
        owner.setLastName("da Silva");
        owner.setAddress("Calle " + owner.getLastName());
        owner.setTelephone("3313151520");
        pet.setName("Poki");
        pet.setPetType(dogType);
        pet.setBirthDate(LocalDate.now());
        owner.getPets().add(pet);
        ownerService.save(owner);

        owner = new Owner();
        pet = new Pet();
        owner.setId(2L);
        owner.setFirstName("Sergio");
        owner.setLastName("Pérez");
        owner.setAddress("Calle " +owner.getLastName());
        owner.setTelephone("4413151520");
        pet.setName("Pildora");
        pet.setPetType(catType);
        pet.setBirthDate(LocalDate.now());
        owner.getPets().add(pet);
        pet= new Pet();
        pet.setName("Canelo");
        pet.setPetType(dogType);
        pet.setBirthDate(LocalDate.now());

        ownerService.save(owner);

        System.out.println("Owners loaded...");


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Radiology");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Radiology");
        specialtyService.save(dentistry);

        System.out.println("Vet Specialties added...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Moroco");
        vet1.setLastName("Rocco");
        vet1.getSpecialties().add(dentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zeth");
        vet2.setLastName("du jakarta");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Vets Loaded...");
        pet = new Pet();
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
