package com.pl.crawler;

import java.io.IOException;
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
	public static Page download(Request request) throws IOException {
		if (request.getUrl() == null || request.getCharset() == null) {
			return null;
		}
		CloseableHttpClient httpClient = HttpClientGenerator.generateClient();
		Page page = null;
		try {
			HttpGet httpget = new HttpGet(request.getUrl());
			// 加入headers
			if (request.getHeaders() != null) {
				Map<String, String> headers = request.getHeaders();
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					httpget.addHeader(entry.getKey(), entry.getValue());
				}
			}
			// Create a custom response handler
			ResponseHandler<Page> responseHandler = new ResponseHandler<Page>() {

				@Override
				public Page handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						return new Page(EntityUtils.toString(entity, request.getCharset()), status);
					} else {
						return null;
					}
				}
			};

			try {
				page = httpClient.execute(httpget, responseHandler);
			} catch (IOException e) {
				throw new IOException("调用httpClient.execute()的时候发生异常");
			}

		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				throw new IOException("调用httpClient.close()的时候发生异常");
			}
		}
		return page;
	}

}
