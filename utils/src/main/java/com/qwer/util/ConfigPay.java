package com.qwer.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**配置*/
public class ConfigPay {
	private static Properties prop = null;
	static {
		prop = new Properties();

		try {
			//从类路径下读取属性文件
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream
					("config.properties");
			prop.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String keyName) {
		return prop.getProperty(keyName);
	}

	public static String getProperty(String keyName, String defaultValue) {
		return prop.getProperty(keyName, defaultValue);
	}
	
	public static String scanPostUrl = getProperty("scanPostUrl");// 扫码支付地址
	public static String b2cPostUrl = getProperty("b2cPostUrl");// 网银支付地址
	public static String backProxyPayUrl = getProperty("backProxyPayUrl");// 代付（提现）地址
	public static String proxyPayQueryUrl = getProperty("proxyPayQueryUrl");// 代付（查询）地址
	public static String banlanceQueryUrl = getProperty("banlanceQueryUrl");// 余额查询
	public static String orderQueryUrl = getProperty("orderQueryUrl");// 订单查询

	public static String merchantCode = getProperty("merchantCode");// 商户号
	public static String payKey = getProperty("payKey");// 秘钥
}
