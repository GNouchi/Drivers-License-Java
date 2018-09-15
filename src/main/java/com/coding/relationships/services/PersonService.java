package com.coding.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.relationships.models.Person;
import com.coding.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
//find all
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
//find one
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		return null;
	}
// check if exists
	public boolean checkPerson(Long id) {
		if (id==null) {return false;}
		return personRepository.existsById(id);
	} 
//	create
	public void createPerson(Person person) {
		personRepository.save(person);
	}
}
