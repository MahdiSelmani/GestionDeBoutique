package tn.elife.spring.services;

import java.util.List;

import tn.elife.spring.entities.RendezVous;
import tn.elife.spring.entities.Specialite;

public interface IServiceRendezVous {
	public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
	
	public void retrieveRendezVous();
}
