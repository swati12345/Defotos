package com;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
public class LoginBean extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String dbStatus;
	private String dbEmail;
	private String dbPassword;
	private String name;
	private String lname;
	Blob key;
    Blob userimage;
	SessionMap<String, Object> sessionMap;
	LinkedHashMap<String, String> userData = new LinkedHashMap <String, String>();
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws SQLException {

		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();

		
		PreparedStatement pstm = con
				.prepareStatement("select *from REGISTRATION where REG_EMAIL=?");
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) 
		{
			name=rs.getString(1);
			lname=rs.getString(2);
			dbPassword = rs.getString(4);
			dbStatus = rs.getString(7);
			key = rs.getBlob(8);
            userimage=rs.getBlob(9);
			EncryptionDecryption ed = new EncryptionDecryption(dbPassword, key);
			String dppass = ed.getDecryptedData();
			System.out.println("-----------------Fisrtname-------------");
			System.out.println();
			System.out.println();
			System.out.println();
            System.out.println("First name:"+name);
			System.out.println();
			System.out.println();
			System.out.println("-----------------Lastname-------------");
            System.out.println("First name:"+ lname);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
            System.out.println("First name:"+username);

			System.out.println("pass: " + dppass ); 
			System.out.println(" password:------ " + password );
			System.out.println("dbStatus:-------- " + dbStatus);
			System.out.println();
			System.out.println();
			if (password.equals(dppass) && dbStatus.equalsIgnoreCase("enabled")) 
			{
				userData.put("firstName", rs.getString(1));
				userData.put("lastName", rs.getString(2));
				userData.put("email", rs.getString(3));
                sessionMap.put("userData", userData);
				sessionMap.put("sessionStatus", true);
                sessionMap.put("sessionEmail", username);
				return SUCCESS;
			} 
			
			else 
			{
				return ERROR;
			}
		} else {
			return INPUT;
		}

	}

	public void validate()

	{
		if (username == null || username.length() < 1) {
			addFieldError("username", "Please enter Valid name");
		}

		if (!username
				.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")
				|| username.equals("")) {
			addFieldError("email", "Please enter a valid email");
			System.out.println("email:- " + username);
		}
		if (password == null || password.length() < 1) {
			addFieldError("pass", "Please enter your Password");
			System.out.println("pass:- " + password);
		}
	}

}
