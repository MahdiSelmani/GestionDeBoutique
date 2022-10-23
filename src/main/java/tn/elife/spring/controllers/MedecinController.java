package tn.elife.spring.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Medecin;
import tn.elife.spring.services.MedecinService;

@RestController
@RequestMapping("/medecins")
public class MedecinController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MedecinController.class);

	@Autowired
	private MedecinService medecinService;

	@PostMapping("/add/{idClinique}")
	@ResponseBody
	public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin,
			@PathVariable("idClinique") Long cliniqueId) {
		LOGGER.info("Medecin ajouté et affecté au clinique");
		return medecinService.addMedecinAndAssignToClinique(medecin, cliniqueId);

	}

	@GetMapping("/{idMedecin}")
	@ResponseBody
	public int getNbrRendezVousMedecin(@PathVariable("idMedecin") Long idMedecin) {
		return medecinService.getNbrRendezVousMedecin(idMedecin);
	}

	@GetMapping("/{idMedecin}/{startDate}/{endDate}")
	@ResponseBody
	public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
			@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		return medecinService.getRevenuMedecin(idMedecin, startDate, endDate);

	}

}
