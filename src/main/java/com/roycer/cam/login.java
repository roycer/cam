package com.roycer.cam;

import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.AuthorizationService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.authorization.Authorization;
import org.camunda.bpm.engine.authorization.Permissions;
import org.camunda.bpm.engine.authorization.Resources;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.impl.identity.Authentication;
import static org.camunda.bpm.engine.authorization.Permissions.ACCESS;
import static org.camunda.bpm.engine.authorization.Resources.APPLICATION;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] APPS = new String[] { "cockpit", "tasklist", "admin","cam"};
		String userId = request.getParameter("user");
		String password = request.getParameter("clave");
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService ide = processEngine.getIdentityService();
		//ide.
		AuthorizationService authservice = processEngine.getAuthorizationService();
		if(ide.checkPassword(userId, password)){
			response.getWriter().append("entro");
			//ide.setAuthenticatedUserId(userId);
			
//			Authentication auth = ide.getCurrentAuthentication();
//			
//			if(auth!=null) 
//				System.out.println(auth.getUserId());
			
			 processEngine.getIdentityService().clearAuthentication();

			List<Authorization> authlist = authservice.createAuthorizationQuery().authorizationId(userId).list();
			System.out.println(authlist.size());
			//List<String> groupIds = new ArrayList<>();
			
		    List<Group> groups = processEngine.getIdentityService().createGroupQuery().groupMember(userId).list();
    	    List<String> groupIds = new ArrayList<String>();
    	    for (Group group : groups) {
    	    	System.out.println(group.getId());
    	    	groupIds.add(group.getId());
		    }
    	    if(processEngine.getProcessEngineConfiguration().isAuthorizationEnabled())
    	    	System.out.println("habilitado");
    	    
    	    String sauth = "";
			for(String application: APPS ){
				if(authservice.isUserAuthorized(userId, groupIds, Permissions.ALL, Resources.PROCESS_DEFINITION,application))
					sauth = "autorizado";
				else
					sauth = "no autorizado";
				System.out.println(application + " - " + sauth);
			}
			
			
		}
		else{
			response.getWriter().append("no entro");
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
