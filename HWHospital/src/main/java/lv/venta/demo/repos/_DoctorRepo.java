package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.models.Doctor;

public interface _DoctorRepo extends CrudRepository<Doctor, Integer> {
	boolean existsBySpeciality(Speciality speciality);
	Doctor findByNameAndSurname(String name, String surname);
	ArrayList<Doctor> findAllBySpeciality(Speciality speciality);
	boolean existsByPersonalCN(String personalCN); 
	
}
