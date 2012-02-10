package org.snailteam.android;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.snailteam.android.adapter.GridViewAdapter;
import org.snailteam.android.model.Shop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.Toast;

public class AppMainActivity extends Activity {
	public static String url = "http://192.168.0.103:8080/team/api";

	GridView gridView;
	ScrollView scrollView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView = (GridView) findViewById(R.id.gridView1);
		scrollView = (ScrollView) findViewById(R.id.scrollView1);
		String url = "http://192.168.1.105:8080/team/citys";
		HttpPost postRequest = new HttpPost(url);
		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse postResp = client.execute(postRequest);
			String result = "";
			if (postResp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(postRequest.getEntity());
				JSONObject jsonObject = new JSONObject(result);
				int count = jsonObject.getInt("count");
				JSONArray arrayJson = jsonObject.getJSONArray("citys");
				String[] titles = new String[count];
				String[] contents = new String[count];
				for (int i = 0; i < count; i++) {
					titles[i] = arrayJson.getJSONObject(i).getString("id");
					contents[i] = arrayJson.getJSONObject(i).getString("name");
					gridView.setAdapter(new GridViewAdapter(this, titles,
							contents));
				}
			}
		} catch (UnsupportedEncodingException e) {
			Toast.makeText(AppMainActivity.this, "1" + e.getMessage(),
					Toast.LENGTH_LONG).show();
		} catch (ClientProtocolException e) {
			Toast.makeText(AppMainActivity.this, "2" + e.getMessage(),
					Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(AppMainActivity.this, "3" + e.getMessage(),
					Toast.LENGTH_LONG).show();
		} catch (JSONException e) {
			Toast.makeText(AppMainActivity.this, "4" + e.getMessage(),
					Toast.LENGTH_LONG).show();
		}

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
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws JSONException
	 */

	public List<Shop> getShops(String url, String keyword, Long cityId)
			throws ClientProtocolException, IOException, JSONException {

		HttpPost postRequest = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("keyword", keyword));
		params.add(new BasicNameValuePair("city", cityId.toString()));
		postRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		HttpResponse postResp = new DefaultHttpClient().execute(postRequest);
		String result = null;
		if (postResp.getStatusLine().getStatusCode() == 200) {
			result = EntityUtils.toString(postResp.getEntity());
		}
		if (result == null)
			return null;

		JSONObject jsonObject = new JSONObject(result);
		List<Shop> shops = new ArrayList<Shop>();
		if (jsonObject.isNull("list")) {
			JSONArray arrayJson = jsonObject.getJSONArray("list");
			for (int i = 0; i < arrayJson.length(); i++) {
				Shop shop = new Shop();
				shop.setId(arrayJson.getJSONObject(i).getLong("id"));
				shop.setInfo(arrayJson.getJSONObject(i).getString("shopAddr"));
				shop.setName(arrayJson.getJSONObject(i).getString("shopName"));

			}
		}
		return shops;
	}
}
