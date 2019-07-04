package com.qwer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


public class SignUtil {
	/**
	 * 自然排序
	 * @param paramMap 参数
	 * @param eqStr = 
	 * @param separate &
	 * @return
	 */
	public static String getOrderSignStr(Map<String, String> paramMap, String eqStr, String separate){
		Set<String> keySet = paramMap.keySet();
		List<String> keyList = new ArrayList<>(keySet.size());
		for (String key : keySet) {
			keyList.add(key);
		}
		Collections.sort(keyList);
		StringBuilder sb = new StringBuilder();
		for (String key : keyList) {
			if(isNotNull(paramMap.get(key))){
				sb.append(key+eqStr+paramMap.get(key)+separate);
			}
		}
		return sb.toString(); 
	}
	
	public static boolean isNotNull(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("爱的色放","UTF-8"));;
	}
	
}
