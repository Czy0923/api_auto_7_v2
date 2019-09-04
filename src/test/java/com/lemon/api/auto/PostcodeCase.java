package com.lemon.api.auto;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class PostcodeCase {

	/**
	 * postcode:正确 key：正确
	 * 
	 * @throws Exception
	 */
	@Test
	public static void postDemo0() throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		String postcode = "052560";
		String key = "cff415c31035d637e53dba7ecaa3ae9e";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		String result = HttpUtil.doPost(url, params);
		System.out.println(result);
	}

	/**
	 * postcode:为空 key：正确
	 * 
	 * @throws Exception
	 */
	@Test
	public static void postDemo1() throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		String postcode = "";
		String key = "cff415c31035d637e53dba7ecaa3ae9e";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		String result = HttpUtil.doPost(url, params);
		System.out.println(result);
	}

	/**
	 * postcode:正确 key：为空
	 * 
	 * @throws Exception
	 */
	@Test
	public static void postDemo2() throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		String postcode = "052560";
		String key = "";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		String result = HttpUtil.doPost(url, params);
		System.out.println(result);
	}

	/**
	 * postcode:正确 key：长度不够
	 * 
	 * @throws Exception
	 */
	@Test
	public static void postDemo3() throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		String postcode = "052560";
		String key = "cff415c31035d637e";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		String result = HttpUtil.doPost(url, params);
		System.out.println(result);
	}
}
