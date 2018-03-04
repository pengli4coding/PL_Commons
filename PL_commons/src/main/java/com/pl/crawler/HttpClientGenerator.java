package com.pl.crawler;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientGenerator {
	
	public static CloseableHttpClient generateClient(){
		return HttpClients.createDefault();
	}
}
