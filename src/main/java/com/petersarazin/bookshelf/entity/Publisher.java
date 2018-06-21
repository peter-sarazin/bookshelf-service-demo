package com.petersarazin.bookshelf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher implements Serializable
{
	private static final long serialVersionUID = -2502293909262916587L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )	
	private Integer publisherId;
	
	private String name;
	
	private String url;

	public Integer getPublisherId() { return publisherId; }
	public void setPublisherId(Integer publisherId) { this.publisherId = publisherId; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
}
