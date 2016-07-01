package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	/**
	 * 数据库名称
	 */
	public static final String DB_NAME = "cool_weather";

	/**
	 * 数据库版本
	 */
	public static final int VERSION = 1;

	public static CoolWeatherDB coolWeatherDB;

	private SQLiteDatabase db;

	public CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,
				DB_NAME, null, VERSION);
	}
	
	/**
	 * 获取CoolWeatherDB实例
	 */
	public synchronized static CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB != null){
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
}
