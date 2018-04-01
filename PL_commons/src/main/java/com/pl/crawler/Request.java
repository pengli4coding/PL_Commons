package com.pl.crawler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description:保存请求参数（包括请求的url地址，请求方法，headers，cookies）的对象
 * @author pengli4coding
 * @date 2018年3月4日 下午8:54:55
 */
public class Request implements Serializable {
	private static final long serialVersionUID = -1116420586207374019L;

	private String url;

	private String method;

	private Map<String, String> cookies = new HashMap<String, String>();

	private Map<String, String> headers = new HashMap<String, String>();

	private String charset;
	
	public void addHeader(String key,String value) {
		this.headers.put(key, value);
	}

	public Request() {
	}
	/**
	 * 
	 * @param url 请求的url
	 */
	public Request(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @param url 请求的url
	 * @param charset 解码字符集
	 */
	public Request(String url, String charset) {
		this.url = url;
		this.charset = charset;
	}

	public Request(String url, String method, Map<String, String> cookies, Map<String, String> headers,
			String charset) {
		this.url = url;
		this.method = method;
		this.cookies = cookies;
		this.headers = headers;
		this.charset = charset;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	@Override
	public String toString() {
		return "Request [url=" + url + ", method=" + method + ", cookies=" + cookies + ", headers=" + headers
				+ ", charset=" + charset + "]";
	}

}
