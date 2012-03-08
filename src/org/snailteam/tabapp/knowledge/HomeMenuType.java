package org.snailteam.tabapp.knowledge;

public enum HomeMenuType {
	HOMESHOP("home_menu_shop"),// 未知类型
	HOMEFRIEND("home_menu_friend"),// google
	HOMEPLAZA("home_menu_plaza");// 百度
	
	private String menu;
	
	private HomeMenuType(String menu) {
		this.menu = menu;
	}
	
	public String value() {
		return this.menu;
	}
}
