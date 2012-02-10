package org.snailteam.android.adapter;

import org.snailteam.android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {

	View[] views;

	public GridViewAdapter(Context context, String[] titles, String[] contents) {
		views = new View[titles.length];
		for (int i = 0; i < titles.length; i++) {
			views[i] = getCellView(context, titles[i], contents[i]);
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

	private View getCellView(Context context, String title, String content) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.item_cell, null);
		ImageView imageView = (ImageView) itemView
				.findViewById(R.id.imageView1);

		TextView titleView = (TextView) itemView.findViewById(R.id.item_title);
		titleView.setText(title);

		TextView infoView = (TextView) itemView.findViewById(R.id.item_info);
		infoView.setText(content);
		Button button = (Button) itemView.findViewById(R.id.button1);
		return itemView;
	}
}
