package com;

import java.nio.channels.SeekableByteChannel;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class Signout extends ActionSupport implements SessionAware{
	SessionMap<String ,Object> sessionMap;

	public void setSession(Map<String, Object> map) 
	{
		sessionMap=(SessionMap<String, Object>)map;
	}

	
	public String execute() throws Exception {
		sessionMap.invalidate();
		return SUCCESS;
	}

}
