package com.qwer.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;

/**
 * http相关工具类
 */
public class HttpUtils {
	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
	

	public static String httpClientPost(String url, String enc, Map<String, String> params) {
		return httpClientPost(url, enc, params, 60);
	}
	
	/**
	 * POST请求
	 * @param url
	 * @param enc
	 * @param params
	 * @return
	 */
	public static String httpClientPost(String url, String enc, Map<String, String> params, int timeOut) {
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, enc);
			client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0,false));
			client.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut*1000);
		    client.getHttpConnectionManager().getParams().setSoTimeout(timeOut*1000);
			PostMethod postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Connection", "close"); 
			if (params != null) {
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				for (Entry<String, String> entry : params.entrySet()) {
					String key = entry.getKey();
					String value = entry.getValue();
					NameValuePair param = new NameValuePair( key , value );
					list.add(param);
				}
				NameValuePair[] arr = new NameValuePair[list.size()];
				postMethod.setRequestBody(list.toArray(arr));
			}
			int status = 0;
			try {
				status = client.executeMethod(postMethod);
				if (status == 200) {
					return postMethod.getResponseBodyAsString();
				} else {
					log.debug("链接{},HTTP返回status={},参数:{}", url, postMethod.getStatusLine(), map2Str(params));
				}
			} catch (Exception e) {
	            log.debug("发起" + url + " 请求异常，参数:" + map2Str(params), e);
			} finally {
				postMethod.releaseConnection();
			}
		} catch (Exception e) {
            log.error("发起" + url + "请求异常，参数:" + map2Str(params), e);
		}
		return null;
	}
	
	
	/**
	 * GET请求
	 * @param url
	 * @param enc
	 * @return
	 */
	public static String httpClientGet(String url, String enc) {
		HttpClient client = new HttpClient(); 
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, enc);
		client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0,false));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(60000);//指的是连接一个url的连接等待时间  60秒
	    client.getHttpConnectionManager().getParams().setSoTimeout(60000);//指的是连接上一个url，获取response的返回等待时间
		HttpMethod getMethod = new GetMethod(url);
		int status = 0;
		try {
			status = client.executeMethod(getMethod);
			if (status == 200) {
				return getMethod.getResponseBodyAsString();
			} else {
				log.info("链接{},HTTP返回status={},参数:{}", url, getMethod.getStatusLine());
			}
		} catch (Exception e) {
            log.error("发起 " + url + " 请求异常", e);
		} finally {
			getMethod.releaseConnection();
		}
		return null;
	}
	
	public static String map2Str(Map<String, String> params) {
		if(null == params){
			return null;
		}
		StringBuffer url = new StringBuffer();
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			String paramName = entry.getKey();
			String paramValue = entry.getValue();
			if (i == 0) {
				url.append("?");
			} else {
				url.append("&");
			}
			url.append(paramName).append("=").append(paramValue);
			i++;
		}
		return url.toString();
	}
	
}
