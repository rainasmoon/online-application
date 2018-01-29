package com.example.demo.service;

/**
 * Created by yhn on 2017/12/6.
 */
public interface TencentID_corService {   //接口
    String getPhoto_Speak(String url, String method)throws Exception; //看图说话
    //如需扩展接口自行模拟
    
    String parsePic(String url)throws Exception; 
    
    String getOneLine(String url);
}
