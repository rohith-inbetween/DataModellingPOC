package com.datamodelling.interactor.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datamodelling.interactor.model.EntityClass;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Component
public class CodeGeneratorUtils {
	
	@Autowired
	String defaultTemplatePath;
	
	public void generateCodeForEntity(EntityClass entityClass) throws IOException{
		
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache;
	    
        mustache = mf.compile(defaultTemplatePath);
        StringWriter sw=new StringWriter();
        Map<String, Object> scope=new HashMap<String, Object>();
        scope.put("entityClass", entityClass);
        FileWriter fw = null;
		fw = new FileWriter("src/dynamicJava/"+ entityClass.getClassName() +".java");
        mustache.execute(fw, scope);
		fw.flush();
		fw.close();
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
