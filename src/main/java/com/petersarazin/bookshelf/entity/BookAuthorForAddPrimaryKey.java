package com.petersarazin.bookshelf.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class BookAuthorForAddPrimaryKey implements Serializable {
	
	private static final long serialVersionUID = -5956669510643395219L;

	@ManyToOne( cascade=CascadeType.ALL )
	@JoinColumn( name="bookId" )
	private BookForAdd bookForAdd;
	
	private Integer authorId;

	public BookForAdd getBookForAdd() { return bookForAdd; }
	public void setBookForAdd(BookForAdd bookForAdd) { this.bookForAdd = bookForAdd; }

	public Integer getAuthorId() { return authorId; }
	public void setAuthorId( Integer authorId ) { this.authorId = authorId; }
}
