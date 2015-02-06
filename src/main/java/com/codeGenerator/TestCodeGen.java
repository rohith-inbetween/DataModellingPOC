package com.codeGenerator;

import org.junit.Test;

public class TestCodeGen {

	@Test
	public void testCodeGen(){
		CodeGenerator codeGen = new CodeGenerator();
		System.out.println(codeGen.generateCode());
	}
	
}
