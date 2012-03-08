package org.snailteam.tabapp.activity;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.until.ImageUntil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {
	RelativeLayout prodDetailHeader;
	RelativeLayout prodDetailBody;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailcontainer);
		prodDetailHeader = (RelativeLayout) findViewById(R.id.detailHeader);
		prodDetailBody = (RelativeLayout) findViewById(R.id.detailBody);
		prodDetailHeader.addView(getDetailHeaderView());
		View vi = getDetailBodyView();
		prodDetailBody.addView(vi);

	}

	private View getDetailHeaderView() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.productheader, null);
		ImageView productSmallPic = (ImageView) itemView
				.findViewById(R.id.productHeaderPic);
		ImageUntil.setImageViewFromUrl(
				"http://p0.meituan.net/275.168/deal/201202/21/_0221200114.jpg",
				productSmallPic);
		TextView productName = (TextView) itemView
				.findViewById(R.id.productHeaderName);
		productName.setText("美嘉欢乐影城（中关村店）");
		TextView shopAddr = (TextView) itemView
				.findViewById(R.id.productHeaderAddr);
		shopAddr.setText("海淀区中关村大街15号中关村广场购物中心津乐汇3楼");
		return itemView;
	}

	private View getDetailBodyView() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = (View) inflater.inflate(R.layout.productbody, null);
		TextView detailDesc = (TextView) itemView
				.findViewById(R.id.productBodyDesc);
		TextView detailCate = (TextView) itemView
				.findViewById(R.id.productBodyCate);
		TextView detailPrice = (TextView) itemView
				.findViewById(R.id.productBodyPrice);
		TextView detailTuanPrice = (TextView) itemView
				.findViewById(R.id.productBodyTuanPrice);
		TextView detailMount = (TextView) itemView
				.findViewById(R.id.productBodyMount);
		TextView detailStart = (TextView) itemView
				.findViewById(R.id.productBodyStartTime);
		TextView detailEnd = (TextView) itemView
				.findViewById(R.id.productBodyEndTime);
		TextView detailRemark = (TextView) itemView
				.findViewById(R.id.productBodyRemark);
		TextView detailIntro = (TextView) itemView
				.findViewById(R.id.productBodyIntro);

		detailDesc
				.setText("仅售89元！价值284元的狗不理双人套餐2选1（A.猪肉包+三鲜包+菠萝咕噜肉+津味双鲜+凉拌木耳+话梅南瓜；B.猪肉包+三鲜包+虾仁烧茄子+津味双鲜+凉拌木耳+话梅南瓜），2张美团券可升级为4-6人套餐（猪肉包+三鲜包+菠萝咕噜肉+津味双鲜+凉拌木耳+时蔬大拌菜+虾仁独面筋+川北凉粉+乌鱼蛋汤+罾蹦鲤鱼+话梅南瓜）。别的咱不夸，就夸夸这薄皮大馅十八个褶儿~");
		detailCate.setText("餐饮 - 其他中餐");
		detailPrice.setText("原价：284");
		detailTuanPrice.setText("团购价：89");
		detailMount.setText("购买数量：5-119");
		detailStart.setText("开始时间：2012年5月7号  ");
		detailEnd.setText("结束时间：2012年6月30号");
		detailRemark
				.setText("有效期 2012.2.29 至 2012.4.30; 营业时间：09:00-21:00; 请提前1天致电63533338预约; 仅限堂食，不提供餐前外带服务; 仅限大厅用餐，不可使用包间; 不可同时享受店内其他优惠;");
		detailIntro
				.setText("百年传承，文化范的传统工艺 慈禧太后盛赞佳品 大栅栏里的百年品牌 历史文化孕育天津经典小吃 地处京城老地段，交通便利");

		return itemView;
	}
}
