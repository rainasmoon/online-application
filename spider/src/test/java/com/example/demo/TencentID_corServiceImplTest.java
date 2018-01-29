package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.TencentID_corService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TencentID_corServiceImplTest {
    @Autowired
    private TencentID_corService tencentID_corService;
   
    @Test
    public void getPhoto_Speak() throws Exception{
//        String str = tencentID_corService.getPhoto_Speak("D:/0000.jpg","本地路径");
        String str2 = tencentID_corService.getPhoto_Speak("http://www.tk.cn/sales/pic/product_detail/baiwanyiliao/cpts_bgi_01.jpg","url路径");
//        System.out.println(str);
        System.out.println(str2);
    }
    
    @Test
    public void getOcrG() throws Exception{
        String str2 = tencentID_corService.parsePic("http://www.tk.cn/sales/include/images/code3.gif");
        System.out.println(str2);
    }
}