package org.snailteam.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class AppStoreActivity extends Activity {

	GridView gridView;
	ScrollView scrollView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gridView1);
		scrollView = (ScrollView) findViewById(R.id.scrollView1);
		gridView.setAdapter(new ListViewAdapter(this));

	}

	protected class ListViewAdapter extends BaseAdapter {
		View[] views;

		public ListViewAdapter(Context context) {
			views = new View[100];
			for (int i = 0; i < views.length; i++) {
				views[i] = getCellView(context);
			}
		}

		public int getCount() {
			return views.length;
		}

		public View getItem(int position) {
			return views[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				return views[position];
			}
			return convertView;
		}

	}

	private View getCellView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		// 使用View的对象itemView与R.layout.item关联
		View itemView = (View) inflater.inflate(R.layout.item_cell, null);
		ImageView imageView = (ImageView) itemView
				.findViewById(R.id.imageView1);
		Button button = (Button) itemView.findViewById(R.id.button1);
		return itemView;

	}

}