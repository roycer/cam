package com.roycer.cam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.ProcessEngines;
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
		//CamundaEngineLib a = new CamundaEngineLib();
		//String as = a.processCreate("cam", "", "", "",variables);
		ProcessEngine processEngine =  ProcessEngines.getDefaultProcessEngine();
		
//		processEngine.getAuthorizationService()
		ProcessEngineConfiguration processengineconfiguration = processEngine.getProcessEngineConfiguration();
		System.out.println("mailServerHost: "+processengineconfiguration.getMailServerHost());
		System.out.println("username: "+processengineconfiguration.getJdbcUsername());
		System.out.println("password: "+processengineconfiguration.getJdbcPassword());
				
		//processengineconfiguration.buildProcessEngine();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
