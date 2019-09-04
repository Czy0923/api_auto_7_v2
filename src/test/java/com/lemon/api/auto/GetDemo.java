package com.lemon.api.auto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class GetDemo {

	@Test
	public static void getDemo1() throws Exception {
		// 填写接口地址
		String url = "http://v.juhe.cn/postcode/query";
		// 准备测试数据
		String postcode = "052560";
		String key = "cff415c31035d637e53dba7ecaa3ae9e";
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postcode);
		params.put("key", key);
		System.out.println(HttpUtil.doGet(url, params));
	}

	public static void main(String[] args) {
		System.out.println("测试代码提交");
	}
}
