package com.petersarazin.bookshelf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookForAdd;
import com.petersarazin.bookshelf.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll( Book.class );
	}

	public Book getBookByBookId( int bookId ) {
		
		return bookRepository.findById( Book.class, bookId );
	}

	@Override
	public List<Book> getBooksByAuthorId( Integer authorId ) {
		
		return bookRepository.findByAuthorId( authorId );
	}

	@Override
	@Transactional
	public void addBook( BookForAdd bookForAdd ) {
		
		bookRepository.persist( bookForAdd );
	}
}
