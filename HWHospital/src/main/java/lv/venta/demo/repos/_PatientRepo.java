package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Patient;

public interface _PatientRepo extends CrudRepository<Patient, Integer> {
	boolean existsByNameAndSurname(String name, String surname);
	ArrayList<Patient> findAllByNameAndSurname(String name, String surname);
	boolean existsByPersonalCN(String personalCN);
} 
