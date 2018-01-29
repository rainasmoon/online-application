package ai;

import java.security.MessageDigest;

/** 
 * message-digest algorithm 5（信息-摘要算法） 
 *  
 * md5的长度，默认为128bit，也就是128个 0和1的 二进制串 。 
 *  
 * 128/4 = 32 换成 16进制 表示后，为32位了。 
 */  
public class MD5Util {  
  
    // 测试方法  
    public static void main(String[] args) {  
	    String pwd = "a=1&b=2&c=3";  
	    System.out.println("加密前： " + pwd);  
	    System.err.println("加密后： " + MD5Util.getMD5(pwd));  
	    
	    String str = "app_id=10001& nonce=dsFf3onU9gdf&sn=MvGiGP7iPtPCGeLjiDnE7bWmc%2F7sVSxoqezzGAD7i2hMl6zsg6xAzuOzF4gWk1Gw&timestamp=1515041908349&text=%E6%82%A8%E7%9A%84%E5%93%81%E7%89%8C%E5%9E%8B%E5%8F%B7%E6%98%AF%EF%BC%9F&app_key=12345678qwertyuiasdfghjk";
	    System.err.println("加密后： " + MD5Util.getMD5(str)); 
    }  
  
    /** 
     * 生成md5 
     *  
     * @param message 
     * @return 
     */  
    public static String getMD5(String message) {  
    String md5str = "";  
    try {  
        // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象  
        MessageDigest md = MessageDigest.getInstance("MD5");  
  
        // 2 将消息变成byte数组  
        byte[] input = message.getBytes();  
  
        // 3 计算后获得字节数组,这就是那128位了  
        byte[] buff = md.digest(input);  
  
        // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串  
        md5str = bytesToHex(buff);  
  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
    return md5str;  
    }  
  
    /** 
     * 二进制转十六进制 
     *  
     * @param bytes 
     * @return 
     */  
    public static String bytesToHex(byte[] bytes) {  
    StringBuffer md5str = new StringBuffer();  
    // 把数组每一字节换成16进制连成md5字符串  
    int digital;  
    for (int i = 0; i < bytes.length; i++) {  
        digital = bytes[i];  
  
        if (digital < 0) {  
        digital += 256;  
        }  
        if (digital < 16) {  
        md5str.append("0");  
        }  
        md5str.append(Integer.toHexString(digital));  
    }  
    return md5str.toString().toUpperCase();  
    }  
}  
