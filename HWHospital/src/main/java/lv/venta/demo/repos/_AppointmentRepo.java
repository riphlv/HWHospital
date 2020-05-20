package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Appointment;

public interface _AppointmentRepo extends CrudRepository<Appointment, Integer> {

	ArrayList<Appointment> findAllById(int patient_id); 

}
