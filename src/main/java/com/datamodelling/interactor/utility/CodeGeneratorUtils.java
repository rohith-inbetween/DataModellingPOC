package com.datamodelling.interactor.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datamodelling.interactor.model.EntityClass;
import com.datamodelling.interactor.model.Property;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Component
public class CodeGeneratorUtils {
	
	@Autowired
	String defaultEntityTemplatePath;
	
	@Autowired
	String defaultRepositoryTemplatePath;
	
	public void generateCodeForEntity(EntityClass entityClass) throws IOException{
		
		MustacheFactory mustacheFactory = new DefaultMustacheFactory();
	    Mustache mustache;
	    
        mustache = mustacheFactory.compile(defaultEntityTemplatePath);
        Map<String, Object> scope = new HashMap<String, Object>();
        scope.put("entityClass", entityClass);
        FileWriter fileWriter;
		fileWriter = new FileWriter("src/dynamicJava/"+ entityClass.getClassName() +".java");
        mustache.execute(fileWriter, scope);
		fileWriter.flush();
		fileWriter.close();
	}
	
	public void generateCodeForRepository(EntityClass entityClass) throws IOException{
		
		MustacheFactory mustacheFactory = new DefaultMustacheFactory();
		Mustache mustache;
		
		mustache = mustacheFactory.compile(defaultRepositoryTemplatePath);
		Map<String, Object> scope = new HashMap<String, Object>();
		scope.put("entityClass", entityClass);
		
		for (Property property : entityClass.getProperties()) {
			if(property.getIsPropertyID()){
				scope.put("dataTypeOfEntityID", property.getPropertyType());
				break;
			}
		}
		
		FileWriter fileWriter = null;
		fileWriter = new FileWriter("src/dynamicJava/I" + entityClass.getClassName() + "Repository.java");
		
		mustache.execute(fileWriter, scope);
		
		fileWriter.flush();
		fileWriter.close();		
	}
	
	/*private String renderMustacheContent() throws IOException {
	    MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache;

	    if (type.getTemplate().trim().isEmpty()) {            
	        String emailContent = genCpuEmailContent(cmsKey);
	        //mustache = mf.compile(new StringReader(emailContent), "cpu.template.email");
	        InputStream stream = new FileInputStream(new File("src/templates/testTemplate.template"));
	        Reader reader = new InputStreamReader(stream);
	        mustache = mf.compile(reader, "testTemplate.template");
	    } else {
	        mustache = mf.compile(type.getTemplate());
	    }

	    StringWriter writer = new StringWriter();
	    mustache.execute(writer, values).flush();

	    return writer.toString();
	}*/
	
}
