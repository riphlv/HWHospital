package lv.venta.demo.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lv.venta.demo.enums.Gender;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="User_ID")
@Table(name="Patients")
public class Patient extends User {
	//Link to Appointment.java joined by user_id
	@OneToOne(mappedBy = "patient")
	Appointment appointment;
	//ArrayList<Appointment>appointment; TODO H2
	public Patient(String password, String name, String surname, Gender gender, String personalCN) {
		super(password, name, surname, gender, personalCN);
		// TODO Auto-generated constructor stub
	} 


}
