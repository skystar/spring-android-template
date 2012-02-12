package main.java.org.snailteam.android.model;

import java.io.Serializable;

public class CityDTO implements Serializable {

	Long id;
	String name;
	String nameString;
	Long count = 0L;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
