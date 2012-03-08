package org.snailteam.tabapp.activity;

import java.util.List;

import org.snailteam.tabapp.R;
import org.snailteam.tabapp.until.mapabc.LocationListenerProxy;
import org.snailteam.tabapp.until.mapabc.PointOverlay;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.mapabc.mapapi.GeoPoint;
import com.mapabc.mapapi.LocationManagerProxy;
import com.mapabc.mapapi.MapActivity;
import com.mapabc.mapapi.MapController;
import com.mapabc.mapapi.MapView;
import com.mapabc.mapapi.Overlay;

public class MapABCMain extends MapActivity implements LocationListener {

	// private static String mapabcKey =
	// "c2b0f58a6f09cafd1503c06ef08ac7aeb7ddb91aa718aa61979d7d584306a8d874d435e5b07ca616";
	private MapView mMapView;
	private MapController mMapController;
	private GeoPoint point;
	private LocationManagerProxy locationManager = null;
	private LocationListenerProxy mLocationListener = null;
	private static final long mLocationUpdateMinTime = 100;
	private static final float mLocationUpdateMinDistance = 10.0f;

	private PointOverlay pointOverlay;

	public void onCreate(Bundle savedInstanceState) {
		this.setMapMode(MAP_MODE_VECTOR);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		locationManager = new LocationManagerProxy(this, getResources()
				.getString(R.string.maps_api_key));
		enableLocation();
		mMapView = (MapView) findViewById(R.id.mapabcMapView);
		mMapView.setBuiltInZoomControls(true);
		mMapController = mMapView.getController();
		mMapController.setZoom(18);

		// 根据设置的Criteria对象，获取最符合此标准的provider对象
		String currentProvider = locationManager.getProvider(
				LocationManager.GPS_PROVIDER).getName();

		// 根据当前provider对象获取最后一次位置信息
		Location currentLocation = locationManager
				.getLastKnownLocation(currentProvider);
		if (currentLocation != null)
			setMapCenter(currentLocation);

	}

	public boolean enableLocation() {
		boolean result = true;
		if (mLocationListener == null) {
			mLocationListener = new LocationListenerProxy(locationManager);
			result = mLocationListener.startListening(this,
					mLocationUpdateMinTime, mLocationUpdateMinDistance);
		}
		return result;
	}

	public void disableMyLocation() {
		if (mLocationListener != null) {
			mLocationListener.stopListening();
		}
		mLocationListener = null;
	}

	@Override
	protected void onPause() {
		super.onPause();
		disableMyLocation();
	}

	@Override
	protected void onResume() {
		super.onResume();
		enableLocation();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	/**
	 * 位置改变
	 */
	public void onLocationChanged(Location location) {
		if (location != null) {
			Toast.makeText(this,
					location.getLatitude() + "=" + location.getLongitude(),
					Toast.LENGTH_SHORT).show();
			setMapCenter(location);
		}
	}

	public void setMapCenter(Location location) {
		Double geoLat = location.getLatitude();
		Double geoLng = location.getLongitude();
		point = new GeoPoint((int) (geoLat * 1E6), (int) (geoLng * 1E6));
		if (pointOverlay == null) {
			BitmapDrawable marker = new BitmapDrawable(
					BitmapFactory.decodeResource(getResources(),
							R.drawable.da_marker_red));
			marker.setBounds(0, 0, marker.getIntrinsicWidth(),
					marker.getIntrinsicHeight());
			pointOverlay = new PointOverlay(point, mMapView, marker, this);
		} else {
			pointOverlay.setGeoPoint(point);
			pointOverlay.init();
		}

		mMapView.getOverlays().add(pointOverlay);
		mMapController.setCenter(point);

	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}
