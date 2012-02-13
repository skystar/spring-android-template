package org.snailteam.android.adapter;

import org.snailteam.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ShopInfoGridViewAdapter extends BaseAdapter {

	View[] views;

	public ShopInfoGridViewAdapter(Context context) {
		views = new View[1];
		for (int i = 0; i < views.length; i++) {
			views[i] = getCityCellView(context);

		}

	}

	private View getCityCellView(final Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.shop_detail, null);
		return itemView;
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

}
