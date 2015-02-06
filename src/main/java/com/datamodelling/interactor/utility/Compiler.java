package com.datamodelling.interactor.utility;

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
	
}
