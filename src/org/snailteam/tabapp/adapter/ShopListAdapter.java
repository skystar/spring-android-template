package org.snailteam.tabapp.adapter;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.activity.ShopDetailActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopListAdapter extends BaseAdapter {
	public static int MAXSIZE = 10;
	Context context;
	View[] views = new View[MAXSIZE];

	public ShopListAdapter(Context context) {
		this.context = context;
		for (int i = 0; i < views.length; i++) {
			views[i] = getSimpleShopCellView();
		}
	}

	private View getSimpleShopCellView() {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.shopcell, null);
		ImageView shopSmallPic = (ImageView) itemView
				.findViewById(R.id.shopCellPic);
		// shopSmallPic
		// .setImageURI(Uri
		// .parse("http://p1.meituan.net/275.168/deal/201203/02/007_0302153445.jpg"));
		TextView shopName = (TextView) itemView
				.findViewById(R.id.shopCellName);
		TextView shopDist = (TextView) itemView
				.findViewById(R.id.shopCellDistance);
		shopName.setText("美嘉欢乐影城（中关村店）");
		TextView shopAddr = (TextView) itemView
				.findViewById(R.id.shopCellAddr);
		shopAddr.setText("海淀区中关村大街15号中关村广场购物中心津乐汇3楼");
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent open = new Intent();
				open.setClass(context, ShopDetailActivity.class);
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
