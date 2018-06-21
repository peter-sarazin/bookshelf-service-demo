package com.petersarazin.bookshelf.service;

import java.util.List;

import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookForAdd;

public interface BookService
{
	List<Book> getAllBooks();
	Book getBookByBookId( int bookId );
	List<Book> getBooksByAuthorId( Integer authorId );
	void addBook( BookForAdd bookForAdd );
}
