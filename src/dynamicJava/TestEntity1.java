package com.datamodelling.interactor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestEntity1 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId () {
		return this.id;
	}
	
	public void setId (Long id){
		this.id = id;
	}
	
	private String label;

	public String getLabel () {
		return this.label;
	}
	
	public void setLabel (String label){
		this.label = label;
	}
	
	private String name;

	public String getName () {
		return this.name;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	private Long type;

	public Long getType () {
		return this.type;
	}
	
	public void setType (Long type){
		this.type = type;
	}
}