package com.sago.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pets")
@Controller
public class PetController {
    @RequestMapping({"","index","list"})
    public String listPets() {

        return "pets/list";
    }
}
