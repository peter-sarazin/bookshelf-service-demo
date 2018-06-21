package com.petersarazin.bookshelf.mapper;

import java.util.ArrayList;
import java.util.List;

import com.petersarazin.bookshelf.dto.PublisherDto;
import com.petersarazin.bookshelf.entity.Publisher;

public class PublisherMapper {
	
	public static List<PublisherDto> map( List<Publisher> publisherList ) {
		
		List<PublisherDto> publisherDtoList = new ArrayList<PublisherDto>();
		
		if( publisherList != null ) {
			
			for( Publisher publisher : publisherList ) {
				PublisherDto publisherDto = map( publisher );
				publisherDtoList.add( publisherDto );
			}
		}

		return publisherDtoList;
	}
	
	public static PublisherDto map( Publisher publisher ) {
		
		PublisherDto publisherDto = null;
		
		if( publisher != null ) {
		
			publisherDto = new PublisherDto();
			publisherDto.setPublisherId( publisher.getPublisherId() );
			publisherDto.setName( publisher.getName() );
			publisherDto.setUrl( publisher.getUrl() );
		}
		
		return publisherDto;
	}
	
	
	public static Publisher map( PublisherDto publisherDto ) {
		
		Publisher publisher = null;
		
		if( publisherDto != null ) {
		
			publisher = new Publisher();
			publisher.setPublisherId( publisherDto.getPublisherId() );
			publisher.setName( publisherDto.getName() );
			publisher.setUrl( publisherDto.getUrl() );
		}
		
		return publisher;
	}

}
