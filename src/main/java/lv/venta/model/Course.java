package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "CourseTAble")
@Entity
public class Course {
	@Column(name = "Cid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	@Column(name = "Title")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A_Z]{1}[a-z]{2,40}")
	private String title;
	
	@Column(name = "CreditPoints")
	@Min(0)
	@Max(20)
	private int creditPoints;
	
	
	@ManyToOne// many courses have linked to one professor
	@JoinColumn(name = "Pid")// use professor id column title
	private Professor professor;
	
	
	@OneToMany(mappedBy = "Course")
	private Collection<Grade>grades;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getCreditPoints() {
		return creditPoints;
	}


	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public int getCid() {
		return cid;
	}
	
	public Course() {}
	public Course(String title, int creditPoints, Professor professor) {
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
		
	}
	public String toString() {return cid + ": " + title + ": "+ creditPoints + "[" + professor +"]";
	}
	
}
