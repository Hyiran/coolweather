package com.coolweather.app.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	/**
	 * 服务器端获取省市县数据
	 * 
	 * @param address
	 * @param listener
	 */
	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);

					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder respone = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						respone.append(line);
					}
					if (listener != null) {
						// 回调onFinish()方法
						listener.onFinish(respone.toString());
					}
				} catch (Exception e) {
					if(listener != null){
						// 回调onError()方法
						listener.onError(e);
					}
				}finally{
					if(connection != null){
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}
