/**
 * 
 */
package com.usefullc.platform.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 正则工具类
 * @author tangss
 *
 * @2013年9月2日 @上午10:20:28
 */
public class RegexUtils {

	/**
	 * 替换
	 * @param str
	 * @param paramMap
	 * @return
	 */
	public static String replaceAll(String str,Map<String,String> paramMap){
		Set<Entry<String, String>> set = paramMap.entrySet();
		for(Entry<String, String> entry : set){
			String key = entry.getKey();
			String value = entry.getValue();
			str = str.replaceAll("\\$\\{"+key+"\\}", value);
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "${aa}afdsaf${bb}";
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("aa", "jinshan");
		paramMap.put("bb", "duba");
		String result = replaceAll(str, paramMap);
		System.out.println(result);
				
	}
}
