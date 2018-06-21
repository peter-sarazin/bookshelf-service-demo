package com.petersarazin.bookshelf.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author implements Serializable
{
	private static final long serialVersionUID = -5436293085840611654L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )	
	private Integer authorId;
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	@ManyToMany( mappedBy = "authors" )
	private Set<Book> books = new HashSet<>();
	
	public Integer getAuthorId() { return authorId; }
	public void setAuthorId(Integer authorId) { this.authorId = authorId; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName( String firstName ) { this.firstName = firstName; }
	
	public String getMiddleName() { return middleName; }
	public void setMiddleName( String middleName ) { this.middleName = middleName; }
	
	public String getLastName() { return lastName; }
	public void setLastName( String lastName ) { this.lastName = lastName; }
	
	public Set<Book> getBooks() { return books; }
	public void setBooks( Set<Book> books ) { this.books = books; }
}
