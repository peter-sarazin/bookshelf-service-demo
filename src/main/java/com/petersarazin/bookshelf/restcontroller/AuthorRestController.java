package com.petersarazin.bookshelf.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petersarazin.bookshelf.dto.response.GetAuthorsResponse;
import com.petersarazin.bookshelf.entity.Author;
import com.petersarazin.bookshelf.mapper.AuthorMapper;
import com.petersarazin.bookshelf.service.AuthorService;

@RestController
@RequestMapping( "/author" )
public class AuthorRestController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping
	public GetAuthorsResponse getAllAuthors() {
		
		GetAuthorsResponse getAuthorsResponse = new GetAuthorsResponse();
		List<Author> authorList = authorService.getAllAuthors();
		getAuthorsResponse.setAuthorList( AuthorMapper.map( authorList ) );
		return getAuthorsResponse;
	}
}
