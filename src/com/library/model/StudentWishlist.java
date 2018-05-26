package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "student_wishlist", schema = "public")
public class StudentWishlist {  

	private long list_id;
	private String wishlisted_book;
	private String wishlistedbook_author;
	private String wishlisted_book_publisher;
	private long requested_by_id_foreign;
	private long semester;
	private long branch_type_foreign;
	private boolean is_book_granted;

	//private StudentData studentData4;
	//private BranchType branchType4;

	@GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="student_wishlist_list_id")})
	@Id
	@GeneratedValue(generator = "sequence")
	@Column(name = "list_id", unique = true, nullable = false)
	public long getList_id() {
		return list_id;
	}
	public void setList_id(long list_id) {
		this.list_id = list_id;
	}

	@Column(name = "wishlisted_book",length=30)
	public String getWishlisted_book() {
		return wishlisted_book;
	}
	public void setWishlisted_book(String wishlisted_book) {
		this.wishlisted_book = wishlisted_book;
	}

	@Column(name = "wishlistedbook_author",length=30)
	public String getWishlistedbook_author() {
		return wishlistedbook_author;
	}
	public void setWishlistedbook_author(String wishlistedbook_author) {
		this.wishlistedbook_author = wishlistedbook_author;
	}

	@Column(name = "semester")
	public long getSemester() {
		return semester;
	}
	public void setSemester(long semester) {
		this.semester = semester;
	}

	@Column(name = "is_book_granted" ,nullable = false)
	public boolean isIs_book_granted() {
		return is_book_granted;
	}
	public void setIs_book_granted(boolean is_book_granted) {
		this.is_book_granted = is_book_granted;
	}
	@Column(name = "wishlisted_book_publisher",length=50)
	public String getWishlisted_book_publisher() {
		return wishlisted_book_publisher;
	}
	public void setWishlisted_book_publisher(String wishlisted_book_publisher) {
		this.wishlisted_book_publisher = wishlisted_book_publisher;
	}
	
	@Column(name = "requested_by_id_foreign")
	public long getRequested_by_id_foreign() {
		return requested_by_id_foreign;
	}
	public void setRequested_by_id_foreign(long requested_by_id_foreign) {
		this.requested_by_id_foreign = requested_by_id_foreign;
	}
	
	@Column(name = "branch_type_foreign")
	public long getBranch_type_foreign() {
		return branch_type_foreign;
	}
	public void setBranch_type_foreign(long branch_type_foreign) {
		this.branch_type_foreign = branch_type_foreign;
	}
	/*
	@ManyToOne
	@JoinColumn(name="requested_by_id_foreign",nullable=false)
	public StudentData getStudentData4() {
		return studentData4;
	}
	public void setStudentData4(StudentData studentData4) {
		this.studentData4 = studentData4;
	}

	@ManyToOne
	@JoinColumn(name="branch_type_foreign",nullable=false)
	public BranchType getBranchType4() {
		return branchType4;
	}
	public void setBranchType4(BranchType branchType4) {
		this.branchType4 = branchType4;
	}*/
}
