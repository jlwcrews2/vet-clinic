package no.jlwcrews.vetclinic.service;

import no.jlwcrews.vetclinic.model.Owner;
import no.jlwcrews.vetclinic.model.Pet;
import no.jlwcrews.vetclinic.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepo ownerRepo;

    @Autowired
    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    public Owner createOwner(Owner owner) {
        return ownerRepo.save(owner);
    }

    public Owner findOwnerById(Long id) {
        return ownerRepo.findById(id).orElse(null);
    }

    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    public void deleteOwnerById(Long id) {
        ownerRepo.deleteById(id);
    }

    public Owner addPetToOwner(Pet pet, Long id) {
        var owner = ownerRepo.findById(id).orElseThrow();
        owner.getPets().add(pet);
        return ownerRepo.save(owner);
    }
}
