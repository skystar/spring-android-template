package org.snailteam.tabapp.activity;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.adapter.ShopCateGridView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ShopHomeActivity extends Activity {
	private GridView shopGridview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shophome);
		shopGridview = (GridView) findViewById(R.id.shopHomeGrivdView);
		shopGridview.setAdapter(new ShopCateGridView(this));
	}

}
