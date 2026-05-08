package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Table(name = "GradeTAble")
@Entity
public class Grade {
	
	
	@Column(name = "Gid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gid;
	
	
	@Column(name = "GradeValue")
	@Min(0)
	@Max(10)
	private int gradeValue;
	
	
	@ManyToOne
	@JoinColumn (name = "Cid")
	private Course course;
	
	
	@ManyToOne
	@JoinColumn(name = "Sid")
	private student student;
	
	
	
	
}
