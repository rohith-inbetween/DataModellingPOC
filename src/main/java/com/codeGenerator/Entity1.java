package com.codeGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Entity1 {

	@Id
	private Long id;
	
	private int id2;
	
	private String name;

	public Long getId () {
		return this.id;
	}
	
	public void setId (Long id){
		this.id = id;
	}
}