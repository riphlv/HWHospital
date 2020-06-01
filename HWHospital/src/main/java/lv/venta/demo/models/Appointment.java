package lv.venta.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Appointment_ID")
	private int appointment_id;
	@Column(name="Date")
	private Date date;
	@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Description")
	private String description;
	
	//Link to Doctor.java joined by doctors
	@OneToMany(mappedBy = "appointment")
	//@ManyToOne
	//@JoinColumn(name="User_ID")
	private Collection<Doctor> doctors;
	//Link to Patient.java joined by appointment_id
	@OneToOne
	@JoinColumn(name="User_ID")
	private Patient patient;
	
	public Appointment( Date date, @Pattern(regexp = "[a-zA-Z\\s]+$") String description) {
		this.date = date;
		this.description = description;
	} 
}
