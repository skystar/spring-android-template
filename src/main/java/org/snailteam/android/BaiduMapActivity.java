package org.snailteam.android;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.LocationListener;
import com.baidu.mapapi.MKAddrInfo;
import com.baidu.mapapi.MKDrivingRouteResult;
import com.baidu.mapapi.MKLocationManager;
import com.baidu.mapapi.MKPoiResult;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MKSearchListener;
import com.baidu.mapapi.MKTransitRouteResult;
import com.baidu.mapapi.MKWalkingRouteResult;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.PoiOverlay;

public class BaiduMapActivity extends MapActivity {

	BMapManager bMapManager;
	MapView mapView;
	MKLocationManager mkLocationManager;
	Handler handler = new Handler();

	GeoPoint curr_point = new GeoPoint((int) (39.915 * 1E6),
			(int) (116.404 * 1E6));
	MapController mapController;
	MKSearch mkSearch = new MKSearch();

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		super.setContentView(R.layout.demomap);
		double[] location = bundle.getDoubleArray("location");
		curr_point.setLongitudeE6((int) (location[0] * 1E6));
		curr_point.setLatitudeE6((int) (location[1] * 1E6));
		initContext();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	protected void initContext() {
		// =====================================
		bMapManager = new BMapManager(getApplication());
		bMapManager.init("1469D01070D099AA798286F89017111ACE11B897", null);
		mkLocationManager = bMapManager.getLocationManager();
		super.initMapActivity(bMapManager);
		mapView = (MapView) findViewById(R.id.bmapsView);
		mkSearch.init(bMapManager, new MapSearchListener());
		mapView.setBuiltInZoomControls(true);
		mapController = mapView.getController();
		mapController.setCenter(curr_point); // 设置地图中心点
		mapController.setZoom(10); // 设置地图zoom级别
	}

	public class MapSearchListener implements MKSearchListener {
		@Override
		public void onGetAddrResult(MKAddrInfo result, int iError) {
		}

		@Override
		public void onGetDrivingRouteResult(MKDrivingRouteResult result,
				int iError) {
		}

		@Override
		public void onGetPoiResult(MKPoiResult result, int type, int iError) {
			if (result == null) {
				return;
			}
			PoiOverlay poioverlay = new PoiOverlay(BaiduMapActivity.this,
					mapView);
			poioverlay.setData(result.getAllPoi());
			mapView.getOverlays().add(poioverlay);
		}

		@Override
		public void onGetTransitRouteResult(MKTransitRouteResult result,
				int iError) {
		}

		@Override
		public void onGetWalkingRouteResult(MKWalkingRouteResult result,
				int iError) {
		}
	}

}
