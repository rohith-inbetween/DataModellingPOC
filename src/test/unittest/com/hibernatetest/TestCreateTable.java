package com.hibernatetest;

import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.compiletest.TestDemo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
//@Transactional
//@TransactionConfiguration(defaultRollback = false)
public class TestCreateTable {

	@Test
	public void test() throws Exception{
		
		Configuration config = new Configuration();
		Properties props = new Properties();
		  props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		  props.put(Environment.URL,"jdbc:mysql://localhost:3306/datamodelling");
		  props.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		  props.put(Environment.USER,"root");
		  props.put(Environment.PASS,"");
		  TestDemo.compile("src/dynamicJava/TableToBeAdded.java");
		  TestDemo.addPath("src/createdClasses");
		  Class tableToAdd = Class.forName("com.hibernatetest.entity.TableToBeAdded");
		  config.addAnnotatedClass(tableToAdd);
		  config.addProperties(props);
		  SchemaUpdate update=new SchemaUpdate(config);
		  update.execute(true, true);
	}
	
}
