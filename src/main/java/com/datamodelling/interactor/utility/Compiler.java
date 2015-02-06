package com.datamodelling.interactor.utility;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.tools.javac.Main;

@Component
public class Compiler {

	@Autowired
	String compiledGeneratedCodeFilePath;
	
	public boolean compileCode(String fileName){
		int errorCode = Main.compile(new String[] {
				"-d",compiledGeneratedCodeFilePath,
				fileName});
		if(errorCode == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public void addPath() throws Exception {
	    File f = new File(compiledGeneratedCodeFilePath);
	    URL u = f.toURI().toURL();
	    URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
	    Class urlClass = URLClassLoader.class;
	    Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
	    method.setAccessible(true);
	    method.invoke(urlClassLoader, new Object[]{u});
	}
	
}
