package com.codeGenerator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeGenerator.EntityClass;
import com.codeGenerator.Property;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class CodeGeneratorUtils {
	
	public String generateCodeForEntity(EntityClass entityClass){
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache;
	    
        mustache = mf.compile("src/templates/testTemplate.template");
        StringWriter sw=new StringWriter();
        Map<String, Object> scope=new HashMap<String, Object>();
        
        /*List<Property> smallList = new ArrayList<Property>();
        
        smallList.add(new Property("long", "id"));
        smallList.add(new Property("int", "id2"));
        smallList.add(new Property("String", "name"));*/
        
        scope.put("entityClass", entityClass);
        
        /*scope.put("EntityName", "Product1");
        scope.put("condition", smallList);*/
        
        FileWriter fw = null;
        try {
			fw = new FileWriter("src/templates/product1.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        mustache.execute(fw, scope);
        try {
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fw.toString();
        
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
