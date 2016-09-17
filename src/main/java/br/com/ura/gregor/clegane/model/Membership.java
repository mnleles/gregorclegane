package br.com.ura.gregor.clegane.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.ura.gregor.clegane.converter.LocalDateDeserializer;
import br.com.ura.gregor.clegane.converter.LocalDateSerializer;

public class Membership extends AbstractModel
{
	private String name;
	private String occupation;
	private String email;
	private String rg;
	private String cpf;
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateBirth;
	private String address;
	private String neighborhood;
	private String city;
	private String zipCode;
	private String state;
	private String phone;
	private String cellphone;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public LocalDate getDateBirth()
	{
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth)
	{
		this.dateBirth = dateBirth;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getNeighborhood()
	{
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood)
	{
		this.neighborhood = neighborhood;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCellphone()
	{
		return cellphone;
	}

	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}

	@Override
	public String toString()
	{
		return "Membership [getName()=" + getName() + ", getOccupation()=" + getOccupation() + ", getEmail()="
				+ getEmail() + ", getRg()=" + getRg() + ", getCpf()=" + getCpf() + ", getDateBirth()=" + getDateBirth()
				+ ", getAddress()=" + getAddress() + ", getNeighborhood()=" + getNeighborhood() + ", getCity()="
				+ getCity() + ", getZipCode()=" + getZipCode() + ", getState()=" + getState() + ", getPhone()="
				+ getPhone() + ", getCellphone()=" + getCellphone() + ", toString()=" + super.toString() + "]";
	}
}