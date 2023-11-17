package no.jlwcrews.vetclinic.controller;

import no.jlwcrews.vetclinic.model.Pet;
import no.jlwcrews.vetclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @GetMapping
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePetById(@PathVariable Long id) {
        petService.deletePet(id);
    }

}
