package lv.venta.demo.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.enums.Gender;
import lv.venta.demo.enums.Speciality;
import lv.venta.demo.models.Appointment;
import lv.venta.demo.models.Doctor;
import lv.venta.demo.models.Patient;
import lv.venta.demo.models.User;
import lv.venta.demo.repos._AppointmentRepo;
import lv.venta.demo.repos._DoctorRepo;
import lv.venta.demo.repos._PatientRepo;
import lv.venta.demo.repos._UserRepo;
import lv.venta.demo.services._DataInput;

@Service
public class DataInputImpl implements _DataInput{
	@Autowired
	_DoctorRepo doctorRepo;
	@Autowired
	_PatientRepo patientRepo;
	@Autowired
	_AppointmentRepo appointmentRepo;
	 @Autowired
	 _UserRepo userRepo;
	
	@Override
	public void inputData() {
		Doctor d1 = new Doctor("123", "doc0","sur0", Gender.Female,"111111-11111",Speciality.Gynecologist);
		Doctor d2 = new Doctor("123", "doc1","sur1", Gender.Male,"222222-22222",Speciality.Neurologist);
		Doctor d3 = new Doctor("123", "doc2","sur2", Gender.Male,"333333-33333",Speciality.Surgeon);
		doctorRepo.save(d1);
		doctorRepo.save(d2);
		doctorRepo.save(d3);
		Patient p1 = new Patient("123","pat1","surname4",Gender.Female,"444444-44444");
		Patient p2 = new Patient("123","pat2","surname5",Gender.Male,"555555-55555");
		Patient p3 = new Patient("123","pat3","surname6",Gender.Female,"666666-66666");
		patientRepo.save(p1);
		patientRepo.save(p2);
		patientRepo.save(p3);
		LocalDateTime myDateObj0 = LocalDateTime.of(2020, 06, 14, 12, 30);
		LocalDateTime myDateObj1 = LocalDateTime.of(2020, 06, 14, 13, 30);
		LocalDateTime myDateObj2 = LocalDateTime.of(2020, 06, 15, 12, 00);
		LocalDateTime myDateObj3 = LocalDateTime.of(2020, 06, 15, 13, 00);
		LocalDateTime myDateObj4 = LocalDateTime.of(2020, 06, 15, 13, 00);
		
		appointmentRepo.save(new Appointment(myDateObj0, "desc1", new ArrayList<Doctor>(Arrays.asList(d1,d2)),new ArrayList<Patient>(Arrays.asList(p1))));
		appointmentRepo.save(new Appointment(myDateObj1, "desc1", new ArrayList<Doctor>(Arrays.asList(d2)),new ArrayList<Patient>(Arrays.asList(p1))));
		appointmentRepo.save(new Appointment(myDateObj2, "desc2", new ArrayList<Doctor>(Arrays.asList(d3)),new ArrayList<Patient>(Arrays.asList(p2))));
		appointmentRepo.save(new Appointment(myDateObj3, "desc2", new ArrayList<Doctor>(Arrays.asList(d3)),new ArrayList<Patient>(Arrays.asList(p2))));
		appointmentRepo.save(new Appointment(myDateObj4, "desc3", new ArrayList<Doctor>(Arrays.asList(d1)),new ArrayList<Patient>(Arrays.asList(p3))));
		System.out.println("input success");
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
	public Patient updatePatientById(int id) {
		return patientRepo.findById(id).get();
	}

	@Override
	public boolean deletePatientById(int id) {
		if(!patientRepo.existsById(id)) {
			return false;
		}else {
			patientRepo.deleteById(id);
		}
		return true;
	}

	@Override
	public boolean insertNewAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void updatePatientByObject(Patient patient) {
		Patient temp = patientRepo.findByPersonalCN(patient.getPersonalCN());
		temp.setAppointment(patient.getAppointment());
		temp.setGender(patient.getGender());
		temp.setName(patient.getName());
		temp.setPassword(patient.getPassword());
		temp.setPersonalCN(patient.getPersonalCN());
		temp.setSurname(patient.getSurname());
		patientRepo.save(temp);
	}
	public void authoriseUser(User user) {
		if(!userRepo.existsUserByPersonalCNAndPassword(user.getPersonalCN(),user.getPassword())) {
			System.out.println("didnt find user");
		}else {
			System.out.println("found - " + user);
		}
	}
	
}
