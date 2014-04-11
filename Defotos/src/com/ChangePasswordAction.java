package com;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements SessionAware
{
	private String oldPass;
	private String dbPass;
	private String newPass;
	private String dbkey;
	private String confirmPass;
	private String sessionEmail;
	private String decPassword;
	Blob key;
	
	Map<String, Object> sessionMap;

	public String getOldPass()
	{
		return oldPass;
	}

	public void setOldPass(String oldPass)
	{
		this.oldPass = oldPass;
	}

	public String getNewPass()
	{
		return newPass;
	}

	public void setNewPass(String newPass)
	{
		this.newPass = newPass;
	}

	public String getConfirmPass()
	{
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass)
	{
		this.confirmPass = confirmPass;
	}

	@Override
	public String execute() throws Exception
	{
		// To Insert Into Database
		sessionEmail = (String) sessionMap.get("sessionEmail");
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		PreparedStatement pstm = con.prepareStatement("select reg_password,ENCRYKEY from registration where reg_email=?");
		pstm.setString(1, sessionEmail);
		
		ResultSet rs = pstm.executeQuery();
		if (rs.next())
		{
			dbPass = rs.getString(1);
			key=rs.getBlob(2);
			System.out.println(dbPass);
			System.out.println(key);
			System.out.println();
			
			//to decrypt password
			EncryptionDecryption ed = new EncryptionDecryption(dbPass, key);
			decPassword =ed.getDecryptedData();

			Emailer mail=new Emailer();
			if (decPassword.equals(oldPass))
			{
				EncryptionDecryption ed1 = new EncryptionDecryption(newPass);
				PreparedStatement pstm1 = con.prepareStatement("update registration set REG_PASSWORD=?, ENCRYKEY=? where REG_EMAIL=? and REG_STATUS='Enabled' ");

				pstm1.setString(1, ed1.getEncryptedData());
				pstm1.setObject(2, ed1.getSecretKey());
				pstm1.setString(3, sessionEmail);
				pstm1.executeUpdate();
				

				 String check=mail.ChangedPassmail(sessionEmail, newPass);
				 if(check.equalsIgnoreCase("success"))
				 {
					 System.out.println("Your password is send");
				
					return SUCCESS;
				 }				
				 con.close();
			}
		}
		
		return "error";
	}

	public void setSession(Map<String, Object> map)
	{
		sessionMap=map;	
	}
}
