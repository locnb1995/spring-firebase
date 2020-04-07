package com.baoloc.hus.firebaseapp.entity;

public final class Employee
{
	private String id;
	private String name;
	private Integer age;
	private String hometown;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getHometown()
	{
		return hometown;
	}

	public void setHometown(String hometown)
	{
		this.hometown = hometown;
	}
}
