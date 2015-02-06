package com.codeGenerator;

import java.util.ArrayList;
import java.util.List;

import com.codeGenerator.utils.CodeGeneratorUtils;

public class CodeGenerator {

	public String generateCode(){
		CodeGeneratorUtils utils = new CodeGeneratorUtils();
		
		EntityClass entityClass = new EntityClass();
		entityClass.setClassName("Product123");
		
		List<Property> properties = new ArrayList<Property>();
        
        properties.add(new Property("long", "id", true));
        properties.add(new Property("int", "id2", false));
        properties.add(new Property("String", "name", false));
		
        entityClass.setProperties(properties);
        
		return utils.generateCodeForEntity(entityClass);
	}
}
