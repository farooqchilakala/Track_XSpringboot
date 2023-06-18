package com.crm_next_gen_app.models;

import java.sql.ResultSet;

public interface ClassDAO {
	public void establishConnection();
	public boolean login(String username, String password);
	public void createLead(String firstName, String lastName, String emailId, String city, String mobile);
	public ResultSet searchLeads();
	public void deleteLead(String emailid);
	public void updateLeads(String emailid, String mobileNumber);
	public void destroyConnection();
}
