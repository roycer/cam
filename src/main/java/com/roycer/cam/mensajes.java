package com.roycer.cam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.EventSubscription;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

/**
 * Servlet implementation class mensajes
 */
@WebServlet("/mensajes")
public class mensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mensajes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String processinstanceid = request.getParameter("idProcessInstance");
		response.getWriter().append("processinstanceid: ").append(processinstanceid);
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		List <EventSubscription> eventSubscriptions = runtimeService.createEventSubscriptionQuery()
				  .processInstanceId(processinstanceid).eventType("message").list();
		
		for(EventSubscription eventSubscription : eventSubscriptions){
			System.out.println(eventSubscription.getEventName());
			System.out.println(eventSubscription.getId());
			runtimeService.messageEventReceived(eventSubscription.getEventName(), eventSubscription.getExecutionId());
		}
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
