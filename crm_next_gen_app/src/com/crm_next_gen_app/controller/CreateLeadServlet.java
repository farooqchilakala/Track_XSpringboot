package com.crm_next_gen_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm_next_gen_app.models.ClassDAOImpl;

import java.sql.*;

@WebServlet("/createLeadServlet")
public class CreateLeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassDAOImpl dao = new ClassDAOImpl();
	
    public CreateLeadServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailId = request.getParameter("emailid");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		
		dao.establishConnection();
		dao.createLead(firstName, lastName, emailId, city, mobile);
		
		request.setAttribute("msg_leads", "Lead is saved");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
