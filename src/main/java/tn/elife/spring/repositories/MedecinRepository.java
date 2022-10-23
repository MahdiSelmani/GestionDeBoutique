package tn.elife.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.Medecin;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long> {

}
