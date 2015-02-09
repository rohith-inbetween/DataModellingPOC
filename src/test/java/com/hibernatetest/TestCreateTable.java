package com.hibernatetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datamodelling.interactor.model.EntityClass;
import com.datamodelling.interactor.model.Property;
import com.datamodelling.interactor.utility.CodeGeneratorUtils;
import com.datamodelling.interactor.utility.Compiler;
import com.datamodelling.interactor.utility.CreateTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
//@Transactional
//@TransactionConfiguration(defaultRollback = false)
public class TestCreateTable {

	@Autowired
	CodeGeneratorUtils codeGenerator;
	
	@Autowired
	Compiler compiler;
	
	@Autowired
	CreateTable tableCreator;
	
	
	@Test
	public void integrationTest() throws Exception{
		EntityClass entityClass = new EntityClass();
		entityClass.setClassName("TestEntity1");
		List<Property> properties = new ArrayList<Property>();
        properties.add(new Property("Long", "id", true));
        properties.add(new Property("String", "label", false));
        properties.add(new Property("String", "name", false));
        properties.add(new Property("Long", "type", false));
        entityClass.setProperties(properties);
        
		codeGenerator.generateCodeForEntity(entityClass);
		compiler.compileCode("src/dynamicJava/" + entityClass.getClassName() + ".java");
        compiler.addPath();
        codeGenerator.generateCodeForRepository(entityClass);
        compiler.compileCode("src/dynamicJava/I" + entityClass.getClassName() + "Repository.java");
		compiler.addPath();

		tableCreator.create(entityClass.getClassName());
		
	}
	
}
