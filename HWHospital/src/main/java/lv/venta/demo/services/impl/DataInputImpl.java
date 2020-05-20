package lv.venta.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.enums.Gender;
import lv.venta.demo.enums.Speciality;
import lv.venta.demo.models.Appointment;
import lv.venta.demo.models.Doctor;
import lv.venta.demo.models.Patient;
import lv.venta.demo.repos._AppointmentRepo;
import lv.venta.demo.repos._DoctorRepo;
import lv.venta.demo.repos._PatientRepo;
import lv.venta.demo.services._DataInput;

@Service
public class DataInputImpl implements _DataInput{
	@Autowired
	_DoctorRepo doctorRepo;
	@Autowired
	_PatientRepo patientRepo;
	@Autowired
	_AppointmentRepo appointmentRepo;
	 
	
	@Override
	public void inputData() {
		doctorRepo.save(new Doctor("123", "Janis","Berzins",Gender.Male, "111111-11111", Speciality.Gynecologist ));
		doctorRepo.save(new Doctor("123", "doc1","surname1",Gender.Male, "222222-22222", Speciality.Neurologist ));
		doctorRepo.save(new Doctor("123", "doc2","surname2",Gender.Female, "333333-33333", Speciality.Surgeon ));
		
		patientRepo.save(new Patient("123","pat1","surname3",Gender.Female,"444444-44444"));
		patientRepo.save(new Patient("123","pat2","surname4",Gender.Male,"555555-55555"));
		patientRepo.save(new Patient("123","pat2","surname5",Gender.Female,"666666-66666"));
		
		//appointmentRepo.save(new Appointment());
	}

	@Override
	public boolean insertPatient(Patient patient) {
		if(patientRepo.existsByPersonalCN(patient.getPersonalCN())) {
			return false;
		}else {
			patientRepo.save(patient);
			return true;
		}
	}

	@Override
	public boolean insertDoctor(Doctor doctor) {
		if(doctorRepo.existsByPersonalCN(doctor.getPersonalCN())) {
			return false;
		}else {
			doctorRepo.save(doctor);
			return true;
		}
	}

	@Override
	public boolean updatePatientById(int id, Patient patient) {
		if(!patientRepo.existsById(id) || patientRepo.equals(null)) {
			return false;
		}else {
			Patient tempPatient = patientRepo.findById(id).get();
			
			tempPatient.setGender(patient.getGender());
			tempPatient.setName(patient.getName());
			tempPatient.setPassword(patient.getPassword());
			tempPatient.setPersonalCN(patient.getPersonalCN());
			tempPatient.setSurname(patient.getSurname());
			
			patientRepo.save(tempPatient);
			return true;
		}
	}

	@Override
	public boolean deletePatientById(int id) {
		if(!patientRepo.existsById(id)) {
			return false;
		}else {
			patientRepo.deleteById(id);
		}
		return false;
	}

	@Override
	public boolean insertNewAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
