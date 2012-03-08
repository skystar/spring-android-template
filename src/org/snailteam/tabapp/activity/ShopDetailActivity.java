package org.snailteam.tabapp.activity;

import org.snailteam.tabapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShopDetailActivity extends Activity {
	RelativeLayout shopDetailHeader;
	RelativeLayout shopDetailBody;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailcontainer);
		shopDetailHeader = (RelativeLayout) findViewById(R.id.detailHeader);
		shopDetailBody = (RelativeLayout) findViewById(R.id.detailBody);
		shopDetailHeader.addView(getDetailHeaderView());
		shopDetailBody.addView(getDetailBodyView());
	}

	private void openMap() {
		Intent open = new Intent();
		open.setClass(this, MapABCMain.class);
		startActivity(open);
	}

	private View getDetailHeaderView() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater
				.inflate(R.layout.shopheader, null);
		ImageView shopSmallPic = (ImageView) itemView
				.findViewById(R.id.shopHeaderPic);
		TextView shopName = (TextView) itemView
				.findViewById(R.id.shopHeaderName);
		TextView shopDist = (TextView) itemView
				.findViewById(R.id.shopHeaderDistance);
		shopSmallPic.setImageResource(R.drawable.huoguo);
		shopName.setText("美嘉欢乐影城（中关村店）");
		shopDist.setText("500M");
		ImageButton mapButton = (ImageButton) itemView
				.findViewById(R.id.shopHeaderMapButton);
		TextView shopAddr = (TextView) itemView
				.findViewById(R.id.shopHeaderAddr);
		shopAddr.setText("海淀区中关村大街15号中关村广场购物中心津乐汇3楼");
		mapButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				openMap();

			}
		});
		return itemView;
	}

	private View getDetailBodyView() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater
				.inflate(R.layout.shopbody, null);
		return itemView;
	}
}
