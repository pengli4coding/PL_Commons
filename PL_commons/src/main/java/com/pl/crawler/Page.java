package com.pl.crawler;
/**
 * 
 * @Description:存储页面下载后的结果
 * @author pengli4coding
 * @date 2018年3月4日 下午8:31:52
 */
public class Page {
	
	private String responseContent;

	private int status;

	public Page() {
	}

	public Page(String responseContent, int status) {
		super();
		this.responseContent = responseContent;
		this.status = status;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Page [responseContent=" + responseContent + ", status=" + status + "]";
	}

	
	
	
	
	
}
