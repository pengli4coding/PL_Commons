package com.pl.io;

import java.nio.charset.Charset;

/**
 * 
 * @Description:字符集类
 * @author pengli4coding
 * @date 2018年3月4日 下午12:17:31
 */
public class Charsets {
	/**
	 * 根据给定的字符串（如utf-8,gbk）,获取相应的字符集
	 * @param charset
	 * @return
	 */
    public static Charset toCharset(String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }
    
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
    public static final Charset GBK = Charset.forName("GBK");
    
}
