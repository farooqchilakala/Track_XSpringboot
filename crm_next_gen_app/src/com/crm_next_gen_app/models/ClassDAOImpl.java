package com.crm_next_gen_app.models;

import java.sql.*;

public class ClassDAOImpl implements ClassDAO {
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void establishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_next_gen", "root", "test");
			stmnt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String username, String password) {
		try {
			ResultSet results = stmnt.executeQuery("select * from login where emailid='"+username+"' and password='"+password+"'");
			return results.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void createLead(String firstName, String lastName, String emailId, String city, String mobile) {
		try {
			stmnt.executeUpdate("insert into leads values('"+firstName+"', '"+lastName+"','"+emailId+"','"+city+"', '"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet searchLeads() {
		try {
			ResultSet results = stmnt.executeQuery("Select * from leads");
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void destroyConnection() {
		
	}

	@Override
	public void deleteLead(String emailid) {
		
		try {
			stmnt.executeUpdate("Delete from leads where emailid='"+emailid+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateLeads(String emailid, String mobileNumber) {
		try {
			stmnt.executeUpdate("update leads set mobile='"+mobileNumber+"' where emailid='"+emailid+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
