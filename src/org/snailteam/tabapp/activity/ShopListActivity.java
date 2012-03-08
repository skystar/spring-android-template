package org.snailteam.tabapp.activity;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.adapter.ShopListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ShopListActivity extends Activity {
	ListView shopListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontainer);
		shopListView = (ListView) findViewById(R.id.listContainer);
		shopListView.setAdapter(new ShopListAdapter(this));
	}
}
