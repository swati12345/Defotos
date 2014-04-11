package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class EmailCheck extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String execute() throws Exception {
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		PreparedStatement pst = con.prepareStatement("select  reg_email from REGISTRATION where reg_email='" + data + "'");
		System.out.println("Calling");
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			/*addActionError("Already exist email id");*/
			return ERROR;
		}
		/*return INPUT;*/
		return SUCCESS;
	}

}
