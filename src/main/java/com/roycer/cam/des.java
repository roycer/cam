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
		//String idTask = request.getParameter("idTask");
		
		ProcessEngine processEngine =  ProcessEngines.getDefaultProcessEngine();
		//ProcessDefinition processDefinition = processEngine.getRepositoryService().getProcessDefinition(idp);
		//System.out.println(processDefinition.getDescription());
		//CamundaEngine camEngine = new CamundaEngine();
		//camEngine.taskComplete(idTask, "naruto", "na");
		//camEngine.instanceSetVariable(idTask, "ok","ok");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<ProcessDefinition> exs = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
		for(ProcessDefinition i : exs){
			System.out.println("key: "+i.getKey());
			System.out.println("name:"+i.getName());
			System.out.println("description: "+i.getDescription());
			System.out.println("resource name:"+i.getResourceName());
			System.out.println("-----------");
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
