package com.petersarazin.bookshelf.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.petersarazin.bookshelf.dto.AuthorDto;
import com.petersarazin.bookshelf.entity.Author;

public class AuthorMapper {

	public static List<AuthorDto> map( Collection<Author> authorList ) {
		
		List<AuthorDto> authorDtoList = new ArrayList<AuthorDto>();
		
		if( authorList != null ) {
			
			for( Author author : authorList ) {
				AuthorDto authorDto = map( author );
				authorDtoList.add( authorDto );
			}
		}

		return authorDtoList;
	}

	public static AuthorDto map( Author author ) {
		
		AuthorDto authorDto = null;
		
		if( author != null ) {
			
			authorDto = new AuthorDto();
			authorDto.setAuthorId( author.getAuthorId() );
			authorDto.setFirstName( author.getFirstName() );
			authorDto.setMiddleName( author.getMiddleName() );
			authorDto.setLastName( author.getLastName() );
		}
		
		return authorDto;
	}
}
