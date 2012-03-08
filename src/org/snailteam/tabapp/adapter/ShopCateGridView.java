package org.snailteam.tabapp.adapter;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.activity.ProductListActivity;
import org.snailteam.tabapp.activity.ShopListActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopCateGridView extends BaseAdapter {

	public static int MAXSIZE = 2;
	Context context;
	View[] views = new View[MAXSIZE];

	public ShopCateGridView(Context context) {
		this.context = context;
		views[0] = getShopCellView();
		views[1] = getProdCellView();
	}

	private View getShopCellView() {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.shophomecata, null);
		ImageView imageView = (ImageView) itemView.findViewById(R.id.cataImage);
		imageView.setImageResource(R.drawable.ic_launcher);
		TextView textView = (TextView) itemView.findViewById(R.id.cataText);
		textView.setText("商店列表!");
		itemView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent open = new Intent();
				open.setClass(context, ShopListActivity.class);
				context.startActivity(open);
			}
		});
		return itemView;
	}

	private View getProdCellView() {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.shophomecata, null);
		ImageView imageView = (ImageView) itemView.findViewById(R.id.cataImage);
		imageView.setImageResource(R.drawable.ic_launcher);
		TextView textView = (TextView) itemView.findViewById(R.id.cataText);
		textView.setText("商品列表!");
		itemView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent open = new Intent();
				open.setClass(context, ProductListActivity.class);
				context.startActivity(open);
			}
		});
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
