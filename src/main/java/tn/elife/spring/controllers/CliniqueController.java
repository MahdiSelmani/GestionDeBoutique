package tn.elife.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elife.spring.entities.Clinique;
import tn.elife.spring.services.CliniqueService;

@RestController
@RequestMapping("/cliniques")
public class CliniqueController {
	@Autowired
	private CliniqueService cliniqueService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CliniqueController.class);


	@PostMapping("/add")
	@ResponseBody
	public Clinique addClinique(@RequestBody Clinique clinique) {
		LOGGER.info("Clinique ajouté avec succés") ;
		return cliniqueService.addClinique(clinique);
	}
}
