package com.petersarazin.bookshelf.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petersarazin.bookshelf.dto.response.GetPublishersResponse;
import com.petersarazin.bookshelf.entity.Publisher;
import com.petersarazin.bookshelf.mapper.PublisherMapper;
import com.petersarazin.bookshelf.service.PublisherService;

@RestController
@RequestMapping( "/publisher")
public class PublisherRestController {
	
	@Autowired
	PublisherService publisherService;
	
	@GetMapping
	public GetPublishersResponse getAllPublishers() {
		
		GetPublishersResponse getPublishersResponse = new GetPublishersResponse();
		List<Publisher> publisherList = publisherService.getAllPublishers();
		getPublishersResponse.setPublisherList( PublisherMapper.map( publisherList ) );
		return getPublishersResponse;
	}
}
