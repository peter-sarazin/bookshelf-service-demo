package com.petersarazin.bookshelf.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookForAdd;

@Repository
public class BookRepositoryImpl extends GenericRepositoryImpl<Book> implements BookRepository
{

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByAuthorId( Integer authorId ) {
		
		List<Book> bookList = null;
		
		try {
			
			bookList = ( List<Book> )em.createQuery( "select b from Book b join b.authors a where a.authorId = :authorId" )
					.setParameter( "authorId", authorId )
					.getResultList();
		}
		catch( NoResultException nre ) {
			
			System.out.println( "INFO: authorId " + authorId + " not found." );
		}
		catch( RuntimeException re ) {
			
			String message = re.getClass().getSimpleName() + " caught in BookRepositoryImpl.findByAuthorId(): " + re.getMessage();
			System.err.println( message );
			throw re;
		}
		
		return bookList;
	}

	
	@Override
	public void persist( BookForAdd bookForAdd ) {

		if( bookForAdd == null ) {
			
			throw new IllegalArgumentException( "bookForAdd must not be null." );
		}
		
		em.persist( bookForAdd );
	}
}
