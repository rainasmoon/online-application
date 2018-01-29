package com.example.demo.service.serviceImpl;
import com.example.demo.enums.MethodEnum;
import com.example.demo.service.TencentID_corService;
import com.example.demo.sign.TencentAISign;
import com.example.demo.sign.TencentAISignSort;
import com.example.demo.utils.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by yhn on 2017/12/6.
 */
@Service
@Scope("prototype")
public class TencentID_corServiceImpl implements TencentID_corService {
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
}
