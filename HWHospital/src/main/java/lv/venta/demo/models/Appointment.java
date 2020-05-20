package lv.venta.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class Appointment {
	@Column(name="Appointment_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appointment_id;
	@Column(name="Date")
	private Date date;
	@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Description")
	private String description;
	
	//TODO LINKOT
	public Appointment( Date date, @Pattern(regexp = "[a-zA-Z\\s]+$") String description) {
		this.date = date;
		this.description = description;
	} 
}
