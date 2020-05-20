package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.models.Appointment;
import lv.venta.demo.models.Doctor;
import lv.venta.demo.models.Patient;
import lv.venta.demo.repos._AppointmentRepo;
import lv.venta.demo.repos._DoctorRepo;
import lv.venta.demo.repos._PatientRepo;
import lv.venta.demo.services._DataFilter;

public class DataFilterImpl implements _DataFilter {
	@Autowired
	_DoctorRepo doctorRepo;
	@Autowired
	_PatientRepo patientRepo;
	@Autowired
	_AppointmentRepo appointmentRepo;
	 
	@Override
	public ArrayList<Doctor> selectAllDoctors() {
		return (ArrayList<Doctor>) doctorRepo.findAll();
	}

	@Override
	public ArrayList<Doctor> selectAllDoctorsByType(Speciality speciality) throws Exception{
		if(doctorRepo.existsBySpeciality(speciality)) {
			return doctorRepo.findAllBySpeciality(speciality);
		}else {
			throw new Exception("No doctors by speciality found!");
		}
	}

	@Override
	public ArrayList<Patient> selectAllPatients() {
		return (ArrayList<Patient>) patientRepo.findAll();
	}

	@Override
	public ArrayList<Patient> selectAllPatientsByNameAndSurname(String name, String surname) throws Exception {
		if(patientRepo.existsByNameAndSurname(name, surname)) {
			return patientRepo.findAllByNameAndSurname(name, surname);
		}else {
			throw new Exception("No patients by given name and surname found!");
		}
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByPatientById(int patient_id) throws Exception {
		//TODO
//		if(appointmentRepo.existsById(patient_id)) {
//			return appointmentRepo.findAllById(patient_id);
//		}else {
//			throw new Exception("No appointments with given patient id found!");
//		}
		return null;
		
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByDoctorById(int doctor_id) {
		
		return null;
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByDoctorToday(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

}
