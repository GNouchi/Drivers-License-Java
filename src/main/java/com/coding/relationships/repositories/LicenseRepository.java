package com.coding.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.relationships.models.License;
import com.coding.relationships.models.Person;

public interface LicenseRepository extends CrudRepository <License, Long> {
	List<License> findAll();
	List<License> findByPerson(Person person);
}
