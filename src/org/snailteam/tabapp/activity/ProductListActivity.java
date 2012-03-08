package org.snailteam.tabapp.activity;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.adapter.ProductListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ProductListActivity extends Activity {
	private ListView prodGridview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontainer);
		prodGridview = (ListView) findViewById(R.id.listContainer);
		prodGridview.setAdapter(new ProductListAdapter(this));
	}
}
