package com.coolweather.app.util;

/**
 * �ص�����
 * @author HP
 *
 */
public interface HttpCallbackListener {

	public void onFinish(String respone);

	public void onError(Exception e);

}
