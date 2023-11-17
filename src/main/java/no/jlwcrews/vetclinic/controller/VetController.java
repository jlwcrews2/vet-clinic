package no.jlwcrews.vetclinic.controller;

import no.jlwcrews.vetclinic.model.Vet;
import no.jlwcrews.vetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vet")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public List<Vet> getVets(){
        return vetService.getVets();
    }

    @GetMapping("/{id}")
    public Vet getVetById(@PathVariable Long id) {
        return vetService.getVetById(id);
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet vet) {
        return vetService.createVet(vet);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable Long id) {
        vetService.deleteVet(id);
    }
}
