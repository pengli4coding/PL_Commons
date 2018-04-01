package com.pl.test;

import java.io.IOException;

import org.junit.Test;

import com.pl.crawler.Downloader;
import com.pl.crawler.Page;
import com.pl.crawler.Request;

public class TestDownloader {

	@Test
	public void test() {
		try {
			Request request=new Request("http://data.10jqka.com.cn/financial/sgpx/date/2017-12-31/board/ALL/order/asc/page/2/ajax/1/");
			request.addHeader("hexin-v", "AjYzQqcVcEFEJgQlbVAYXXDwh204V3oMzJqu6aAeIaG1cdjdCOfKoZwr_gdz");
			Page page = Downloader.download(request);
			if(page!=null) {
				System.out.println(page);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test1() {
		Request request=new Request();
		System.out.println(request.getHeaders().size());
	}

}
