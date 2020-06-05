package lv.venta.demo.models;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Appointment_ID")
	private int appointment_id;
	@Column(name="Date")
	private Date date;
	@Column(name="Description")
	private String description;
	
	//Link to Doctor.java
	@OneToMany(mappedBy = "appointment")
	private Collection<Doctor> doctors;
	//Link to Patient.java
	@OneToMany(mappedBy ="appointment")
	private Collection<Patient> patients;
	//////////////////////////////////////////////////
	public int getAppointment_id() {
		return appointment_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Collection<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	public Collection<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Collection<Patient> patients) {
		this.patients = patients;
	}
	public Date setLocalDateToDate(LocalDateTime time) {
		return java.util.Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
	}
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", date=" + date + ", description=" + description
				+ ", doctors=" + doctors + ", patient=" + patients + "]";
	}
	public Appointment(Date date, String description, Collection<Doctor> doctors,
			Collection<Patient> patients) {
		super();
		this.date = date;
		this.description = description;
		this.doctors = doctors;
		//this.patient = patient;
		this.patients = patients;
	}
	public Appointment(LocalDateTime myDateObj, String description, ArrayList<Doctor> doctors, ArrayList<Patient> patients) {
		super();
		this.date = this.setLocalDateToDate(myDateObj);
		this.description = description;
		this.doctors = doctors;
		this.patients = patients;
	}
	public Appointment() {
		super();
		this.date = new Date();
		this.description = null;
		this.doctors = null;
		this.patients = null;
	}
	
	
}
