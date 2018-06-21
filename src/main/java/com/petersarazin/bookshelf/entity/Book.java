package com.petersarazin.bookshelf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable
{
	private static final long serialVersionUID = -9009459457098398446L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )	
	private Integer bookId;
	
	private String title;
	private String isbn;
	private BigDecimal price;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "BookAuthor", 
        joinColumns = { @JoinColumn(name = "bookId") }, 
        inverseJoinColumns = { @JoinColumn(name = "authorId") }
    )
    private Set<Author> authors = new HashSet<>();

    private String imageUrl;
    
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn( name="publisherId" )
    private Publisher publisher;

	public Integer getBookId() { return bookId; }
	public void setBookId( Integer bookId ) { this.bookId = bookId; }

	public String getTitle() { return title; }
	public void setTitle( String title ) { this.title = title; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn( String isbn ) { this.isbn = isbn; }
	
	public Set<Author> getAuthors() { return authors; }
	public void setAuthors( Set<Author> authors ) { this.authors = authors; }
	
	public Publisher getPublisher() { return publisher; }
	public void setPublisher( Publisher publisher ) { this.publisher = publisher; }
	
	public BigDecimal getPrice() { return price; }
	public void setPrice(BigDecimal price) { this.price = price; }
	
	public String getImageUrl() { return imageUrl; }
	public void setImageUrl( String imageUrl ) { this.imageUrl = imageUrl; }
}
