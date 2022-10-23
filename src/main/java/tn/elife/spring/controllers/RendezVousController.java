package tn.elife.spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import tn.elife.spring.entities.RendezVous;
import tn.elife.spring.entities.Specialite;
import tn.elife.spring.services.RendezVousService;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
	@Autowired
	private RendezVousService rendezVousService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RendezVousController.class);


	@PostMapping("/add/{idMedecin}/{idPatient}")
	public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idMedecin") Long idMedecin,
			@PathVariable("idPatient") Long idPatient) {
		LOGGER.info("Rendez vous ajouté et affecté au medecin et au client avec succés");
		rendezVousService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
	}

	@GetMapping("/{idClinique}")
	@ResponseBody
	public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("idClinique") Long idClinique,
			@RequestBody  Specialite specialite) {
		return rendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
	}
}
