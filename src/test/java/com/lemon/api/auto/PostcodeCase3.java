package com.lemon.api.auto;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostcodeCase3 {

	/**
	 * postcode:正确 key：正确
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider = "datas")
	public static void postDemo(String postcode, String key) throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		String result = HttpUtil.doPost(url, params);
		System.out.println("返回数据是:" + result);
	}

	@DataProvider(name = "datas")
	public static Object[][] datas() {
		return new Object[][] { 
			{ "052560", "cff415c31035d637e53dba7ecaa3ae9e" }, 
			{ "052560", "" },
			{ "", "cff415c31035d637e53dba7ecaa3ae9e" }, 
			{ "052560", "cff415c31035d" },
			{ "234412", "cff415c31035d637e53dba7ecaa3ae9e" },};
	}
}
