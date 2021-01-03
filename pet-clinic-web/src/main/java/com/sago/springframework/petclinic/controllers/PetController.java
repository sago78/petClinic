package com.sago.springframework.petclinic.controllers;

import com.sago.springframework.petclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pets")
@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"","index","list"})
    public String listPets(Model model) {
        model.addAttribute("pets", petService.findAll());

        return "pets/list";
    }
}
