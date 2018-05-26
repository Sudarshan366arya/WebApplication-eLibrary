package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "student_issued_data", schema = "public")
public class StudentIssuedData {
	private long  issuing_id;
	//private long  student_id_foreign;
	private double total_due_balance;
	private double previous_total_due;
	private long  number_of_books_issued;
	private StudentData studentData1;
	private Set<TotalIssuedBooks> totalIssuedBooks;
	private Set<TotalReturnedBooks> totalReturnedBooks;
	
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="student_issued_data_issuing_id")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "issuing_id", unique = true, nullable = false)
	public long getIssuing_id() {
		return issuing_id;
	}
	public void setIssuing_id(long issuing_id) {
		this.issuing_id = issuing_id;
	}
	
	/*
	@Column(name = "student_id_foreign")
	public long getStudent_id_foreign() {
		return student_id_foreign;
	}
	public void setStudent_id_foreign(long student_id_foreign) {
		this.student_id_foreign = student_id_foreign;
	}*/
	
	@Column(name = "total_due_balance")
	public double getTotal_due_balance() {
		return total_due_balance;
	}
	public void setTotal_due_balance(double total_due_balance) {
		this.total_due_balance = total_due_balance;
	}
	
	@Column(name = "previous_total_due")
	public double getPrevious_total_due() {
		return previous_total_due;
	}
	public void setPrevious_total_due(double previous_total_due) {
		this.previous_total_due = previous_total_due;
	}
	
	@Column(name = "number_of_books_issued")
	public long getNumber_of_books_issued() {
		return number_of_books_issued;
	}
	public void setNumber_of_books_issued(long number_of_books_issued) {
		this.number_of_books_issued = number_of_books_issued;
	}
	
	@ManyToOne
	@JoinColumn(name="student_id_foreign")
	public StudentData getStudentData1() {
		return studentData1;
	}
	public void setStudentData1(StudentData studentData1) {
		this.studentData1 = studentData1;
	}
	
	@OneToMany(mappedBy="studentIssuedData1")
	public Set<TotalIssuedBooks> getTotalIssuedBooks() {
		return totalIssuedBooks;
	}
	public void setTotalIssuedBooks(Set<TotalIssuedBooks> totalIssuedBooks) {
		this.totalIssuedBooks = totalIssuedBooks;
	}
	
	@OneToMany(mappedBy="studentIssuedData5")
	public Set<TotalReturnedBooks> getTotalReturnedBooks() {
		return totalReturnedBooks;
	}
	public void setTotalReturnedBooks(Set<TotalReturnedBooks> totalReturnedBooks) {
		this.totalReturnedBooks = totalReturnedBooks;
	}

}
