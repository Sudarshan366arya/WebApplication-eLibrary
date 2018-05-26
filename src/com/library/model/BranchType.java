package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "branch_type", schema = "public")
public class BranchType {
	private long branch_id;
	private String branch_name;
	private Set<StudentData> studentDatas;
	private Set<AvailableBooks> availableBookss;
	//private Set<StudentWishlist> studentWishlists2;
	@Id
	@Column(name = "branch_id", unique = true, nullable = false)
	public long getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(long branch_id) {
		this.branch_id = branch_id;
	}
	
	@Column(name = "branch_name",length=15)
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	
	@OneToMany(mappedBy="branchType1")
	public Set<StudentData> getStudentDatas() {
		return studentDatas;
	}
	public void setStudentDatas(Set<StudentData> studentDatas) {
		this.studentDatas = studentDatas;
	}
	
	@OneToMany(mappedBy="branchType2")
	public Set<AvailableBooks> getAvailableBookss() {
		return availableBookss;
	}
	public void setAvailableBookss(Set<AvailableBooks> availableBookss) {
		this.availableBookss = availableBookss;
	}
	
	/*
	@OneToMany(mappedBy="branchType4")
	public Set<StudentWishlist> getStudentWishlists2() {
		return studentWishlists2;
	}
	public void setStudentWishlists2(Set<StudentWishlist> studentWishlists2) {
		this.studentWishlists2 = studentWishlists2;
	}*/
}
