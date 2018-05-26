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
@Table(name = "available_books", schema = "public")
public class AvailableBooks {
 
	 private long book_id;
	 private String book_name;
	 private String book_author;
	// private int book_branch_type;
	 private boolean is_book_available;
	 private String book_description;
	 private long book_semester;
	 private long number_of_available_books;
	 private Set<TotalIssuedBooks> totalIssuedBookss;
	 private Set<TotalReturnedBooks> totalReturnedBookss;
	 private BranchType branchType2;
	 public AvailableBooks(){
		 
	 }
	 
     public AvailableBooks(int book_id,String book_name,String book_author,String book_description,boolean is_book_available,int book_semester){
		 this.book_id=book_id;
    	 this.book_name=book_name;
		 this.book_author=book_author;
		 this.book_description=book_description;
		 this.is_book_available=is_book_available;
		 this.book_semester=book_semester;
	 }
     public AvailableBooks(String branch_name,int book_id,String book_name,String book_author,boolean is_book_available,String book_description,int book_semester,int number_of_available_books){
    	 branchType2=new BranchType();
    	 branchType2.setBranch_name(branch_name);
    	 this.book_id=book_id;
    	 this.book_name=book_name;
		 this.book_author=book_author;
		 this.is_book_available=is_book_available;
		 this.book_description=book_description;
		 this.book_semester=book_semester;
		 this.number_of_available_books=number_of_available_books;
	 }
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters={@Parameter(name="sequence",value="available_books_book_id")})
 	@Id
 	@GeneratedValue(generator = "sequence")
 	@Column(name = "book_id", unique = true, nullable = false)
    public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	
	@Column(name = "book_name",length=75)
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	@Column(name = "book_author",length=50)
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	/*
	@Column(name = "book_branch_type")
	public int getBook_branch_type() {
		return book_branch_type;
	}
	public void setBook_branch_type(int book_branch_type) {
		this.book_branch_type = book_branch_type;
	}*/
	
	@Column(name = "is_book_available")
	public boolean isIs_book_available() {
	  return is_book_available;
	}
	public void setIs_book_available(boolean is_book_available) {
		this.is_book_available = is_book_available;
	}
	
	@Column(name = "book_description",length=100)
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}
	
	@Column(name = "book_semester")
	public long getBook_semester() {
		return book_semester;
	}
	public void setBook_semester(long book_semester) {
		this.book_semester = book_semester;
	}
	
	@Column(name = "number_of_available_books")
	public long getNumber_of_available_books() {
		return number_of_available_books;
	}
	public void setNumber_of_available_books(long number_of_available_books) {
		this.number_of_available_books = number_of_available_books;
	}

	@OneToMany(mappedBy="availableBooks1")
	public Set<TotalIssuedBooks> getTotalIssuedBookss() {
		return totalIssuedBookss;
	}

	public void setTotalIssuedBookss(Set<TotalIssuedBooks> totalIssuedBookss) {
		this.totalIssuedBookss = totalIssuedBookss;
	}

	@ManyToOne
	@JoinColumn(name="book_branch_type")
	public BranchType getBranchType2() {
		return branchType2;
	}

	public void setBranchType2(BranchType branchType2) {
		this.branchType2 = branchType2;
	}

	@OneToMany(mappedBy="availableBooks5")
	public Set<TotalReturnedBooks> getTotalReturnedBookss() {
		return totalReturnedBookss;
	}

	public void setTotalReturnedBookss(Set<TotalReturnedBooks> totalReturnedBookss) {
		this.totalReturnedBookss = totalReturnedBookss;
	}
}
