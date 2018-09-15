package com.coding.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.relationships.models.License;
import com.coding.relationships.models.Person;
import com.coding.relationships.repositories.LicenseRepository;
import com.coding.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
// find all
	public List<License> allLicense(){
		return licenseRepository.findAll();
	}
//	find all persons without licenses
	public List<Person> findAllNoLicensePeople(){
		List<Person> allPersons = personRepository.findAll();
		List<License> allLicences = licenseRepository.findAll();
		for(int i =0; i < allLicences.size(); i++) {
			System.out.println("Removing : " 
					+allLicences.get(i).getPerson().getFirstName()
					+allLicences.get(i).getPerson().getLastName());
			allPersons.remove(allLicences.get(i).getPerson());
		}
		return allPersons;
	}
	
// find one by id
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		return null;
	}
// check if person exists
		public boolean findLicenseByPerson(Person person) {
			List <License> list= licenseRepository.findByPerson(person);
			System.out.println("Person Exists : "+list.size());
			if(list.size()>0) {
				return true;
			}
			return false;
		}
// create 	
	public void createLicense(License license) {
			System.out.println("hit create route");
			licenseRepository.save(license);
			long tempid = license.getId();
			System.out.println("newly created id = "+ tempid);
			License tempLicense = licenseRepository.findById(tempid).get();
			String temp = String.format("%05d", tempid);
			license.setNumber(temp);
			licenseRepository.save(tempLicense);		
	}
}	
