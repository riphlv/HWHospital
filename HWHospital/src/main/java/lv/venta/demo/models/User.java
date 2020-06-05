package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lv.venta.demo.enums.Gender;

@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Column(name="User_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@Column(name="Password")
	private String password;
	 
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Name")
	private String name;
	
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	@Column(name="Surname")
	private String surname;
	
	@Column(name="Gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	//Personas kods
	//Personal Code Number
	@Column(name="PersonalCN")
	private String personalCN;
	public User(String password, String name, String surname, Gender gender, String personalCN ) {
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.personalCN = personalCN;
	}
	public User() {
		this.password = null;
		this.name = null;
		this.surname = null;
		this.gender = null;
		this.personalCN = null;
	}

	public String getPersonalCN() {
		return personalCN;
	}

	public void setPersonalCN(String personalCN) {
		this.personalCN = personalCN;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUser_id() {
		return user_id;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", gender=" + gender + "]";
	}

	
	
	
	
}
