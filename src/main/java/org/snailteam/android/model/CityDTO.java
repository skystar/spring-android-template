package org.snailteam.android.model;

import java.io.Serializable;

public class CityDTO implements Serializable {

	Long id;
	String name;
	Long count = 0L;
	/**
	 * 
	 * double[] location = bundle.getDoubleArray("location");
	 * curr_point.setLongitudeE6((int) (location[0] * 1E6));
	 * curr_point.setLatitudeE6((int) (location[1] * 1E6));
	 * 
	 */
	double[] location;

	public void setLocation(double[] location) {
		this.location = location;
	}

	public double[] getLocation() {
		return location;
	}

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
