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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="Book" )
public class BookForAdd implements Serializable
{
	private static final long serialVersionUID = 9008071445663294090L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )	
	private Integer bookId;
	
	private String title;
	private String isbn;
	private BigDecimal price;
	
    @OneToMany( mappedBy = "bookAuthorForAddPrimaryKey.bookForAdd", cascade = { CascadeType.ALL })
    private Set<BookAuthorForAdd> bookAuthorForAddSet = new HashSet<BookAuthorForAdd>();

    private String imageUrl;
    
    private Integer publisherId;

	public Integer getBookId() { return bookId; }
	public void setBookId( Integer bookId ) { this.bookId = bookId; }

	public String getTitle() { return title; }
	public void setTitle( String title ) { this.title = title; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn( String isbn ) { this.isbn = isbn; }
	
	public Set<BookAuthorForAdd> getBookAuthorForAddSet() { return bookAuthorForAddSet; }
	public void setBookAuthorForAddSet( Set<BookAuthorForAdd> bookAuthorForAddSet ) { this.bookAuthorForAddSet = bookAuthorForAddSet; }
	
	public Integer getPublisherId() { return publisherId; }
	public void setPublisherId(Integer publisherId) { this.publisherId = publisherId; }
	
	public BigDecimal getPrice() { return price; }
	public void setPrice(BigDecimal price) { this.price = price; }
	
	public String getImageUrl() { return imageUrl; }
	public void setImageUrl( String imageUrl ) { this.imageUrl = imageUrl; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((publisherId == null) ? 0 : publisherId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookForAdd other = (BookForAdd) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (publisherId == null) {
			if (other.publisherId != null)
				return false;
		} else if (!publisherId.equals(other.publisherId))
			return false;
		return true;
	}
	
	
}
