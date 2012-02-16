package org.snailteam.android.model;

import java.util.ArrayList;
import java.util.List;


public class ResponseDTO {
	
	int count = 0;
	
	List<CityDTO> citys = new ArrayList<CityDTO>();

	List<ShopDTO> shops = new ArrayList<ShopDTO>();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CityDTO> getCitys() {
		return citys;
	}

	public void setCitys(List<CityDTO> citys) {
		this.citys = citys;
	}

	public List<ShopDTO> getShops() {
		return shops;
	}

	public void setShops(List<ShopDTO> shops) {
		this.shops = shops;
	}

}
