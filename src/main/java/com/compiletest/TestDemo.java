package com.compiletest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import com.sun.tools.javac.Main;

public class TestDemo {
	
	public static void main(String args[])throws Exception{
		if(compile("src/dynamicJava/CompileIt.java")){
			loadClass();
		}
		
	}
	
	public static boolean compile(String fileName) throws Exception{
		int errorCode = Main.compile(new String[] {
				"-d","src/createdClasses/",
				fileName});
		if(errorCode == 0){
			System.out.println("Compiled Succesfully");
			return true;
		} else {
			return false;
		}
	}
	
	public static void loadClass()throws Exception{
		addPath("src/createdClasses/");
		Class cls1 = Class.forName("com.compiletest.CompileIt");
		Object obj = cls1.newInstance();
		obj.getClass().getMethod("sayHello").invoke(obj);
	}
	
	public static void addPath(String s) throws Exception {
	    File f = new File(s);
	    URL u = f.toURI().toURL();
	    URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
	    Class urlClass = URLClassLoader.class;
	    Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
	    method.setAccessible(true);
	    method.invoke(urlClassLoader, new Object[]{u});
	}
}
