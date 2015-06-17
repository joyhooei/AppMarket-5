package com.witskies.appmarket.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import android.content.Context;

import com.witskies.appmarket.asynchttp.AsyncHttpClient;
import com.witskies.appmarket.asynchttp.AsyncHttpResponseHandler;
import com.witskies.appmarket.asynchttp.JsonHttpResponseHandler;
import com.witskies.appmarket.asynchttp.RequestParams;

public class MyHttpClient {
	private static AsyncHttpClient client;

	/**
	 * 
	 * @Description: 获取站点
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void getSite(String url, AsyncHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(url, responseHandler);
	}

	/**
	 * 
	 * @Description: 注册
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void postRegister(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.post(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 登陆
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void postLogin(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.addHeader("Authorization", "Basic YW5kcm9pZENsaWVudDpOZXB0dW5l'");
		client.post(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 获取用户信息
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @param access_token
	 * @return void
	 */
	public static void getUerInfo(String url, String access_token, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.addHeader("Authorization", "Bearer " + access_token);
		client.get(url, responseHandler);
	}

	/**
	 * 
	 * @Description: 获取订单
	 * @param url
	 * @param access_token
	 * @param responseHandler
	 * @return void
	 */
	public static void getOrders(String url, String access_token, RequestParams params,
			JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.addHeader("Authorization", "Bearer " + access_token);
		client.get(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 获取商户
	 * @param id
	 * @param params
	 * @param responseHandler
	 */
	public static void getMerchant(String id, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(HttpUri.MERCHANT + id, responseHandler);
	}

	/**
	 * 
	 * @Description: 获取商品信息
	 * @param id
	 * @param responseHandler
	 */
	public static void getProducts(String id, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(HttpUri.PRODUCTS + id, responseHandler);
	}

	/**
	 * 
	 * @Description: 增加站点
	 * @param url
	 * @param params
	 * @param responseHandler
	 */
	public static void postSites(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.post(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 根据站点id获取站长
	 * @param url
	 * @param params
	 * @param responseHandler
	 */
	public static void getSiteMaster(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 根据站点id获取快递员
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void getSiteCouriers(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 获取版本号
	 * @param url
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void getVersion(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.get(url, params, responseHandler);
	}

	/**
	 * 
	 * @Description: 修改运单
	 * @param url
	 * @param access_token
	 * @param params
	 * @param responseHandler
	 * @return void
	 */
	public static void patchWayBills(Context context, String uri, String access_token, String body,
			JsonHttpResponseHandler responseHandler) {
		client = new AsyncHttpClient();
		client.addHeader("Authorization", "Bearer " + access_token);
		client.addHeader("Content-Type", "application/json");
		try {
			client.patch(context, uri, new StringEntity(body, "UTF-8"), "application/json", responseHandler);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向上传快递员经纬度信息
	 * 
	 * @param params
	 *            经度、纬度、快递员ID信息
	 * @param jsonHttpResponseHandler
	 *            回调接口
	 */
	public static void postLocation(String access_token, String body, JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		client.addHeader("Authorization", "Bearer " + access_token);
		try {
			client.post(null, HttpUri.LOCATION, new StringEntity(body, "UTF-8"), "application/json",
					jsonHttpResponseHandler);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取快递员的位置信息
	 * 
	 * @param params
	 *            快递员ID，日期范围
	 * @param jsonHttpResponseHandler
	 *            回调接口
	 */
	public static void getLocation(RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		client.get(HttpUri.LOCATION, params, jsonHttpResponseHandler);
	}

	/**
	 * 获取快递员的最新位置信息
	 * 
	 * @param params
	 *            快递员ID，日期范围
	 * @param jsonHttpResponseHandler
	 *            回调接口
	 */
	public static void getLocationLatest(RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		client.get(HttpUri.LOCATIONLATEST, params, jsonHttpResponseHandler);
	}

	/**
	 * @param identity
	 * @param params
	 * @param jsonHttpResponseHandler
	 */
	public static void getPostmanID(String identity, RequestParams params,
			JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		String temp_uri = null;
		if (identity.equals("postman")) {
			temp_uri = HttpUri.GETEXPPOSTMANID;
		} else if (identity.equals("sitemanager")) {
			temp_uri = HttpUri.GETEXPSITEMANAGERID;
		} else if (identity.equals("admin")) {
			temp_uri = HttpUri.GETEADMINID;
		} else {
			return;
		}
		client.post(temp_uri, params, jsonHttpResponseHandler);
	}

	/**
	 * @param params
	 * @param jsonHttpResponseHandler
	 */
	public static void getPostman(RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		client.post(HttpUri.COURIERSINFO, params, jsonHttpResponseHandler);
	}

	/**
	 * 获取手机验证码
	 * 
	 * @param params
	 * @param jsonHttpResponseHandler
	 */
	public static void getVerifyCode(RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		client.post(HttpUri.GETVERIFYCODE, params, jsonHttpResponseHandler);
	}

	/**
	 * 重置密码
	 * 
	 * @param iD
	 *            快递员ID
	 * @param iD2
	 * @param params
	 *            参数列表
	 * @param jsonHttpResponseHandler
	 *            回调函数
	 */
	public static void requestFindPassWord(String identity, String iD, RequestParams params,
			JsonHttpResponseHandler jsonHttpResponseHandler) {
		client = new AsyncHttpClient();
		String temp_uri = "";
		if (identity.equals("postman")) {
			temp_uri = HttpUri.REST_POSTMAN_PASSWORD;
		} else if (identity.equals("sitemanager")) {
			temp_uri = HttpUri.REST_SITEMANAGER_PASSWORD;
		} else if (identity.equals("admin")) {
			temp_uri = HttpUri.REST_ADMIN_PASSWORD;
		} else {
			return;
		}
		client.post(temp_uri + iD + "/password/recovery", params, jsonHttpResponseHandler);
	}


}
