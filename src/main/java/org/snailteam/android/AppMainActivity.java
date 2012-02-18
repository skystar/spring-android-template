package org.snailteam.android;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.snailteam.android.adapter.ItemCellGridViewAdapter;
import org.snailteam.android.adapter.ProductCellGridViewAdapter;
import org.snailteam.android.adapter.ShopInfoGridViewAdapter;
import org.snailteam.android.model.CityDTO;
import org.snailteam.android.until.MenuStaut;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class AppMainActivity extends Activity {
	public static String url = "http://192.168.0.103:8080/team/citys";
	MenuStaut currStatu = MenuStaut.MENU;
	GridView gridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final List<CityDTO> citys = new ArrayList<CityDTO>();
		RestTemplate restTemplate = new RestTemplate();
		String resultJson = restTemplate.getForObject(url, String.class);
		if (resultJson.length() > 0) {
			try {
				JSONObject jsonObject = new JSONObject(resultJson);
				JSONArray array = jsonObject.getJSONArray("citys");
				for (int i = 0; i < array.length(); i++) {
					CityDTO city = new CityDTO();
					JSONObject item = array.getJSONObject(i);
					city.setName(item.getString("name"));
					citys.add(city);
				}
			} catch (JSONException e) {
				showMessage(e.getMessage());
			}
		}

		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new ItemCellGridViewAdapter(this, citys));
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
							AppMainActivity.this, citys));
				}
			}
		});

	}

	public void showMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
