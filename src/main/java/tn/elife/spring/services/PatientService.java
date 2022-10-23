package tn.elife.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Patient;
import tn.elife.spring.repositories.PatientRepository;
@Service
public class PatientService implements IServicePatient {
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

}
