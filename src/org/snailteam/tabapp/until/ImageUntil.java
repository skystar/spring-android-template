package org.snailteam.tabapp.until;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

public class ImageUntil {
	static ImageView singImageView; // 针对于单张图片异步加载
	private static HashMap<String, SoftReference<Drawable>> singleImageCache = null;

	/**
	 * 通过图片地址,返回drawable
	 * 
	 * @param url
	 * @return
	 */
	public static Drawable loadImageFromUrl(String url) {
		ByteArrayOutputStream out = null;
		Drawable drawable = null;
		int BUFFER_SIZE = 1024 * 16;
		InputStream inputStream = null;
		try {
			inputStream = new URL(url).openStream();
			BufferedInputStream in = new BufferedInputStream(inputStream,
					BUFFER_SIZE);
			out = new ByteArrayOutputStream(BUFFER_SIZE);
			int length = 0;
			byte[] tem = new byte[BUFFER_SIZE];
			length = in.read(tem);
			while (length != -1) {
				out.write(tem, 0, length);
				length = in.read(tem);
			}
			in.close();
			drawable = Drawable.createFromStream(
					new ByteArrayInputStream(out.toByteArray()), "src");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
				}
			}
		}
		return drawable;
	}

	/**
	 * 异步设置单张imageview图片,采取软引用
	 * 
	 * @param url
	 *            网络图片地址
	 * @param imageView
	 *            需要设置的imageview
	 */
	public static void setImageViewFromUrl(final String url,
			final ImageView imageView) {
		singImageView = imageView;
		// 如果软引用为空,就新建一个
		if (singleImageCache == null) {
			singleImageCache = new HashMap<String, SoftReference<Drawable>>();
		}
		// 如果软引用中已经有了相同的地址,就从软引用中获取
		if (singleImageCache.containsKey(url)) {
			SoftReference<Drawable> soft = singleImageCache.get(url);
			Drawable draw = soft.get();
			singImageView.setImageDrawable(draw);
			return;
		}
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				singImageView.setImageDrawable((Drawable) msg.obj);
			}
		};
		// 子线程不能更新UI,又不然会报错
		new Thread() {
			public void run() {
				Drawable drawable = loadImageFromUrl(url);
				if (drawable == null) {
					Log.e("single imageview",
							"single imageview of drawable is null");
				} else {
					// 把已经读取到的图片放入软引用
					singleImageCache.put(url, new SoftReference<Drawable>(
							drawable));
				}
				Message message = handler.obtainMessage(0, drawable);
				handler.sendMessage(message);
			};
		}.start();
	}

	/**
	 * 从服务器取图片 http://bbs.3gstdy.com
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getHttpBitmap(String url) {
		URL myFileUrl = null;
		Bitmap bitmap = null;
		try {
			myFileUrl = new URL(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setConnectTimeout(0);
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}
