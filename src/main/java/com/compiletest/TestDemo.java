package com.compiletest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import com.sun.tools.javac.Main;

public class TestDemo {
	
	public static void main(String args[])throws Exception{
		/*Scanner sc = new Scanner(System.in);
		String txt = sc.next();*/
		
		
		int errorCode = Main.compile(new String[] {
				"-d","src/createdClasses/",
	            "src/dynamicJava/CompileIt.java" });
		if(errorCode == 0){
			System.out.println("Compiled Succesfully");
			loadClass();
		}
	}
	
	public static void loadClass()throws Exception{
		// The dir contains the compiled classes. 
//		File classesDir = new File("src/createdClasses/");

		// The parent classloader 
//		ClassLoader parentLoader = ClassLoader.getSystemClassLoader();
		
//		URLClassLoader loader1 = new URLClassLoader( new URL[] { classesDir.toURI().toURL() }, parentLoader);
		
		addPath("src/createdClasses/");
		Class cls1 = Class.forName("com.compiletest.CompileIt");
//		Class cls1 = loader1.loadClass("com.compiletest.CompileIt");
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
