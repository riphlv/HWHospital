package lv.venta.demo.services;

import lv.venta.demo.models.Appointment;
import lv.venta.demo.models.Doctor;
import lv.venta.demo.models.Patient;

public interface _DataInput {
	void inputData();
	boolean insertPatient(Patient patient);
	boolean insertDoctor(Doctor doctor);
	boolean updatePatientById(int id, Patient patient);
	boolean deletePatientById(int id);
	boolean insertNewAppointment(Appointment appointment);
} 
