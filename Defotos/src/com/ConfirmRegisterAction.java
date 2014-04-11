package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmRegisterAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	String data;
	String check;
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String execute() throws Exception 
	
	{
		System.out.println("data: "+data);
		Boolean flag= false;
		MyConnection mycon=new MyConnection();
		Connection con=mycon.getConnection();
		
		PreparedStatement pstm= con.prepareStatement("select *from registration where reg_random=?");
		pstm.setString(1, data);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())
		{	System.out.println();
		System.out.println();
		System.out.println();
		check=rs.getString(3);
		System.out.println("email id"+rs.getString(3));
		System.out.println("status"+rs.getString(6));
		System.out.println();
		System.out.println();
		}
		
		con.close();  	  
			
		
		if(check != null && check.length() >0) {
			MyConnection mycon1=new MyConnection();
			Connection conn=mycon1.getConnection();
			
			PreparedStatement pstm1 = conn.prepareStatement("update registration set reg_status=? where reg_email=?");
			
			pstm1.setString(1,"Enabled");
			pstm1.setString(2,check);
			pstm1.executeUpdate();
			 con.close();  
			
			return SUCCESS;
		} else {
			return ERROR;
		}
	
}
}
