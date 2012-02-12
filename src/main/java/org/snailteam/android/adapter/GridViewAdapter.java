package org.snailteam.android.adapter;
import java.util.ArrayList;
import java.util.List;

import org.snailteam.android.model.CityDTO;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridViewAdapter extends BaseAdapter {

	List<View> views;

	public GridViewAdapter(Context context, List<CityDTO> citys) {
		views = new ArrayList<View>();
		for (CityDTO dto : citys) {
			views.add(getCityCellView(context, dto));
		}
	}

	private View getCityCellView(final Context context, final CityDTO cityDTO) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.test_list_item, null);
		return itemView;
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public View getItem(int position) {
		return views.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			return views.get(position);
		}
		return convertView;
	}

}
