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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassDAOImpl  dao= new ClassDAOImpl();
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String emailId = request.getParameter("emailid");
			String password = request.getParameter("password");
			
			dao.establishConnection();
			boolean booleanVal = dao.login(emailId, password);
			HttpSession session = request.getSession(true);
			if(booleanVal==true) {
				session.setAttribute("emailid", emailId);
				RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/jsps/createLead.jsp");
				rd1.forward(request, response);
			}else {
				request.setAttribute("msg_error", "invalid username / password");
				RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
				rd1.include(request, response);
			}
			
	}

}
