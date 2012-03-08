package org.snailteam.tabapp.until.mapabc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

import com.mapabc.mapapi.GeoPoint;
import com.mapabc.mapapi.MapView;
import com.mapabc.mapapi.Overlay;

public class PointOverlay extends Overlay {
	private GeoPoint geoPoint;
	MapView mapView;
	BitmapDrawable marker;
	Context context;

	public PointOverlay(GeoPoint geoPoint, MapView mapView,
			BitmapDrawable marker, Context context) {
		super();
		this.geoPoint = geoPoint;
		this.mapView = mapView;
		this.marker = marker;
		this.context = context;
	}

	public void init() {
		this.draw(new Canvas(), mapView, false);
	}

	public void draw(Canvas canvas, MapView map, boolean shadow) {
		Point point = new Point();
		mapView.getProjection().toPixels(geoPoint, point);
		Bitmap bitmap = marker.getBitmap();
		Paint paint = new Paint();
		canvas.drawBitmap(bitmap, point.x - 20, point.y - 80, paint);
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}

	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}

	public void setMarker(BitmapDrawable marker) {
		this.marker = marker;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public MapView getMapView() {
		return mapView;
	}

	public BitmapDrawable getMarker() {
		return marker;
	}
}
