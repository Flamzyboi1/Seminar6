package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "StudentTAble")
@Entity

public class student {
	@Column(name = "Sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	@Column(name = "Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A_Z]{1}[a-z]{2,40}")
	private String name;
	@Column(name = "Surname")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A_Z]{1}[a-z]{2,40}")
	private String surname;
	public int getSid() {
		return sid;
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

	public student() {}
	public student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
}
