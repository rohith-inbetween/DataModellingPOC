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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
//@Transactional
//@TransactionConfiguration(defaultRollback = false)
public class TestCreateTable {

	@Test
	public void test() throws SQLException{
		
		Configuration config = new Configuration();
		Properties props = new Properties();
		  props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLInnoDBDialect");
		  props.put(Environment.URL,"jdbc:mysql://localhost:3306/datamodelling");
		  props.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		  props.put(Environment.USER,"root");
		  props.put(Environment.PASS,"");
		
		props.put("hibernate.hbm2ddl.auto", "create");
//		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
//		props.put("hibernate.connection.provider_class",
//		 "com.zutubi.pulse.upgrade.tasks.UpgradeTaskConnectionProvider");
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/datamodelling");
//		config.setProperty("hibernate.connection.username", "root");
//	    config.setProperty("hibernate.connection.password", "");
//	    config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		
		  config.addAnnotatedClass(TableToBeAdded.class);
//		}
config.addProperties(props);
		// run the schema update.
	SchemaUpdate update=new SchemaUpdate(config);
//	update.setDelimiter(";");
//	  update.setHaltOnError(true);
//	  update.setOutputFile("src/main/resources/update.sql");
//	  update.setFormat(true);
	  update.execute(true, true);
//		  Dialect dialect = Dialect.getDialect(props);
//		  Connection connection = dataSource.getConnection();
//		  DatabaseMetadata meta = 
//		      new DatabaseMetadata(connection, dialect);
//		  String[] createSQL = 
//		      config.generateSchemaUpdateScript(dialect, meta);
//		  System.out.println(createSQL[0]);
//		  connection.close();
		  
		
	}
	
}
