package com.crm_next_gen_app.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm_next_gen_app.models.ClassDAOImpl;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private ClassDAOImpl dao = new ClassDAOImpl();
    
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		  String emailid = request.getParameter("emailid");
	      String mobile = request.getParameter("mobile");
	      request.setAttribute("emailid",emailid);
	      request.setAttribute("mobile",mobile);
	      rd = request.getRequestDispatcher("WEB-INF/jsps/updateLeads.jsp");
	      rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {	
		  String emailid = request.getParameter("emailid");
		  String mobileNumber = request.getParameter("mobile");
		
		  dao.establishConnection();
		  dao.updateLeads(emailid, mobileNumber);
		  ResultSet results = dao.searchLeads();
		  request.setAttribute("results", results);
		  rd = request.getRequestDispatcher("WEB-INF/jsps/searchLeads.jsp");
	      rd.forward(request, response);
	
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
}
