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
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.Execution;

import com.sig.camunda.bpm_lib.CamundaAuthentication;
import com.sig.camunda.bpm_lib.CamundaEngine;

/**
 * Servlet implementation class des
 */
@WebServlet("/des")
public class des extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public des() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String user = request.getParameter("user");
		
//		ProcessEngine processEngine =  ProcessEngines.getDefaultProcessEngine();
		//ProcessDefinition processDefinition = processEngine.getRepositoryService().getProcessDefinition(idp);
		//System.out.println(processDefinition.getDescription());
		//CamundaEngine camEngine = new CamundaEngine();
		//camEngine.taskComplete(idTask, "naruto", "na");
		//camEngine.instanceSetVariable(idTask, "ok","ok");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		CamundaAuthentication camauth = new CamundaAuthentication();
//		List<ProcessDefinition> exs = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
//		for(ProcessDefinition i : exs){
//			
//			if (camauth.isAuthorizationCreateProcessInstance(user, i.getKey())) {
//				System.out.println("[autorizado]");
//			}
//			else
//				System.out.println("[no autorizado]");
//			
//			System.out.println("key: "+i.getKey());
//			System.out.println("name:"+i.getName());
//			System.out.println("description: "+i.getDescription());
//			System.out.println("resource name:"+i.getResourceName());
//			System.out.println("-----------");
//		}
//		System.out.println("**************************");
		
//		String user = request.getParameter("user");
//		String recurso = request.getParameter("recurso");
//		
		CamundaAuthentication camaut = new CamundaAuthentication();
		//camaut.createUser("naruto12", "naruto", "uzumaki", "12", "naruto@gmail.com");
		//camaut.userAuthorizationCreate(user, recurso);
		
		List<String> usuarios = camaut.getUsers();
		for(String i : usuarios)
			System.out.println(i);
		
		CamundaEngine cam = new CamundaEngine();
		List<String> pros = cam.getProcessDefinitions();
		System.out.println("----");
		for(String i: pros){
			System.out.println(i);
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
