package org.snailteam.tabapp.adapter;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.activity.ProductDetailActivity;
import org.snailteam.tabapp.until.ImageUntil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductListAdapter extends BaseAdapter {
	public static int MAXSIZE = 60;
	Context context;
	View[] views = new View[MAXSIZE];

	public ProductListAdapter(Context context) {
		this.context = context;
		for (int i = 0; i < views.length; i++) {
			views[i] = getSimpleProdCellView();
		}
	}

	private View getSimpleProdCellView() {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.productcell, null);
		ImageView shopSmallPic = (ImageView) itemView
				.findViewById(R.id.productCellPic);
		ImageUntil.setImageViewFromUrl(
				"http://p0.meituan.net/275.168/deal/201202/21/_0221200114.jpg",
				shopSmallPic);
		TextView productName = (TextView) itemView
				.findViewById(R.id.productCellName);
		TextView productDesc = (TextView) itemView
				.findViewById(R.id.productCellDesc);
		TextView productPice = (TextView) itemView
				.findViewById(R.id.productCellPrice);
		productName.setText("纪念邮票");
		productDesc.setText("仅89元！价值284元的狗不理双人套餐2选1，可升级");
		productPice.setText("89元");

		itemView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent open = new Intent();
				open.setClass(context, ProductDetailActivity.class);
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
