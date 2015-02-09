package com.datamodelling.interactor.utility;

import java.io.File;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.stereotype.Component;

@Component
public class CreateTable {

	public void create(String entityName){
		
		Configuration config = new Configuration();
		Properties props = new Properties();
		  props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		  props.put(Environment.URL,"jdbc:mysql://localhost:3306/datamodelling");
		  props.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		  props.put(Environment.USER,"root");
		  props.put(Environment.PASS,"");
		  Class tableToAdd;
		try {
			final File f = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            System.out.println("Path : "+f.getAbsolutePath());
            
            tableToAdd = Class.forName("com.datamodelling.interactor.entity." + entityName);
			config.addAnnotatedClass(tableToAdd);
			config.addProperties(props);
			SchemaUpdate update=new SchemaUpdate(config);
			update.execute(true, true);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found!" + e);
		}
		
	}
	
}
