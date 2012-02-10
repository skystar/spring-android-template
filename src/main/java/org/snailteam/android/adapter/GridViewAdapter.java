package org.snailteam.android.adapter;

import org.snailteam.android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter {
	
	View[] views;

	public GridViewAdapter(Context context) {
		views = new View[100];
		for (int i = 0; i < views.length; i++) {
			views[i] = getCellView(context);
		}
	}

	@Override
	public int getCount() {
		return views.length;
	}

	@Override
	public View getItem(int position) {
		return views[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			return views[position];
		}
		return convertView;
	}

	private View getCellView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// 使用View的对象itemView与R.layout.item关联
		View itemView = (View) inflater.inflate(R.layout.item_cell, null);
		ImageView imageView = (ImageView) itemView
				.findViewById(R.id.imageView1);
		Button button = (Button) itemView.findViewById(R.id.button1);
		return itemView;
	}
}
