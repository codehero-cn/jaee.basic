package cn.codehero.jaee.basic.encoding;

import java.io.UnsupportedEncodingException;
/**
 * 字符转换工具类
 * @author eleven
 *
 */
public class GetUtf8 {
	public static String get(String str) {
		
		String newstring="";
		
		try {
			newstring = new String(str.getBytes("iso-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return newstring;
	}
}
