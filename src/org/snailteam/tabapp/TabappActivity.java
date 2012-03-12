package org.snailteam.tabapp;


import org.snailteam.tabapp.activity.ShopHomeActivity;
import org.snailteam.tabapp.activity.ShopListActivity;
import org.snailteam.tabapp.knowledge.HomeMenuType;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class TabappActivity extends TabActivity implements
		OnCheckedChangeListener {
	/** Called when the activity is first created. */
	private static String url = "http://192.168.1.105:8080/mongo-spring-mvc/citys";
	private TabHost mHost;
	private RadioGroup radioderGroup;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		

		// 实例化TabHost
		mHost = this.getTabHost();

		// 添加选项卡
		mHost.addTab(mHost.newTabSpec(HomeMenuType.HOMESHOP.value())
				.setIndicator(HomeMenuType.HOMESHOP.value())
				.setContent(new Intent(this, ShopHomeActivity.class)));
		mHost.addTab(mHost.newTabSpec(HomeMenuType.HOMEFRIEND.value())
				.setIndicator(HomeMenuType.HOMEFRIEND.value())
				.setContent(new Intent(this, ShopListActivity.class)));
		mHost.addTab(mHost.newTabSpec(HomeMenuType.HOMEPLAZA.value())
				.setIndicator(HomeMenuType.HOMEPLAZA.value())
				.setContent(new Intent(this, ShopListActivity.class)));
		radioderGroup = (RadioGroup) findViewById(R.id.main_radio);
		radioderGroup.setOnCheckedChangeListener(this);
		
		
		

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.home_menu_shop:
			mHost.setCurrentTabByTag(HomeMenuType.HOMESHOP.value());
			break;
		}
	}

}