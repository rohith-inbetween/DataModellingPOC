package com.compiletest;

import java.io.File;
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
		File classesDir = new File("D:/TestSpring/TestCompile/classes");

		// The parent classloader 
		ClassLoader parentLoader = ClassLoader.getSystemClassLoader();

		URLClassLoader loader1 = new URLClassLoader( new URL[] { classesDir.toURI().toURL() }, parentLoader);
		Class cls1 = Class.forName("com.compiletest.CompileIt");
//		Class cls1 = loader1.loadClass("CompileIt");
		Object obj = cls1.newInstance();
		obj.getClass().getMethod("sayHello").invoke(obj);
//		obj.sayHello();
	
	}
}
