package com.web.model;

public class FitbitTokens
{
	private String scope;

	private String user_id;

	private String token_type;

	private String expires_in;

	private String refresh_token;

	private String access_token;

	public String getScope ()
	{
		return scope;
	}

	public void setScope (String scope)
	{
		this.scope = scope;
	}

	public String getUser_id ()
	{
		return user_id;
	}

	public void setUser_id (String user_id)
	{
		this.user_id = user_id;
	}

	public String getToken_type ()
	{
		return token_type;
	}

	public void setToken_type (String token_type)
	{
		this.token_type = token_type;
	}

	public String getExpires_in ()
	{
		return expires_in;
	}

	public void setExpires_in (String expires_in)
	{
		this.expires_in = expires_in;
	}

	public String getRefresh_token ()
	{
		return refresh_token;
	}

	public void setRefresh_token (String refresh_token)
	{
		this.refresh_token = refresh_token;
	}

	public String getAccess_token ()
	{
		return access_token;
	}

	public void setAccess_token (String access_token)
	{
		this.access_token = access_token;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [scope = "+scope+", user_id = "+user_id+", token_type = "+token_type+", expires_in = "+expires_in+", refresh_token = "+refresh_token+", access_token = "+access_token+"]";
	}
}

