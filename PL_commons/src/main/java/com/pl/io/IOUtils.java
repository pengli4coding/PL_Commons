package com.pl.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
	/**
	 * 关闭InputStream这种io流资源
	 * @param input
	 */
	public static void closeQuietly(InputStream input) {
		closeQuietly((Closeable)input);
	}
	
	/**
	 * 关闭io流资源
	 * @param closeable
	 */
	public static void closeQuietly(Closeable closeable) {
		try {
			if(closeable!=null) {
				closeable.close();
			}
		}catch(IOException ioe) {
			//忽略异常
		}
	}


}
