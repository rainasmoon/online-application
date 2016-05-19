package com.rainasmoon.onepay.util;

import org.junit.Test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class MessageTest {

    private String url = "http://gw.api.taobao.com/router/rest";
    private String appkey = "23368055";
    private String secret = "2e6150177b3c7894bce257b630b82561";

    @Test
    public void test() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("12345");
        req.setSmsType("normal");
        req.setSmsFreeSignName("一元网");
        req.setSmsParamString("{name:'me',code:'123'}");
        req.setRecNum("15811015803");
        req.setSmsTemplateCode("SMS_9595785");
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
