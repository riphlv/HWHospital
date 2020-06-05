package lv.venta.demo.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lv.venta.demo.enums.Gender;

@Entity
@Table(name="Patients")
public class Patient extends User {
	//Link to Appointment.java joined by user_id
	@ManyToOne
	@JoinColumn(name="Appointment_ID")
	private Appointment appointment;
	public Patient(String password, String name, String surname, Gender gender, String personalCN) {
		super(password, name, surname, gender, personalCN);
	} 
	public Patient() {
		super();
	}
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Patient [appointment=" + appointment + ", toString()=" + super.toString() + "]";
	}
}
