package tn.elife.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Medecin;
import tn.elife.spring.entities.Patient;
import tn.elife.spring.entities.RendezVous;
import tn.elife.spring.entities.Specialite;
import tn.elife.spring.repositories.CliniqueRepository;
import tn.elife.spring.repositories.MedecinRepository;
import tn.elife.spring.repositories.PatientRepository;
import tn.elife.spring.repositories.RendezVousRepository;

@Service
public class RendezVousService implements IServiceRendezVous {
	@Autowired
	private RendezVousRepository rendezVousRepo;
	@Autowired
	private MedecinRepository medecinRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private CliniqueRepository cliniqueRepo;

	@Override
	@Transactional
	public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
		Medecin medecin = medecinRepo.findById(idMedecin).get();
		Patient patient = patientRepo.findById(idPatient).get();
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
		rendezVousRepo.save(rdv);

	}

	@Override
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
		List<RendezVous> listRendezVous = new ArrayList();
		List<Medecin> medecins = cliniqueRepo.findById(idClinique).get().getMedecins();
		for (Medecin m : medecins) {
			if (m.getSpecialite().equals(specialite))
				listRendezVous.addAll(m.getListRendezVous());
		}

		return listRendezVous;
		// return rendezVousRepo.findByIdCliniqueAndSpecialite(idClinique, specialite);
	}

	@Override
	@Scheduled(cron = "30 * * * * *")
	public void retrieveRendezVous() {

		System.out.println(rendezVousRepo.findByDateRDVGreaterThan(new Date()));

	}

}
