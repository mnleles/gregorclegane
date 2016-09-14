package br.com.ura.gregor.clegane.model;

import org.springframework.data.annotation.Id;

public class AbstractModel
{
	@Id
	public String id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "AbstractModel [getId()=" + getId() + ", toString()=" + super.toString() + "]";
	}
}