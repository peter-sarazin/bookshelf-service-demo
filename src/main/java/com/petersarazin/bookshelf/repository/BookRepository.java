package com.petersarazin.bookshelf.repository;

import java.util.List;

import com.petersarazin.bookshelf.entity.Book;
import com.petersarazin.bookshelf.entity.BookForAdd;

public interface BookRepository extends GenericRepository<Book>
{

	List<Book> findByAuthorId( Integer authorId );
	void persist( BookForAdd bookForAdd );

}
