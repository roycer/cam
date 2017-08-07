package com.roycer.cam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.task.Task;

import com.sig.camunda.bpm_dto.MyTask;

/**
 * Servlet implementation class completarTarea
 */
@WebServlet("/completarTarea")
public class completarTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completarTarea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String instance = request.getParameter("instance");
		
		ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
		
		List<Task> tasks = pe.getTaskService().createTaskQuery().processInstanceId(instance).taskAssignee(user).list();
		
		for(Task i:tasks){
			System.out.println(i.getName() + " - " + i.getProcessInstanceId() );
			//System.out.println();
		}
		
			System.out.println("--- sin instancia");
			tasks = pe.getTaskService().createTaskQuery().taskAssignee(user).list();
			for(Task i:tasks){
				System.out.println(i.getName() + " - " + i.getProcessInstanceId() );
				//System.out.println();
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
