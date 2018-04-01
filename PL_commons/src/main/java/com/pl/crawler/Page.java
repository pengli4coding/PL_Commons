package com.pl.crawler;
/**
 * 
 * @Description:存储页面下载后的结果
 * @author pengli4coding
 * @date 2018年3月4日 下午8:31:52
 */
public class Page {
	
	private String responseContent;

	public Page() {
	}

	public Page(String responseContent) {
		super();
		this.responseContent = responseContent;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	@Override
	public String toString() {
		return "Page [responseContent=" + responseContent + "]";
	}
	

	
	
	
	
	
	
}
