package org.snailteam.android.adapter;

import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.snailteam.android.BaiduMapActivity;
import org.snailteam.android.R;
import org.snailteam.android.model.CityDTO;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemCellGridViewAdapter extends BaseAdapter {

	View[] views;

	public ItemCellGridViewAdapter(Context context) {
		views = new View[10];
		for (int i = 0; i < views.length; i++) {
			views[i] = getCityCellView(context, null);

		}
	}

	public ItemCellGridViewAdapter(Context context, List<CityDTO> citys) {
		views = new View[citys.size()];
		for (int i = 0; i < views.length; i++) {
			views[i] = getCityCellView(context, citys.get(i));
		}
	}

	private View getCityCellView(final Context context, final CityDTO cityDTO) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.item_cell, null);
		TextView menuText = (TextView) itemView.findViewById(R.id.menuText);
		if (cityDTO != null) {
			menuText.setText(cityDTO.getName());
			menuText.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent open = new Intent();
					Bundle bund = new Bundle();
					bund.putDoubleArray("location", cityDTO.getLocation());
					open.putExtras(bund);
					open.setClass(context, BaiduMapActivity.class);// 我们要传递给的Activity类
					context.startActivity(open);
				}
			});
		}
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
