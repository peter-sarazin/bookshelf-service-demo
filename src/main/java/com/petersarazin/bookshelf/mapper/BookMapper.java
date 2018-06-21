package com.petersarazin.bookshelf.mapper;

import java.util.ArrayList;
import java.util.List;

import com.petersarazin.bookshelf.dto.BookDto;
import com.petersarazin.bookshelf.dto.BookForAddDto;
import com.petersarazin.bookshelf.dto.PublisherDto;
import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookAuthorForAdd;
import com.petersarazin.bookshelf.entity.BookAuthorForAddPrimaryKey;
import com.petersarazin.bookshelf.entity.BookForAdd;

public class BookMapper {
	
	public static List<BookDto> map( List<Book> bookList ) {
		
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		
		if( bookList != null ) {
			
			for( Book book : bookList ) {
				BookDto bookDto = map( book );
				bookDtoList.add( bookDto );
			}
		}

		return bookDtoList;
	}


	public static BookDto map( Book book ) {
		
		BookDto bookDto = null;
		
		if( book != null ) {
			
			bookDto = new BookDto();
			bookDto.setBookId( book.getBookId() );
			bookDto.setTitle( book.getTitle() );
			bookDto.setIsbn( book.getIsbn() );
			bookDto.setPrice( book.getPrice() );
			bookDto.setImageUrl( book.getImageUrl() );
			bookDto.setPublisher( PublisherMapper.map( book.getPublisher() ) );
			
			bookDto.setAuthors( AuthorMapper.map( book.getAuthors() ) );
		}
		
		return bookDto;
	}
	
	
	public static Book map( BookDto bookDto ) {
		
		if( bookDto == null ) {
		
			throw new IllegalArgumentException( "bookDto must not be null." ); 
		}
		
		Book book = new Book();
		book.setTitle( bookDto.getTitle() );
		book.setIsbn( bookDto.getIsbn() );
		book.setPrice( bookDto.getPrice() );
		book.setImageUrl( bookDto.getImageUrl() );
		
		PublisherDto publisherDto = bookDto.getPublisher();
		
		book.setPublisher( PublisherMapper.map( publisherDto ) ); 
		
		return book;
	}
	

	public static BookForAdd map( BookForAddDto bookForAddDto ) {
		
		if( bookForAddDto == null ) {
		
			throw new IllegalArgumentException( "bookForAddDto must not be null." ); 
		}
		
		BookForAdd bookForAdd = new BookForAdd();
		bookForAdd.setTitle( bookForAddDto.getTitle() );
		bookForAdd.setIsbn( bookForAddDto.getIsbn() );
		bookForAdd.setPrice( bookForAddDto.getPrice() );
		bookForAdd.setImageUrl( bookForAddDto.getImageUrl() );
		
		// publisher
		bookForAdd.setPublisherId( bookForAddDto.getPublisherId() );
		
		// author(s)
		for( Integer authorId : bookForAddDto.getAuthorIds() ) {
			
			BookAuthorForAdd bookAuthorForAdd = new BookAuthorForAdd();
			BookAuthorForAddPrimaryKey bookAuthorForAddPrimaryKey = new BookAuthorForAddPrimaryKey();
			bookAuthorForAddPrimaryKey.setAuthorId( authorId );
			bookAuthorForAddPrimaryKey.setBookForAdd( bookForAdd );
			bookAuthorForAdd.setBookAuthorForAddPrimaryKey( bookAuthorForAddPrimaryKey );
			
			bookForAdd.getBookAuthorForAddSet().add( bookAuthorForAdd );
		}
		
		return bookForAdd;
	}
}
