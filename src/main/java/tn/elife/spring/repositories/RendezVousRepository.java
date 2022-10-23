package tn.elife.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elife.spring.entities.RendezVous;
import tn.elife.spring.entities.Specialite;

@Repository
public interface RendezVousRepository extends CrudRepository<RendezVous, Long> {
	
	//@Query("select r from RendezVous r inner join Clinique inner join Medecin  where Clinique.idClinique =?1 and Medecin.Specialite =?2 ")
	//List<RendezVous> findByIdCliniqueAndSpecialite(Long idClinique, Specialite specialite);
	//List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);
	List<RendezVous> findByDateRDVGreaterThan(Date date);
}
