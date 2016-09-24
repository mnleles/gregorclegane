package br.com.ura.gregor.clegane.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account extends AbstractModel
{
	private String user;
	private String password;
	private List<Role> roles;

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}

	@Override
	public String toString()
	{
		return "Account [getUser()=" + getUser() + ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles()
				+ ", toString()=" + super.toString() + "]";
	}
}