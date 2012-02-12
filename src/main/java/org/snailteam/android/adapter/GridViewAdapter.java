package main.java.org.snailteam.android.adapter;

import java.util.ArrayList;
import java.util.List;

import main.java.org.snailteam.android.model.CityDTO;

import org.snailteam.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewAdapter extends BaseAdapter {

	List<View> views;

	public GridViewAdapter(Context context, List<CityDTO> citys) {
		views = new ArrayList<View>();
		for (CityDTO dto : citys) {
			views.add(getCellView(context, dto));
		}
	}

	private View getCellView(final Context context, final CityDTO cityDTO) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.item_cell, null);
		TextView titleView = (TextView) itemView.findViewById(R.id.item_title);
		titleView.setText(cityDTO.getId().toString());
		TextView infoView = (TextView) itemView.findViewById(R.id.item_info);
		infoView.setText(cityDTO.getName());
		Button button = (Button) itemView.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Toast.makeText(context, cityDTO.getCount().toString(),
						Toast.LENGTH_LONG).show();
			}
		});
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
