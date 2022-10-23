package tn.elife.spring.services;

import java.util.Date;

import tn.elife.spring.entities.Medecin;

public interface IServiceMedecin {
	public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);

	public int getNbrRendezVousMedecin(Long idMedecin);

	public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
