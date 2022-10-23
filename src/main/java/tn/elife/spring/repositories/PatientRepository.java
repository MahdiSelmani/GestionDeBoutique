package tn.elife.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
