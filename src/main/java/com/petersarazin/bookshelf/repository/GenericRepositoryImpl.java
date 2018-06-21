package com.petersarazin.bookshelf.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepositoryImpl<T extends Serializable> implements GenericRepository<T> {

	@PersistenceContext
	protected EntityManager em;
	
	
	public void persist( T entity )	{ 
		
		if( entity == null ) {
			
			throw new IllegalArgumentException( "entity must not be null." );
		}
		
		em.persist( entity );
	}

	
	public void merge( T entity ) { 
		
		if( entity == null ) {
			
			throw new IllegalArgumentException( "entity must not be null." );
		}
		
		em.merge( entity );
	}

	
    public void remove( T entity ) {
		
    	if( entity == null ) 	{
			
    		throw new IllegalArgumentException( "entity must not be null." );
		}
		
        em.remove( em.contains( entity ) ? entity : em.merge( entity ) );
    }
	
	
    public void flush() { 
		
    	em.flush();
	}

    
	public T findById( Class<T> clazz, Serializable primaryKey ) {
		
		if( primaryKey == null ) {
		
			throw new IllegalArgumentException( "primaryKey must not be null." );
		}
		
		return em.find( clazz, primaryKey );
	}
	
	
	public List<T> findAll( Class<T> clazz ) {
		
		if( clazz == null ) {
			
			throw new IllegalArgumentException( "clazz must not be null." );
		}
		
		return findAll( clazz, clazz.getSimpleName() );
	}
	
	
	public List<T> findAll( Class<T> clazz, String tableName ) {
		
		if( clazz == null )	{
			
			throw new IllegalArgumentException( "clazz must not be null." );
		}
		else if( tableName == null ) {
			
			throw new IllegalArgumentException( "tableName must not be null." );
		}

		return em.createQuery( "select e from " + tableName + " e", clazz ).getResultList();
	}
}
