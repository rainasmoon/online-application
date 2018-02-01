package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.TencentID_corService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiderTest {
    
    @Autowired
    private TencentID_corService tencentID_corService;

    private static final int TIMEOUT = 0;
    private static Logger log = LoggerFactory.getLogger("T:");

    @Test
    public void testAll() throws Exception {
        List<Info> r = new ArrayList<Info>();

        r.addAll(tickTK());
        r.addAll(tickZA());

        write("D:\\tmp\\me.csv", r);

    }

    @Test
    public void testAnything() {

        log.info(trickReg("s?channelEnName=adbsid&efd=abc", "channelEnName=.*&"));
        log.info(trickReg("s?channelEnName=adbsid", "[channelEnName=].*[&]?"));

        log.info(trickReg("{[\"amount\":\"15000\",\"amount\":\"250\"\"c\":\"15000\"", "\"amount\":\"\\d*\""));

        log.info("abc\r\ncbd".replaceAll("\r|\n", ""));

        for (String s : "def var a = 1; function x(){}".split("var|function")){
            log.info(s);
        }
        
        log.info(maskTKUrl("/pic/123.jpg"));
        log.info(maskTKUrl("//w.p.com/pic/123.jpg"));
        log.info(maskTKUrl("http://www.tk.com/pic/123.jpg"));
            
    }

    private List<Info> tickZA() throws IOException {
        Date now = new Date();
        List<Info> r = new ArrayList<Info>();
        String url = "https://www.zhongan.com/";
        String com = "众安";

        Document mainPage = trickDoc(url);
        
        if (mainPage == null) {
            return Collections.EMPTY_LIST;
        }

        Elements content = mainPage.select("ul.za-main-nav-list");
        // 首页有一些推荐的品种
        Elements links = content.select("a[href].list-item-hd");

        // 一级分类 6个
        for (Element link : links) {
            String linkHref = link.attr("href");
            String name = link.text();

            // 没必要进入频道页, 因为频道里的产品是通过json传递的.

            String channel = trickReg(linkHref, "channelEnName=.*[&]?").replace("channelEnName=", "");
            log.info(channel);

            // 跳过以下channel
            if (channel.equals("onlineindex") || channel.equals("chexian")) {

                continue;
            }

            // 一个频道的产品列表 特色
            String baseUrl = "https://www.zhongan.com/dm/open/cms/CmsScreen/getMaterialList.json?applyChannel=0&channelEnName=";

            String returnMsg = trickJsonStr(baseUrl + channel);

            JSONObject jsonObject = buildJsonObj(returnMsg);

            JSONArray jsonProducts = jsonObject.getJSONArray("jsonObjects");

            if (jsonProducts != null) {
                for (int i = 0; i < jsonProducts.size(); i++) {
                    JSONObject item = jsonProducts.getJSONObject(i);
                    String prodUrl = maskZAUrl(item.getString("adsUrl"));
                    Info info = new Info(com, prodUrl, item.getString("title"));

                    String startingPrice = item.getString("startingPrice");

                    Document productPage = trickDoc(prodUrl);
                    info.setPrice(trickZaPrice(productPage, startingPrice));
                    info.setDescription(trickZaPackage(productPage));

                    String picUrl = trickZaPic(productPage);
                    if (StringUtils.isNotBlank(picUrl)) {
                        info.setPicurl(picUrl);
                        String ss = p_pic_s_zhongan(picUrl);
                        if (StringUtils.isNotBlank(ss)) {
                                                           
                            info.setPicStr(mask2oneLine(ss));
                        }
                    }
                    
                    info.setUpdateDate(now);
                    r.add(info);
                    System.out.println("R:" + info);
                }
            }

        }

        return r;
    }


    private List<Info> tickTK() throws Exception {

        Date now = new Date();
        List<Info> r = new ArrayList<Info>();
        String url = "http://www.tk.cn/";
        String com = "泰康";

        Document mainPage = trickDoc(url);

        // 取得泰康所有产品
        Elements content = mainPage.select("div.shchmenu");
        Elements links = content.select("a[href]");

        // 构建每个产品的数据
        for (Element link : links) {
            String linkHref = link.attr("href");
            String name = link.text();
            Info info = new Info(com, linkHref, name);
            Document productPage = trickDoc(linkHref);
            info.setPrice(trickTkPrice(productPage));
            info.setDescription(trickTkPackage(productPage));
            String picUrl = trickTkPic(productPage);
            if (StringUtils.isNotBlank(picUrl)) {
                
                String ss = p_pic_s_taikang(picUrl);
                info.setPicurl(picUrl);                               
                info.setPicStr(mask2oneLine(ss));
            }
            info.setUpdateDate(now);
            r.add(info);
            System.out.println("R:" + info);
        }

        return r;

    }

    private String p_pic_s_taikang(String picUrl) {
               
        String ss = tencentID_corService.getOneLine(picUrl);
        System.out.println("{********************************************************");
        System.out.println(picUrl);
        System.out.println(ss);
        System.out.println("}********************************************************");
        return ss;
    }
    
    private String p_pic_s_zhongan(String picUrl) {
        String en_pic = picUrl;
        try {
            en_pic = URLEncoder.encode(picUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            
            e.printStackTrace();
        }
        String onePicUrl = trickReg(en_pic, "//static.zhongan.com/.*?\"", true);
        
        if (StringUtils.isBlank(onePicUrl)) {
            log.error("PAY: {}", picUrl );
            return null;
        }
        
        onePicUrl = "https:" + onePicUrl.replaceAll("\"", "");
        
        String ss = tencentID_corService.getOneLine(onePicUrl);
        System.out.println("{********************************************************");
        System.out.println(onePicUrl);
        System.out.println(ss);
        System.out.println("}********************************************************");
        return ss;
    }

    public void write(String filename, List<Info> r) {
        try {
            FileOutputStream out = new FileOutputStream(filename);
            OutputStreamWriter outWriter = new OutputStreamWriter(out, "GBK");
            BufferedWriter bufWrite = new BufferedWriter(outWriter);
            bufWrite.write("序号,保险公司, 保险名称,链接, 价钱, 保障范围,图片, 图片文字,  更新时间\r\n");
            for (int i = 0; i < r.size(); i++) {
                Info info = r.get(i);
                if (info != null) {

                    bufWrite.write(i + "," + info.getInsurenceCom() + "," + info.getName() + "," + info.getHref() + "," + info.getPrice() + "," + info.getDescription() + ","+ info.getPicurl() + ","+ info.getPicStr() + "," + info.getUpdateDate().toString() + "\r\n");
                }
            }
            bufWrite.close();
            outWriter.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取" + filename + "出错！");
        }
    }



    private JSONObject buildJsonObj(String returnMsg) {
        JSONObject jsonObject = JSONObject.parseObject(returnMsg);
        log.info(jsonObject.toJSONString());
        return jsonObject;
    }

    private String trickJsonStr(String aurl) throws IOException {
        URL url = new URL(aurl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

        StringBuffer sb = new StringBuffer();

        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }

        reader.close();
        connection.disconnect();

        String returnMsg = sb.toString();
        log.info(returnMsg);
        
        return returnMsg;
    }

    private Document trickDoc(String href)  {
        Document doc = null ;
        try {
            doc = Jsoup.connect(mask(href)).timeout(TIMEOUT).get();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        return doc;
    }

    private Document trickRedirectDoc(String href) throws IOException {
        Document doc = Jsoup.connect(mask(href)).userAgent("Mozilla").followRedirects(true).timeout(TIMEOUT).post();

        return doc;
    }
    
    private String trickZaPic(Document doc) throws IOException {

        String r = "";
        
        if (StringUtil.isBlank(r)) {

            String prod_info = trickZeroConfig(doc);

                if (prod_info != null) {

                    // log.info(prod_info);
                    prod_info = trickReg(prod_info, "\\[\"//static.zhongan.com/website/assembler/detail/.*\"\\]");

                    System.out.println(prod_info);
                    
                    prod_info = mask2oneLine(prod_info);

                    r = prod_info;
                }
           
        }
        
        
    return r;
}

    private String trickTkPic(Document doc) throws IOException {

      
            Elements content = doc.select("img[src*=/product_detail/]");
            
            String r = "";
            for (Element link : content) {

                String url = link.attr("src");
                
                return maskTKUrl(url);
            }
            
        return "";
    }
    
    private String trickTkPackage(Document doc) throws IOException {

        String r = "";

        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.detailsPackage");
        }

        // 家财险
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.packageList");
        }

        // 年金 种类
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.account-box");
        }

        // 泰康 车险 保障范围
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "ul.car-tit");
        }

        // 含有计算器
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.calculateWidget");
        }

        // 产品详情
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.product-detail-area");
        }

        return "I:" + r;
    }

    @Test
    public void testZaPrice() throws IOException {
        Document productPage = trickDoc("https://www.zhongan.com/p/81779125");
        log.info(trickZaPackage(productPage));
    }

    private String trickZaPrice(Document doc, String startingPrice) throws IOException {

        

        // 健康险
        String r = "";

        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "span.priceShow");
        }

        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.plan-mask-price");
        }

        if (StringUtil.isBlank(r)) {

            String prod_info = trickZeroConfig(doc);

                if (prod_info != null) {

                    // log.info(prod_info);
                    prod_info = trickReg(prod_info, "\\[\\{\"sumInsuredDesc\".*\"\\}\\]");

                    System.out.println(prod_info);
                    
                    prod_info = mask2oneLine(prod_info);

                    r = prod_info;
                }
           
        }
        
        // default price
        if (StringUtil.isBlank(r)) {
            r = startingPrice;
        }


        return "P:" + r;
    }

    private String trickZaPackage(Document doc) throws IOException {

        // 健康险
        String r = "";

        if (StringUtil.isBlank(r)) {
            String prod_info = trickZeroConfig(doc);
            if (prod_info != null) {
                    prod_info = trickReg(prod_info, "\\[\\{\"liabilityDetailData\".*\"\\}\\]");
                    System.out.println(prod_info);

                prod_info = trickPackageSign(prod_info);
                    prod_info = mask2oneLine(prod_info);

                    r = prod_info;
            }
        }

        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.plan-mask-text");
        }

        // default price
        if (StringUtil.isBlank(r)) {
            r = "n/a";
        }

        return "I:" + r;
    }

    private String trickPackageSign(String prod_info) {

        return trickReg(prod_info, "\"amount\":\"\\d*\"");
        
    }

    private String trickZeroConfig(Document doc) {
        Elements scripts = doc.getElementsByTag("script");
        Element zero_config = null;
        for (Element s : scripts) {

            if (s.data().contains("zero_config")) {
                log.info("Yes find the zero config.");
                zero_config = s;
                break;
            }
        }

        if (zero_config != null) {

            String[] vs = zero_config.data().split("var|function");
            String prod_info = null;
            for (int j = 0; j < vs.length; j++) {
                if (vs[j].contains("zero_config")) {
                    prod_info = (vs[j]);
                    break;
                }
            }
            if (prod_info != null) {
                return prod_info.replaceAll("zero_config = ", "");
            }
        }

        return null;
    }


    private String trickTkPrice(Document doc) throws IOException {

        // 健康险
        String r = trickContent(doc, "span.price");

        // 家财险
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "span.priceData");
        }

        // 财产险
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.price");
        }

        // 年金
        if (StringUtil.isBlank(r)) {
            r = trickContent(doc, "div.priceConR");
        }

        return "P:" + r;
    }

    private String trickContent(Document doc, String aclass) {
        Elements content = doc.select(aclass);
        String r = "";
        for (Element link : content) {

            String name = link.text();
            r = r + " - " + name;
        }

        return mask2oneLine(r);
    }

    private String mask2oneLine(String string) {
        if (StringUtils.isBlank(string)) {
            return "[EMPTY]";
        }

        return string.replaceAll(",", "~").replaceAll("\r|\n", "");

    }
    
    private String trickReg(String s, String p) {
        return trickReg(s, p, false);
    }

    private String trickReg(String s, String p, boolean lazy) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(p);
        
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            if (lazy) {
                return m.group();
            }
            sb.append(m.group());
        }
        return sb.toString();
    }

    private String maskZAUrl(String href) {
        
        String r = mask(href);
        
        if (href.trim().startsWith("/")) {
            return "https://www.zhongan.com" + href.trim();
        }
        return r;
    }
    
    private String maskTKUrl(String href) {
        String r = mask(href.trim());
        
        if (r.trim().startsWith("/")) {
            return "http://www.tk.cn" + r.trim();
        }
        
        return r;
        
    }

    private String mask(String href) {
        if (href.trim().startsWith("//")) {
            return "http:" + href.trim();
        }
               
        return href;
    }

}
