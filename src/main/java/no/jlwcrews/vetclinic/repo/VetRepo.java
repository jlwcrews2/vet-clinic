package no.jlwcrews.vetclinic.repo;

import no.jlwcrews.vetclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends JpaRepository<Vet, Long> {
}
