package tn.elife.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.Clinique;

@Repository
public interface CliniqueRepository extends CrudRepository<Clinique, Long> {

}
