package com.roycer.cam;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class myFieldInjected implements JavaDelegate {
	
	 Expression text;
	private Expression text1;
	private Expression text2;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		String value1 = (String) text1.getValue(execution);
	      execution.setVariable("var1", new StringBuffer(value1).reverse().toString());

	      String value2 = (String) text2.getValue(execution);
	      execution.setVariable("var2", new StringBuffer(value2).reverse().toString());
		
		 String value = (String) text.getValue(execution);
		    value = value.toUpperCase();
		    execution.setVariable("upperedText", value);
		    execution.setVariable("upperedText2", value);
		
	}

}
