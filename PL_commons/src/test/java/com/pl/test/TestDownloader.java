package com.pl.test;

import java.io.IOException;

import com.pl.crawler.Downloader;
import com.pl.crawler.Page;
import com.pl.crawler.Request;

public class TestDownloader {
	public static void main(String[] args) {
		Request request=new Request();
		request.setUrl("http://www.baidu.com");
		request.setCharset("utf-8");
		Page page=null;
		try {
			page = Downloader.download(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(page.getResponseContent());
		System.out.println();
		System.out.println();
		System.out.println(page.getStatus());
	}
}
