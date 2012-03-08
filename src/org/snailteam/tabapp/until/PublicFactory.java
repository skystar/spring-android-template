package org.snailteam.tabapp.until;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.snailteam.tabapp.model.City;

public class PublicFactory {
	/**
	 * 
	 { "count":6, "citys": [
	 * {"id":1,"name":"北京","longitude":116.395645,"latitude"
	 * :39.929986,"count":0},
	 * {"id":2,"name":"上海","longitude":121.487899,"latitude"
	 * :31.249162,"count":0},
	 * {"id":3,"name":"广州","longitude":113.30765,"latitude":23.120049,"count":0}
	 * ] }
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws JSONException
	 * 
	 */
	public static List<City> getCity(String url)
			throws ClientProtocolException, IOException, JSONException {
		List<City> citys = new ArrayList<City>();
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		String jsonString = null;
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			jsonString = EntityUtils.toString(httpResponse.getEntity());
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		if (!jsonObject.isNull("count")) {
			JSONArray citysJson = jsonObject.getJSONArray("citys");
			for (int i = 0; i < citysJson.length(); i++) {
				JSONObject cityJson = citysJson.getJSONObject(i);
				City city = new City();
				city.setId(cityJson.getLong("id"));
				city.setLatitude(cityJson.getDouble("latitude"));
				city.setLongitude(cityJson.getDouble("longitude"));
				city.setName(cityJson.getString("name"));
				citys.add(city);
			}

		}
		return citys;

	}
}
