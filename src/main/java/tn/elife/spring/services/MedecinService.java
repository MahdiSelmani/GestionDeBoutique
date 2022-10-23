package tn.elife.spring.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elife.spring.entities.Clinique;
import tn.elife.spring.entities.Medecin;
import tn.elife.spring.entities.RendezVous;
import tn.elife.spring.repositories.CliniqueRepository;
import tn.elife.spring.repositories.MedecinRepository;

@Service
public class MedecinService implements IServiceMedecin {

	@Autowired
	private MedecinRepository medecinRepo;
	@Autowired
	private CliniqueRepository cliniqueRepo;

	@Override
	@Transactional
	public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
		medecinRepo.save(medecin);
		Clinique clinique = cliniqueRepo.findById(cliniqueId).get();
		clinique.getMedecins().add(medecin);
		cliniqueRepo.save(clinique);
		return medecin;

	}

	@Override
	public int getNbrRendezVousMedecin(Long idMedecin) {
		return medecinRepo.findById(idMedecin).get().getListRendezVous().size();
	}

	@Override
	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
		int revenu = 0;
		Medecin medecin = medecinRepo.findById(idMedecin).get();
		for (RendezVous r : medecin.getListRendezVous()) {
			if (r.getDateRDV().after(startDate) && r.getDateRDV().before(endDate))
				revenu = revenu + medecin.getPrixConsultation();
		}
		return revenu;
	}

}
