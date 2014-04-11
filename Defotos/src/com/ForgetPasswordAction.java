package com;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport{
	private String forgetpass;
	private String password;
	private String dbPassword;
	Blob key;
	
	 //Object creation of class which is responsible for email
		Emailer1 mail=new Emailer1();
		
	public String getForgetpass() {
		return forgetpass;
	}

	public void setForgetpass(String forgetpass) {
		this.forgetpass = forgetpass;
	}
	
	@Override
	public String execute() throws Exception {
		
		MyConnection mycon=new MyConnection();
		Connection con=mycon.getConnection();
		
		PreparedStatement pstm= con.prepareStatement("select *from  REGISTRATION where reg_email=?");
		pstm.setString(1, forgetpass);
		ResultSet rs=pstm.executeQuery();
		if(rs.next()){
			
		System.out.println("email id"+rs.getString(3));
		password = rs.getString(4);
		System.out.println(password);
        key=rs.getBlob(8);
		System.out.println(key);

		}

		EncryptionDecryption ed = new EncryptionDecryption(password, key);	    
		dbPassword=ed.getDecryptedData();
		System.out.println("pass: "+dbPassword);

		 pstm.executeUpdate();
		 con.close();  
		
		 String check=mail.mailExecute(forgetpass,dbPassword);
		 if(check.equalsIgnoreCase("success"))
		 {System.out.println("Your password is send");
			 
		 }
		return SUCCESS;
	
	}

	public void validate() {
		if(forgetpass==null&& forgetpass.length()<1)
		{
			
			addActionError("Username is not valid");		
		
	}
	
}
}
