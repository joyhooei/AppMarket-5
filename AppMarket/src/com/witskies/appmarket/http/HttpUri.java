package com.witskies.appmarket.http;

/**
 * 
 * @ClassName: HttpUri
 * @Description: 请求地址
 * @author LanJie.Chen
 * @date 2014-7-9 下午1:36:06
 * @version V1.0
 * @Company:山西润叶网络科技有限公司
 */
public class HttpUri {
	/** 正式api */
	// "http://api.tyfind.com:8888/";
	/** 测试api */
	// "api.tyfind.cn:8008";

	public static final String IP = "http://api.tyfind.cn:8008/";
	/** 站长注册 */
	public static final String MASTER = IP + "expsitemanagers";
	/** 快递员 */
	public static final String COURIERS = IP + "exppostmans";
	/** 登陆 */
	public static final String LOGIN = IP + "token";
	/** 站点 */
	public static final String SITE = IP + "expsites";
	/** 订单 */
	public static final String ORDERS = IP + "orders";

	/** 用户session */
	public static final String USERINFO = IP + "session";
	/** merchant */
	public static final String MERCHANT = IP + "merchants/";

	/** products */
	public static final String PRODUCTS = IP + "products/";
	/** 运单获取 */
	public static final String WAYBILLS = IP + "waybills";
	/** 下载地址 */
	public static final String UPLOADS = IP + "uploads/";

	/** 向服务器上传快递员经纬度信息 */
	public static final String LOCATION = IP + "exppostlocations";

	/** 获取快递员最新位置信息 */
	public static final String LOCATIONLATEST = IP + "exppostlocations/postmanlatest";
	/** GET ID */
	public static final String GETEXPPOSTMANID = IP + "exppostmans/getexppostmanid";
	public static final String GETEXPSITEMANAGERID = IP + "expsitemanagers/getexpsitemanagerid";
	public static final String GETEADMINID = IP + "";

	/** Verify Verify Code */
	public static final String GETVERIFYCODE = IP + "verificationcode/send";

	/** Reset postaman'password */
	public static final String REST_POSTMAN_PASSWORD = IP + "exppostmans/";
	/** Reset sitemanager'password */
	public static final String REST_SITEMANAGER_PASSWORD = IP + "expsitemanagers/";
	/** Reset admin'password */

	public static final String REST_ADMIN_PASSWORD = IP + "";

	/*** 获取信息 */
	public static final String COURIERSINFO = IP + "exppostmans/guestview";

	public static final String APPVERSION = "http://www.tyfind.com:8080/find-express-android-updata/update.json";
}
