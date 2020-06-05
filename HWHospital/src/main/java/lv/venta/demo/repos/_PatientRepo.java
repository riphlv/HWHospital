package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Patient;

public interface _PatientRepo extends CrudRepository<Patient, Integer> {
	boolean existsByNameAndSurname(String name, String surname);
	ArrayList<Patient> findByNameAndSurname(String name, String surname);
	boolean existsByPersonalCN(String personalCN);
	Patient findByPersonalCN(String personalCN);
} 
