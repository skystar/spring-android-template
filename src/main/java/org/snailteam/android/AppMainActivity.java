package org.snailteam.android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.snailteam.android.model.Shop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Toast;

public class AppMainActivity extends Activity {
	public static String url = "http://localhost:8080/team/api";

	GridView gridView;
	ScrollView scrollView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gridView1);
		scrollView = (ScrollView) findViewById(R.id.scrollView1);

		// gridView.setAdapter(new GridViewAdapter(this));
	}

	/**
	 * 
	 * @RequestMapping(value = "/api", method = RequestMethod.POST) public
	 *                       ResponseDTO searchAPI(String keyword,
	 * @RequestParam(required = false) Long city)
	 * 
	 * 
	 * @param url
	 * @param keyword
	 * @param cityId
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	public List<Shop> getShops(String url, String keyword, Long cityId)
			throws ClientProtocolException, IOException {
		HttpPost postRequest = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("keyword", "东直门"));
		postRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		HttpResponse postResp = new DefaultHttpClient().execute(postRequest);
		String result = null;
		if (postResp.getStatusLine().getStatusCode() == 200) {
			result = EntityUtils.toString(postResp.getEntity());
		}
		if (result == null)
			return null;
		Toast.makeText(AppMainActivity.this, result, Toast.LENGTH_LONG).show();
		return null;
	}

}
