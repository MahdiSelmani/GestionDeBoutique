package tn.elife.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Clinique;
import tn.elife.spring.repositories.CliniqueRepository;

@Service
public class CliniqueService implements IServiceClinique {
	@Autowired
	CliniqueRepository cliniqueRepo;

	@Override
	public Clinique addClinique(Clinique clinique) {
		return cliniqueRepo.save(clinique);
	}

}
