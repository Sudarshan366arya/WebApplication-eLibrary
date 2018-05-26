package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "admin_data", schema = "public")
public class AdminData {
 
	private long admin_id;
	private String admin_name;
    private String admin_password;
	private String admin_user_name;
	private Set<TotalIssuedBooks> totalIssuedBookss2;
	private Set<TotalReturnedBooks> totalReturnedBookss2;
	private Set<StudentData> studentData2;
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="admin_data_admin_id")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "admin_id", unique = true, nullable = false)
	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	
	@Column(name = "admin_name", length = 30)
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	@Column(name = "admin_password", length = 64)
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	@Column(name = "admin_user_name", length = 35)
	public String getAdmin_user_name() {
		return admin_user_name;
	}
	public void setAdmin_user_name(String admin_user_name) {
		this.admin_user_name = admin_user_name;
	}
	
	@OneToMany(mappedBy="adminData2")
	public Set<TotalIssuedBooks> getTotalIssuedBookss2() {
		return totalIssuedBookss2;
	}
	public void setTotalIssuedBookss2(Set<TotalIssuedBooks> totalIssuedBookss2) {
		this.totalIssuedBookss2 = totalIssuedBookss2;
	}
	
	@OneToMany(mappedBy="adminData3")
	public Set<StudentData> getStudentData2() {
		return studentData2;
	}
	public void setStudentData2(Set<StudentData> studentData2) {
		this.studentData2 = studentData2;
	}
	@OneToMany(mappedBy="adminData5")
	public Set<TotalReturnedBooks> getTotalReturnedBookss2() {
		return totalReturnedBookss2;
	}
	public void setTotalReturnedBookss2(Set<TotalReturnedBooks> totalReturnedBookss2) {
		this.totalReturnedBookss2 = totalReturnedBookss2;
	}
	
	
}
