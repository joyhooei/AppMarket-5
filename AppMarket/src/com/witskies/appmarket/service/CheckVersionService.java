package com.witskies.appmarket.service;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.witskies.appmarket.app.MyApplication;
import com.witskies.appmarket.asynchttp.JsonHttpResponseHandler;
import com.witskies.appmarket.http.HttpUri;
import com.witskies.appmarket.http.MyHttpClient;
import com.witskies.appmarket.util.LogUtils;

public class CheckVersionService extends Service {
	// It's the mer of server
	private static final String TAG = "CheckVersionService";
	/** 版本号 */
	private int versionCode;
	/** 版本名称 */
	private String versionName = "";
	/** 下载地址 */
	private String downLoadUrl = "";
	/** 更新日志 */
	private String updateLog = "";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LogUtils.d(TAG, "启动CheckVersionService");
		getAppVersion();
		return super.onStartCommand(intent, flags, startId);
	}

	public void getAppVersion() {

		MyHttpClient.getVersion(HttpUri.APPVERSION, null, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, JSONObject response) {
				try {
					versionCode = response.getInt("versionCode");
					versionName = response.getString("versionName");
					downLoadUrl = response.getString("downloadUrl");
					updateLog = response.getString("updateAppLog");
					LogUtils.d(TAG, versionCode + "\n" + versionName + "\n" + downLoadUrl + "\n" + updateLog);
					stopSelf();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				super.onSuccess(statusCode, response);
			}

			@Override
			public void onFailure(Throwable e, JSONObject errorResponse) {
				// 获取失败
				stopSelf();
				// LogUtil.d(TAG, "检查更新失败：" + errorResponse.toString());
				super.onFailure(e, errorResponse);
			}
		});
	}
}
