package com.lemon.api.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 接口调用工具类
 * 
 * @author apple
 *
 */
public class HttpUtil {
	/**
	 * 以get方式处理方法调用
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> params) throws Exception {

		Set<String> keys = params.keySet();
		int mark = 1;
		for (String key : keys) {
			String value = params.get(key);
			if (mark == 1) {
				url += ("?" + key + "=" + value);
			} else {
				url += ("&" + key + "=" + value);
			}
			mark++;
		}
		HttpGet get = new HttpGet(url);
		HttpClient client = HttpClients.createDefault();
		HttpResponse httpresponse = client.execute(get);
		String result = EntityUtils.toString(httpresponse.getEntity());
		return result;
	}

	/**
	 * 以post方式处理方法调用
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> params) throws Exception {

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		// 指定接口请求方式
		HttpPost post = new HttpPost(url);
		Set<String> keys = params.keySet();
		for (String key : keys) {
			String value = params.get(key);
			parameters.add(new BasicNameValuePair(key, value));

		}
		post.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
		// 准备请求头数据(如果有必要，比如Cookie,content-type等)

		// 发起请求，获取接口相应信息(状态码，响应报文，或某些特殊的相应头数据)
		HttpClient client = HttpClients.createDefault();
		HttpResponse httpresponse = client.execute(post);
		String result = EntityUtils.toString(httpresponse.getEntity());
		return result;
	}

}
