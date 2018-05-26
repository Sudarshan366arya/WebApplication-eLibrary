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
@Table(name = "student_data", schema = "public")
public class StudentData {

	long student_id;
	//int branch_id_foreign;
	private boolean is_approved;
	private long roll;
	private String name;
	private String password;
	private long batch;
	private Set<StudentIssuedData> studentIssuedData;
	//private Set<StudentWishlist> studentWishlists1;
	private BranchType branchType1;
	private boolean is_rejected;
	private AdminData adminData3;
	
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="student_data_student_id")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "student_id", unique = true, nullable = false)
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	/*
	@Column(name = "branch_id_foreign")
	public int getBranch_id_foreign() {
		return branch_id_foreign;
	}
	public void setBranch_id_foreign(int branch_id_foreign) {
		this.branch_id_foreign = branch_id_foreign;
	}*/
	
	@Column(name = "is_approved" ,nullable = false)
	public boolean isIs_approved() {
		return is_approved;
	}
	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}
	
	@Column(name = "roll")
	public long getRoll() {
		return roll;
	}
	public void setRoll(long roll) {
		this.roll = roll;
	}
	
	@Column(name = "name",nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "password",length=64,nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "batch",nullable = false)
	public long getBatch() {
		return batch;
	}
	public void setBatch(long batch) {
		this.batch = batch;
	}
	
	@OneToMany(mappedBy="studentData1")
	public Set<StudentIssuedData> getStudentIssuedData() {
		return studentIssuedData;
	}
	public void setStudentIssuedData(Set<StudentIssuedData> studentIssuedData) {
		this.studentIssuedData = studentIssuedData;
	}
	
	@ManyToOne
	@JoinColumn(name="branch_id_foreign")
	public BranchType getBranchType1() {
		return branchType1;
	}
	public void setBranchType1(BranchType branchType1) {
		this.branchType1 = branchType1;
	}
	
	@Column(name = "is_rejected",nullable = false)
	public boolean isIs_rejected() {
		return is_rejected;
	}
	public void setIs_rejected(boolean is_rejected) {
		this.is_rejected = is_rejected;
	}
	
	@ManyToOne
	@JoinColumn(name="approved_or_rejected_by")
	public AdminData getAdminData3() {
		return adminData3;
	}
	public void setAdminData3(AdminData adminData3) {
		this.adminData3 = adminData3;
	}
	
	/*
	@OneToMany(mappedBy="studentData4")
	public Set<StudentWishlist> getStudentWishlists1() {
		return studentWishlists1;
	}
	public void setStudentWishlists1(Set<StudentWishlist> studentWishlists1) {
		this.studentWishlists1 = studentWishlists1;
	}*/
}
