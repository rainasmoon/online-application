package com.example.demo.service.serviceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.enums.MethodEnum;
import com.example.demo.service.TencentID_corService;
import com.example.demo.sign.TencentAISign;
import com.example.demo.sign.TencentAISignSort;
import com.example.demo.utils.Base64Util;
import com.example.demo.utils.HttpsUtil4Tencent;
import com.example.demo.utils.KeyUtil;
import com.example.demo.utils.TencentAPI;
import com.example.demo.utils.UrlMethodUtil;
/**
 * Created by yhn on 2017/12/6.
 */
@Service
@Scope("prototype")
public class TencentID_corServiceImpl implements TencentID_corService {
    
    private static Logger log = LoggerFactory.getLogger(TencentID_corServiceImpl.class);

    
    @Override
    public String getPhoto_Speak(String url,String method) throws Exception {   //看图说话
        //时间戳
        String time_stamp = System.currentTimeMillis()/1000+"";
        byte[] imageData;
        if(method.equals(MethodEnum.url2byte.getMessage())) {
            imageData = UrlMethodUtil.url2byte(url);
        }
        else{
            imageData = UrlMethodUtil.local2byte(url);
        }
        //图片的base64编码数据
        String img64 = Base64Util.encode(imageData);
        //随机字符串
        String nonce_str = TencentAISign.getRandomString(10);
        Map<String,String> body = new HashMap<>();   //【接口属性】（注意修改成自己要的参数）
        body.put("app_id", String.valueOf(TencentAPI.APP_ID_AI));
        body.put("time_stamp",time_stamp);
        body.put("nonce_str", nonce_str);
        body.put("image", img64);
        body.put("session_id", KeyUtil.genUniqueKey());
        String sign = TencentAISignSort.getSignature(body);
        body.put("sign", sign);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse responseBD = HttpsUtil4Tencent.doPostTencentAI(TencentAPI.PHOTO_SPEAK, headers, body);  //【接口调用配置】（记得修改API）
        String json = EntityUtils.toString(responseBD.getEntity());
        return json;
    }

    @Override
    public String parsePic(String url) throws Exception {
      //时间戳
        String time_stamp = System.currentTimeMillis()/1000+"";
        byte[] imageData;
            imageData = UrlMethodUtil.url2byte(url);
       
        //图片的base64编码数据
        String img64 = Base64Util.encode(imageData);
        //随机字符串
        String nonce_str = TencentAISign.getRandomString(10);
        Map<String,String> body = new HashMap<>();   //【接口属性】（注意修改成自己要的参数）
        body.put("app_id", String.valueOf(TencentAPI.APP_ID_AI));
        body.put("time_stamp",time_stamp);
        body.put("nonce_str", nonce_str);
        body.put("image", img64);        
        String sign = TencentAISignSort.getSignature(body);
        body.put("sign", sign);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse responseBD = HttpsUtil4Tencent.doPostTencentAI(TencentAPI.OCR_G, headers, body);  //【接口调用配置】（记得修改API）
        String json = EntityUtils.toString(responseBD.getEntity());
        return json;
    }

    @Override
    public String getOneLine(String url) {
        
        try {
            String reS = parsePic(url);
            
            Map<String, Object> resultMap = JSON.parseObject(reS, Map.class);
            log.debug("resultMap: {}", resultMap);
            String rStr = "";
            if ((Integer)resultMap.get("ret")== 0) {
                Map t1 = (Map)resultMap.get("data");
                List<Map> t2 = (List<Map>)t1.get("item_list");
                for (Map t3 : t2) {
                    String t4 = (String)t3.get("itemstring");
                    rStr = rStr + " ~ " +t4;
                    
                }
            }
            else {
                log.info("error {}", resultMap);
            }
            
            log.info("haha {}", rStr);
            return rStr;
        }
        catch(Exception e) {
            log.info("error:" , e);
        }
        return "ERROR";
    }
}
