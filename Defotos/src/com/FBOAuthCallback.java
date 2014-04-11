package com;

import java.io.IOException;
import java.util.*;
import org.apache.struts2.ServletActionContext;
import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import com.opensymphony.xwork2.ActionSupport;

public class FBOAuthCallback extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	private static final Token EMPTY_TOKEN = null;
	
	private static OAuthService service=null;
	private String authorizationUrl = null;
	private String code;
	
	public String execute() throws Exception
	{
		Verifier verifier = new Verifier(code);
		System.out.println();
		
		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: " + accessToken + " )");
		System.out.println();
		
		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		response.isSuccessful();
		System.out.println(response.getCode());
		System.out.println(response.getBody());
		
		System.out.println();
		System.out.println("headers");
				
		
		System.out.println();
		System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
		
		return SUCCESS;
	}
	
	public String setup() throws IOException
	{
		// Replace these with your own api key and secret
		String apiKey = "832427816783456";
		String apiSecret = "0d7b80d00aa699fd63cf758ef1cd2e1f";
		String callback = "http://localhost:8085/Defotos/fboauthcallback";
		service = new ServiceBuilder().provider(FacebookApi.class).apiKey(apiKey).apiSecret(apiSecret).callback(callback).build();
		Scanner in = new Scanner(System.in);
		
		System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
		System.out.println();
		
		// Obtain the Authorization URL
		System.out.println("Fetching the Authorization URL...");
		authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
		System.out.println("Got the Authorization URL!");
		System.out.println("Now go and authorize Scribe here:");
		System.out.println(authorizationUrl);
		System.out.println("And paste the authorization code here");
		System.out.print(">>");
		ServletActionContext.getResponse().sendRedirect(authorizationUrl);
		return SUCCESS;
	}

	public String getAuthorizationUrl()
	{
		return authorizationUrl;
	}

	public void setAuthorizationUrl(String authorizationUrl)
	{
		this.authorizationUrl = authorizationUrl;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
	
}