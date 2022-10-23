package tn.elife.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Patient;
import tn.elife.spring.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);


	@PostMapping
	@ResponseBody
	public Patient addPatient(@RequestBody Patient patient) {
		LOGGER.info("Patient ajouté avec succés");
		return patientService.addPatient(patient);
	}
}
