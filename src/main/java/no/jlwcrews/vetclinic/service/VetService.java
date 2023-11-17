package no.jlwcrews.vetclinic.service;

import no.jlwcrews.vetclinic.model.Vet;
import no.jlwcrews.vetclinic.repo.VetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {

    private final VetRepo vetRepo;

    @Autowired
    public VetService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    public Vet getVetById(Long id) {
        return vetRepo.findById(id).orElse(null);
    }

    public List<Vet> getVets() {
        return vetRepo.findAll();
    }

    public Vet createVet(Vet vet) {
        return vetRepo.save(vet);
    }

    public void deleteVet(Long id) {
        vetRepo.deleteById(id);
    }
}
