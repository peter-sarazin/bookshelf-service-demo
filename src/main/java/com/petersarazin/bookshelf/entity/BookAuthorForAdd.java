package com.petersarazin.bookshelf.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name="BookAuthor" )
public class BookAuthorForAdd implements Serializable {

	private static final long serialVersionUID = -7920883879156716439L;

	@EmbeddedId
	BookAuthorForAddPrimaryKey bookAuthorForAddPrimaryKey;

	public BookAuthorForAddPrimaryKey getBookAuthorForAddPrimaryKey() { return bookAuthorForAddPrimaryKey; }
	public void setBookAuthorForAddPrimaryKey( BookAuthorForAddPrimaryKey bookAuthorForAddPrimaryKey ) { this.bookAuthorForAddPrimaryKey = bookAuthorForAddPrimaryKey; }

}
