package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.enums.Gender;
@Entity
@Table(name="Doctors")
public class Doctor extends User {
	@Column(name="Speciality")
	@Enumerated(EnumType.STRING)
	private Speciality speciality;
	//Link to Appointment.java joined by user_id
	@ManyToOne
	@JoinColumn(name="Appointment_ID")
	//@OneToMany(mappedBy="doctors")
	private Appointment appointment;
	
	public Doctor(String password, String name, String surname, Gender gender,String personalCN, Speciality speciality) {
		super(password, name, surname, gender, personalCN);
		this.speciality = speciality;
	}
	public Doctor() {
		super();
		this.speciality = null;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", appointment=" + appointment + ", toString()=" + super.toString()
				+ "]";
	}
	

	
}
