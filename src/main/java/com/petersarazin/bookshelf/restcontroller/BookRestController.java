package com.petersarazin.bookshelf.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petersarazin.bookshelf.dto.BookDto;
import com.petersarazin.bookshelf.dto.BookForAddDto;
import com.petersarazin.bookshelf.dto.response.AddBookResponse;
import com.petersarazin.bookshelf.dto.response.GetBooksResponse;
import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookForAdd;
import com.petersarazin.bookshelf.mapper.BookMapper;
import com.petersarazin.bookshelf.service.BookService;

@RestController
@RequestMapping( "/book" )
public class BookRestController
{
	@Autowired
	BookService bookService;
	
	@GetMapping
	public GetBooksResponse getAllBooks() {
		
		GetBooksResponse getBooksResponse = new GetBooksResponse();
		List<Book> bookList = bookService.getAllBooks();
		getBooksResponse.setBookList( BookMapper.map( bookList ) );
		return getBooksResponse;
	}

	@GetMapping( "/{bookId}" )
	public BookDto getBookById( @PathVariable Integer bookId ) {
		
		Book book =  bookService.getBookByBookId( bookId );
		return( BookMapper.map( book ) );
	}
	
	@GetMapping( "/author/{authorId}" )
	public GetBooksResponse getBooksByAuthorId( @PathVariable Integer authorId ) {
		
		GetBooksResponse getBooksResponse = new GetBooksResponse();
		List<Book> bookList = bookService.getBooksByAuthorId( authorId );
		getBooksResponse.setBookList( BookMapper.map( bookList ) );
		return getBooksResponse;
	}
	
	@PostMapping()
	public AddBookResponse addBook( @RequestBody BookForAddDto bookForAddDto ) {
		
		AddBookResponse addBookResponse = new AddBookResponse();

		try {
			
			BookForAdd bookForAdd = BookMapper.map( bookForAddDto );
			bookService.addBook( bookForAdd );
			addBookResponse.setStatus( "SUCCESS" );
		}
		catch( RuntimeException re ) {
			
			System.err.println( re.getClass().getSimpleName() + " caught in addBook(): " + re.getMessage() );
			re.printStackTrace();
			addBookResponse.setMessage( re.getMessage() );
			addBookResponse.setStatus( "ERROR");
		}

		return addBookResponse;
	}
}
