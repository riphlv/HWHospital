package lv.venta.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lv.venta.demo.enums.Gender;

@Entity
@Table(name="Patients")
public class Patient extends User {
	//TODO LINKOT
	//ArrayList<Appointment>appointment; TODO H2
	public Patient(String password, String name, String surname, Gender gender, String personalCN) {
		super(password, name, surname, gender, personalCN);
		// TODO Auto-generated constructor stub
	} 


}