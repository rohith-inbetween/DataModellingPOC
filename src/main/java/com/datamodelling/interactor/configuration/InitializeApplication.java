package com.datamodelling.interactor.configuration;

import java.io.File;
import java.io.FilenameFilter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datamodelling.interactor.utility.Compiler;

@Component
public class InitializeApplication {

	@Autowired
	Compiler compiler;
	
	@Autowired
	String generatedCodeFilePath;
	
	@PostConstruct
	public void compileGeneratedCode() {
		File generatedCodeFolder = new File(generatedCodeFilePath);
		File[] generatedCodes = generatedCodeFolder
				.listFiles(new FilenameFilter() {
					public boolean accept(File dir, String filename) {
						return filename.endsWith(".java");
					}
				});
		for (File generatedCode : generatedCodes) {
			String generatedClassName = generatedCode.getName().split(".java")[0];
			try {
				Class.forName(generatedClassName);
				System.out.println("Found : " + generatedClassName);
			} catch (ClassNotFoundException e) {
				compiler.compileCode(generatedCodeFilePath + generatedCode.getName());
				System.out.println("Compiled : " + generatedClassName);
			}
		}

	}

}
