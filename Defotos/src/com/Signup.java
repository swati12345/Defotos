package com;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;
import javax.sql.ConnectionEvent;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Signup extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String fname;
	private String lname;
	private String email;
	private String pass;
	private String cpass;
	private String contact;
	private File profileImage;
	private String profileImageContentType;
	private String profileImageFileName;

	public File getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
	}

	public String getProfileImageContentType() {
		return profileImageContentType;
	}

	public void setProfileImageContentType(String profileImageContentType) {
		this.profileImageContentType = profileImageContentType;
	}

	public String getProfileImageFileName() {
		return profileImageFileName;
	}

	public void setProfileImageFileName(String profileImageFileName) {
		this.profileImageFileName = profileImageFileName;
	}

	private String status = "disable";

	// Object creation of class which is responsible for email
	Emailer mail = new Emailer();

	// To Find system date and time
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	java.util.Date date = new java.util.Date();
	java.sql.Date regDate = new java.sql.Date(date.getTime());

	// Getter setter
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	// Vailidation part

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	// To create object of vailidation class
	@Override
	public void validate() {

		if (fname == null || fname.length() < 1) {
			addFieldError("fname", "Please enter first name");
			System.out.println("fname: " + fname);
		}
		if (lname == null || lname.length() < 1) {
			addFieldError("lname", "Please enter last name");
			System.out.println("lname:- " + lname);
		}
		if (!email.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")
				|| email.equals("")) {
			addFieldError("email", "Please enter a valid email address");
			}

			if (email == null || email.length() < 1) {
				addFieldError("email", "Please enter a valid email id");
				System.out.println("email:- " + email);
			}
			if (pass == null || pass.length() < 1) {
				addFieldError("pass", "Please enter password");
				System.out.println("pass:- " + pass);
			}
			if (cpass == null || cpass.length() < 1) {
      addFieldError("cpass", "Please enter confirm password");
				System.out.println("cpass:- " + cpass);
			}
			if (!pass.equals(cpass)) {
				addFieldError("cpass", "Password and confirm password mismatch");
			}
	
		
		

	}

	public String execute() throws Exception { 
		
		// Generate randome no
		EncryptionDecryption ed = new EncryptionDecryption(pass);
		int randomInt = 2210;
		Random randomGen = new Random();
		for (int idx = 1; idx <= 5; ++idx) {
			randomInt = randomGen.nextInt(32767);
		}
		String random = email + "" + randomInt;

		// To Insert Into Database
		
	

		/*MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		PreparedStatement pst= con.prepareStatement("select *from REGISTRATION where reg_email='"+ email+"'");
		
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			addFieldError("email", "Already exist email id");
		}*/
		InputStream fileInput = new FileInputStream(profileImage);
		MyConnection mycon = new MyConnection();
		Connection con = mycon.getConnection();
		PreparedStatement pstm = con.prepareStatement("insert into REGISTRATION values (?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, fname);
		pstm.setString(2, lname);
		pstm.setString(3, email);
		pstm.setString(4, ed.getEncryptedData());
		pstm.setDate(5, regDate);
		pstm.setString(6, random);
		pstm.setString(7, status);
		pstm.setObject(8, ed.getSecretKey());
		pstm.setBinaryStream(9, fileInput, (int) profileImage.length());

		pstm.executeUpdate();
		con.close();
		System.out.println("Insert successfuly");

		// Code to mail for confirmation
		String confirmMail = mail.mailExecute(email, random);
		if (confirmMail.equalsIgnoreCase("success")) {
			System.out.println();
			System.out.println();
			System.out.println("ur mail is send");
			System.out.println();
			System.out.println();
		} else {
			System.out.println();
			System.out.println();
			System.out.println("ur mail is not send");
			System.out.println();
			System.out.println();

		}
		
		return SUCCESS;
	}

}
