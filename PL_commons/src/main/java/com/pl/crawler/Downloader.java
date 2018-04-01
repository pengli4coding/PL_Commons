package com.pl.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @Description:页面下载器
 * @author pengli4coding
 * @date 2018年3月4日 下午8:32:33
 */
public class Downloader {

	private static final String DEFAULT_CHARSET="UTF-8";//默认的页面字符解码为UTF-8
	private static final String DEFAULT_USERAGENT="Mozilla/5.0 (Windows NT 10.0; WOW64; rv:59.0) Gecko/20100101 Firefox/59.0";//默认的浏览器header
	public static Page download(Request request) throws IOException {
		if (request.getUrl() == null) {
			throw new IOException("请求的url为空，请加入请求url");
		}
		CloseableHttpClient httpClient = HttpClientGenerator.generateClient();
		Page page = null;
		try {
			HttpGet httpget = new HttpGet(request.getUrl());
			// 加入headers
			if (request.getHeaders().size() != 0) {
				Map<String, String> headers = request.getHeaders();
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpget.addHeader(entry.getKey(), entry.getValue());
				}
			}
			httpget.addHeader("User-Agent",DEFAULT_USERAGENT);
			// Create a custom response handler
			ResponseHandler<Page> responseHandler = new ResponseHandler<Page>() {

				@Override
				public Page handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						if(status==200) {
							return new Page(EntityUtils.toString(entity, request.getCharset()!=null?request.getCharset():DEFAULT_CHARSET));
						}else {
							throw new IOException("请求不成功，状态码为非200");
						}
					} else {
						throw new IOException("返回的页面内容为空");
					}
				}
			};
			page = httpClient.execute(httpget, responseHandler);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return page;
	}

}
