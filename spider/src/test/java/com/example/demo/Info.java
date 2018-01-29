package com.example.demo;

import java.util.Date;

public class Info {

    private String insurenceCom;

    private String href;

    private String name;

    private String price;

    private String description;

    private String picurl;
    
    private String picStr;
    
    private Date updateDate;

    public Info(String com, String href, String name) {
        super();
        this.insurenceCom = com;
        this.href = href;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[href:" + href + " name:" + name + "]";
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getInsurenceCom() {
        return insurenceCom;
    }

    public void setInsurenceCom(String insurenceCom) {
        this.insurenceCom = insurenceCom;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPicStr() {
        return picStr;
    }

    public void setPicStr(String picStr) {
        this.picStr = picStr;
    }

}
