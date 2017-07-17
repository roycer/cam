package com.roycer.cam;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class myExecutionListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution delegateExecution) throws Exception {
		
		System.out.println("["+delegateExecution.getEventName()+"] -> "+delegateExecution.getId());
	}

}
