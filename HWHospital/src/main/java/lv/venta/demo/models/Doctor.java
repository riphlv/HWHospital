package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.enums.Gender;
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="User_ID")
@Table(name="Doctors")
public class Doctor extends User {
	@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Speciality")
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

}
