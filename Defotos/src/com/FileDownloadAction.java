package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;

	private InputStream profileImage;
	private String profileImageContentType;
	private String profileImageFileName;
	Map<String, Object> sessionMap;
	private String sessionEmail;


	public InputStream getProfileImage()
	{
		return profileImage;
	}

	public void setProfileImage(InputStream profileImage)
	{
		this.profileImage = profileImage;
	}

	public String getProfileImageContentType()
	{
		return profileImageContentType;
	}

	public void setProfileImageContentType(String profileImageContentType)
	{
		this.profileImageContentType = profileImageContentType;
	}

	public String getProfileImageFileName()
	{
		return profileImageFileName;
	}

	public void setProfileImageFileName(String profileImageFileName)
	{
		this.profileImageFileName = profileImageFileName;
	}

	public String execute() throws Exception
	{		sessionEmail = (String) sessionMap.get("sessionEmail");

		try
		{
			Blob b;
			MyConnection mycon = new MyConnection();
			Connection con = mycon.getConnection();

			PreparedStatement pstm = con.prepareStatement("select *from REGISTRATION where REG_EMAIL=?");
			pstm.setString(1, sessionEmail);

			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				System.out.println("Go!");

			b = rs.getBlob(9);
			profileImage = b.getBinaryStream();
			profileImageFileName = "Image001.jpg";
			profileImageContentType = "image/jpeg";
			}
			System.out.println("fetched Successfully!");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public void setSession(Map<String, Object> map)
	{
		sessionMap=map;	
	}

}
