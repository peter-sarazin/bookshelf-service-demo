package com.petersarazin.bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petersarazin.bookshelf.entity.Publisher;
import com.petersarazin.bookshelf.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepository;
	
	@Override
	public List<Publisher> getAllPublishers() {
		
		return publisherRepository.findAll( Publisher.class );
	}
}
