package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "ProfessorTAble")
@Entity


public class Professor {
	@Column(name = "Pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	
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
	
	
	@NotNull
    @Column()
	private Degree degree;
	
	
	@OneToMany(mappedBy = "Professor")//one professor has many courses,mapped by - use course class professor variable name
	private Collection<Course>courses;
	//Setters and Getters
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
	public Degree getdegree() {
		return degree;
	}
	public void setdegree(Degree degree) {
		this.degree = degree;
	}
	public int getPid() {
		return pid;
	}
	
	// constructors
	public Professor() {}
	public Professor(String name, String surname, Degree degree) {
		setName(name);
		setSurname(surname);
		setdegree(degree);
		}


	
	public String toString() {return pid + ": " + name + ": "+ surname + "[" + degree +"]";
	}
	
}
