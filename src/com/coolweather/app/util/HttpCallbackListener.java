package com.coolweather.app.util;

/**
 * 回调机制
 * @author HP
 *
 */
public interface HttpCallbackListener {

	public void onFinish(String respone);

	public void onError(Exception e);

}
