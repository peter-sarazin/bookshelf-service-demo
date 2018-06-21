package com.petersarazin.bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petersarazin.bookshelf.entity.Author;
import com.petersarazin.bookshelf.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	@Override
	public List<Author> getAllAuthors() {

		return authorRepository.findAll( Author.class );
	}

}
