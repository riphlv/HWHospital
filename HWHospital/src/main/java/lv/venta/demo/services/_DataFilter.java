package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.models.Appointment;
import lv.venta.demo.models.Doctor;
import lv.venta.demo.models.Patient;

public interface _DataFilter {
	ArrayList<Doctor> selectAllDoctors();
	ArrayList<Doctor> selectAllDoctorsByType(Speciality speciality) throws Exception;
	
	ArrayList<Patient> selectAllPatients() throws Exception;
	ArrayList<Patient> selectAllPatientsByNameAndSurname(String name, String surname) throws Exception;
	 
	ArrayList<Appointment> selectAllAppointmentsByPatientById(int patient_id) throws Exception;
	ArrayList<Appointment> selectAllAppointmentsByDoctorById(int doctor_id);
	ArrayList<Appointment> selectAllAppointmentsByDoctorToday(Doctor doctor);
}
