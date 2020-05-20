package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.enums.Gender;
@Entity
@Table(name="Doctors")
public class Doctor extends User {
	@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Speciality")
	private Speciality speciality;
	//TODO LINKOT
	public Doctor(String password, String name, String surname, Gender gender,String personalCN, Speciality speciality) {
		super(password, name, surname, gender, personalCN);
		this.speciality = speciality;
	} 

}
