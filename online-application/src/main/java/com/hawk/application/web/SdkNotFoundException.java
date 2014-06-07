package com.hawk.application.web;


public class SdkNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8253284060362715647L;

    public SdkNotFoundException(String sdkId) {
        super(sdkId + "not found");
    }

}
