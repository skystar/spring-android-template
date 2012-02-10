package org.snailteam.android;


import org.snailteam.android.adapter.GridViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;

public class AppMainActivity extends Activity {
	GridView gridView;
	ScrollView scrollView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView1);
		scrollView = (ScrollView) findViewById(R.id.scrollView1);
		gridView.setAdapter(new GridViewAdapter(this));
    }

}

