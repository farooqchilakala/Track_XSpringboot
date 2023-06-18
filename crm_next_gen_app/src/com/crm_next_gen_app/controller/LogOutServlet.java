package com.crm_next_gen_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
			session.invalidate();
			RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
			rd1.forward(request, response);
		}else {
			RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
			rd2.forward(request, response);
		}
	}

}
