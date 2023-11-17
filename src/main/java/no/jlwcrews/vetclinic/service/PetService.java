package no.jlwcrews.vetclinic.service;

import no.jlwcrews.vetclinic.model.Pet;
import no.jlwcrews.vetclinic.repo.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepo petRepo;

    @Autowired
    public PetService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public List<Pet> getPets(){
        return petRepo.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepo.findById(id).orElse(null);
    }

    public Pet createPet(Pet pet) {
        return petRepo.save(pet);
    }

    public void deletePet(Long id) {
        petRepo.deleteById(id);
    }
}
