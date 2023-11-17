package no.jlwcrews.vetclinic.controller;

import no.jlwcrews.vetclinic.model.Owner;
import no.jlwcrews.vetclinic.service.OwnerService;
import no.jlwcrews.vetclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;
    private final PetService petService;

    @Autowired
    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.findOwnerById(id);
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
    }

    @PostMapping("/{id}/{petId}")
    public Owner addPetToOwner(@PathVariable Long id, @PathVariable Long petId) {
        var owner = ownerService.findOwnerById(id);
        var pet = petService.getPetById(petId);
        owner.getPets().add(pet);
        return ownerService.createOwner(owner);
    }
}
