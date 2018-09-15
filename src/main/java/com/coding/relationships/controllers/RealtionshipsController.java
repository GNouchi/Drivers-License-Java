package com.coding.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.relationships.models.License;
import com.coding.relationships.models.Person;
import com.coding.relationships.services.LicenseService;
import com.coding.relationships.services.PersonService;

@Controller
public class RealtionshipsController {
	private final PersonService personService;
	private final LicenseService licenseService;
	public RealtionshipsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}		
//	render show
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model ) {
		if(personService.checkPerson(id)==false) {return "redirect:/persons/new";}		
		Person person = personService.findPerson(id);
		License license = licenseService.findLicense(id);
		model.addAttribute("person" , person);
		model.addAttribute("license" , license);
		return "show";
	}
//	render create person form
	@RequestMapping("/persons/new")
	public String newperson(@ModelAttribute("person") Person person,Model model) {
		return "newperson";
	}
//	render create license form
	@RequestMapping("/licenses/new")
	public String newlicense(@ModelAttribute("license") License license,Model model) {
		List<Person> persons= licenseService.findAllNoLicensePeople(); 
		model.addAttribute("persons",persons);
		return "newlicense";
	}
//~~~Operations~~~~~
//	create new person
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createperson(@Valid @ModelAttribute("person") Person person, @RequestParam("id") Long id ,BindingResult result) {
		System.out.println("temp id is: "+ id );
		if(result.hasErrors()) {
			return "newperson";
		}
		personService.createPerson(person);
		return "redirect:/persons/"+person.getId();
	}
// create new license from existing	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String newlicense(@Valid @ModelAttribute("license") License license, BindingResult result
			, @RequestParam("person") Person person) {
		if(licenseService.findLicenseByPerson(person)==false) {
			if(result.hasErrors()) {
				System.out.println("errors found");
				return "newlicense";
			}
			licenseService.createLicense(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
		return "newlicense";
	}
// redirect to create since main is not built
	@RequestMapping("/persons")
	public String index() {
		return "redirect:/persons/new";
	}
}
