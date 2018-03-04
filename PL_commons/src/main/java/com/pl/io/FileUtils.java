package com.pl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;


public class FileUtils {
	
	
	public static String readFileToString(File file,Charset encoding) throws IOException{
		InputStream in=null;
		try {
			in=openInputStream(file);
			return "";
		}finally {
			IOUtils.closeQuietly(in); 
		}
	}
	
	public static String readFileToString(File file,String encoding) throws IOException{
		return readFileToString(file,Charsets.toCharset(encoding));
	}
	
    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }
    
	/**
	 * 打开文件的输入流，并对常见的异常做出更加明确的错误提示信息
	 * @param file 
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream openInputStream(File file) throws IOException{
		if(file.exists()) {
			if(file.isDirectory()) {
				throw new IOException("文件 '" + file + "' 是存在的不过它是一个文件夹");
			}
			if(file.canRead()==false) {
				throw new IOException("文件 '" + file + "' 不可读");
			}
		}else {
			throw new FileNotFoundException("文件 '" + file + "' 不存在");
		}
		return new FileInputStream(file);
	}
	
}
