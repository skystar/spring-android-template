package org.snailteam.android;

import org.snailteam.android.adapter.ItemCellGridViewAdapter;
import org.snailteam.android.adapter.ProductCellGridViewAdapter;
import org.snailteam.android.adapter.ShopInfoGridViewAdapter;
import org.snailteam.android.until.MenuStaut;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class AppMainActivity extends Activity {
	public static String url = "http://192.168.0.103:8080/team/api";
	MenuStaut currStatu = MenuStaut.MENU;
	GridView gridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new ItemCellGridViewAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (currStatu == MenuStaut.MENU) {
					currStatu = MenuStaut.PRODUCT;
					gridView.setAdapter(new ProductCellGridViewAdapter(
							AppMainActivity.this));
				} else if (currStatu == MenuStaut.PRODUCT) {
					currStatu = MenuStaut.SHOPINFO;
					gridView.setAdapter(new ShopInfoGridViewAdapter(
							AppMainActivity.this));
				} else if (currStatu == MenuStaut.SHOPINFO) {
					currStatu = MenuStaut.MENU;
					gridView.setAdapter(new ItemCellGridViewAdapter(
							AppMainActivity.this));
				}
			}
		});
	}

}
