package com.roycer.cam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.h2.util.New;

import com.sig.camunda.bpm_lib.*;

import camundafeel.de.odysseus.el.tree.impl.Scanner;;

/**
 * Servlet implementation class Cargar
 */
@WebServlet("/Cargar")
public class Cargar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public Cargar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("var","2");
		CamundaEngine a = new CamundaEngine();
		
		String as = a.processCreate("cam", "", "", "",variables);
		ProcessEngine processEngine =  ProcessEngines.getDefaultProcessEngine();
		
		 ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey("cam").latestVersion().singleResult();
		//ProcessDefinition pd = processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionId("cam:1:ca17c2cb-77ff-11e7-a4ea-0c84dcaa2fad").singleResult();
		if(pd != null){
			System.out.println(pd.getId());
			System.out.println(pd.getDescription());
		}
		//processEngine.getRuntimeService().startProcessInstanceById("cam:1:ca17c2cb-77ff-11e7-a4ea-0c84dcaa2fad",variables);
		Authentication auth = processEngine.getIdentityService().getCurrentAuthentication();
		if(auth!=null){
			System.out.println(auth.getUserId());
		}
		else{
			System.out.println("auth = null");
		}
		//
//		processEngine.getAuthorizationService()
//		ProcessEngineConfiguration processengineconfiguration = processEngine.getProcessEngineConfiguration();
//		System.out.println("mailServerHost: "+processengineconfiguration.getMailServerHost());
//		System.out.println("username: "+processengineconfiguration.getJdbcUsername());
//		System.out.println("password: "+processengineconfiguration.getJdbcPassword());
				
		//processengineconfiguration.buildProcessEngine();
		System.out.println("-------------");
		List<ProcessInstance> aasas = processEngine.getRuntimeService().createProcessInstanceQuery().processDefinitionKey("cam").list();
		for(ProcessInstance i : aasas){
			System.out.println(i.getId() +" - " + i.getProcessDefinitionId() + " - " + i.getProcessInstanceId()+ " - "+ i.getBusinessKey());
			System.out.println();
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
