package ai;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AiTest {
    private static Logger log = LoggerFactory.getLogger("TT:");

    private static final int APP_ID = 1106703112;
    private static final String APP_KEY = "JjoNS14dguVIgyyJ";
    

    @Test
    public void testBase64() throws IOException {

        String str = base64("http://ai.wanlianjin.com/img/ocr/ocr-general-01.jpg");        
        
        log.info("pic : {}", str);
        
        String estr = URLEncoder.encode(str, "UTF-8"); 
        
        log.info("encode base64 img:+\n" + estr);      
        
        String dstr = URLDecoder.decode(estr, "UTF-8");
        
        // save the file
        saveStringToPic(dstr, "D:\\0000.jpg");
        
        log.info("end.");
       

    }
    
    
    
    private void saveStringToPic(String pic, String fileName) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();

        byte[] b = decoder.decodeBuffer(pic);// Base64解码
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {// 调整异常数据
                b[i] += 256;
            }
        }
        // 生成jpeg图片
        OutputStream out = new FileOutputStream(fileName);
        out.write(b);
        out.flush();
        out.close();
    }
    
    @Test
    public void test () {
        parasePic("http://www.tk.cn/sales/pic/product_detail/baiwanyiliao/cpts_bgi_01.jpg");
        parasePic("http://ai.wanlianjin.com/img/ocr/ocr-general-01.jpg");
    }

    public void parasePic(String path) {
        try {
            innerParasPic(path);
        }
        catch(Exception e) {
            log.info("error:" , e);
        }
    }
    
     private void innerParasPic(String path) throws IOException {

        
        Map<String, Object> param = new LinkedHashMap<String, Object>();
        param.put("app_id", APP_ID);
        param.put("image", base64(path));
        param.put("nonce_str", randkey());
        param.put("time_stamp", makeTimeStamp());

        log.info("before sign param　{}" , param);

        URL postUrl = new URL("https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr");

        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.connect();

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String param_str = format(param);
        log.info("POST param: {}" , param_str);
        out.write(param_str.getBytes("UTF-8"));
        out.flush();
        out.close();

        StringBuffer sb = new StringBuffer(); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            sb.append(line);
            line = reader.readLine();
        }

        reader.close();
        connection.disconnect();
        
        
        Map<String, Object> resultMap = JSON.parseObject(sb.toString(), Map.class);
        log.debug("resultMap: {}", resultMap);
        
        if ((Integer)resultMap.get("ret")== 0) {
            Map t1 = (Map)resultMap.get("data");
            List<Map> t2 = (List<Map>)t1.get("item_list");
            for (Map t3 : t2) {
                String t4 = (String)t3.get("itemstring");
                log.info("haha {}", t4);
            }
        }
        else {
            log.info("error {}", resultMap);
        }

    }

    private String base64(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
        httpUrl.setConnectTimeout(50*1000);
        httpUrl.setDoOutput(true);        
        httpUrl.connect();
        
        InputStream in = httpUrl.getInputStream();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        // 使用一个输入流从buffer里把数据读取出来
        while ((len = in.read(buffer)) != -1) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        // 关闭输入流
        in.close();
        // 把outStream里的数据写入内存
        httpUrl.disconnect();
        
        byte[] pic =  outStream.toByteArray();

        BASE64Encoder encoder = new BASE64Encoder();
        String str = encoder.encode(pic);
        
        log.info("size:" + str.length());
        
        if (str.length() > 200000) {
            log.error("pic size is exceed {}", str.length());
        }
        
        return str;
    }

    private long makeTimeStamp() {
        return (long) System.currentTimeMillis() / 1000;
    }

    private String randkey() {

        return RandomStringUtils.randomAlphanumeric(16);
    }

    public static String getSign(String params) throws UnsupportedEncodingException {
        String r = params + "app_key=" + APP_KEY;

        return md5(r).toUpperCase();
    }

    public static String format(Map<String, Object> param) throws UnsupportedEncodingException {
        String params = "";

        for (Object p : param.keySet()) {
            params = params + p + "=" + URLEncoder.encode(param.get(p).toString(), "UTF-8") + "&";
        }
        
        params = params + "sign=" + getSign(params);
        return params;
    }

    private static String md5(String params) {

        return MD5Util.getMD5(params);
    }
}
