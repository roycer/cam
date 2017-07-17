package com.roycer.cam;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.model.bpmn.instance.UserTask;

public class myTaskListener implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {

	    UserTask userTask = delegateTask.getBpmnModelElementInstance();
	    String eventName = delegateTask.getEventName();
	    
	    System.out.println("["+eventName+"] -> "+userTask.getName());
	    System.out.println("\t id_Task: "+delegateTask.getId());
	    
	    switch (eventName) {
			case "create":
				System.out.println("\t assignment: "+delegateTask.getAssignee());
				System.out.println("\t priority: "+delegateTask.getPriority());
				try {
			    	System.out.println("\t var: "+delegateTask.getVariable("var"));
			 	    System.out.println("\t varLocal: "+delegateTask.getVariableLocal("var"));
				} catch (Exception e) {
					System.out.println("\t var: error");
				}
				break;
			case "assignment": 
				System.out.println("\t assignment: "+delegateTask.getAssignee());
				break;
			case "complete": break;
			case "delete": break;
			default: break;
		}
	}

}
