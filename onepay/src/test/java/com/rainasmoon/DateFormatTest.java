package com.rainasmoon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rainasmoon.weixin.WeixinTest;

public class DateFormatTest {

    private static final String AFTER = "2017-12-31 12:23:34";

    private static final String BEFORE = "1985-03-12 09:14:52";

    private static Logger LOGGER = LoggerFactory.getLogger(WeixinTest.class);

    private static DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DateFormat sfsafe = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int C = 100;

    @Test
    public void test() throws ParseException {
        LOGGER.info("begin...");
        Date after = sf.parse(AFTER);

        Date before = sf.parse(BEFORE);

        for (int i = 0; i < C; i++) {
            new Thread() {
                @Override
                public void run() {
                    String a = sf.format(after);
                    if (!a.equals(AFTER)) {
                        LOGGER.error("error after: " + AFTER + "\nERROR WeixinTest - " + "error after: " + a + "\n");
                    }
                    String b = sf.format(before);
                    if (!b.equals(BEFORE)) {
                        LOGGER.error("error before:" + BEFORE + "\nERROR WeixinTest - " + "error before:" + b + "\n");
                    }
                }
            }.start();
        }
        LOGGER.info("end.");
    }

    @Test
    public void testSafe() throws ParseException {
        LOGGER.info("begin...");
        Date after = sfsafe.parse(AFTER);

        Date before = sfsafe.parse(BEFORE);

        for (int i = 0; i < C; i++) {
            new Thread() {
                @Override
                public void run() {
                    String a = sfsafe.format(after);
                    if (!a.equals(AFTER)) {
                        LOGGER.error("error after: " + AFTER + "\nERROR WeixinTest - " + "error after: " + a + "\n");
                    }
                    String b = sfsafe.format(before);
                    if (!b.equals(BEFORE)) {
                        LOGGER.error("error before:" + BEFORE + "\nERROR WeixinTest - " + "error before:" + b + "\n");
                    }
                }
            }.start();
        }
        LOGGER.info("end.");
    }
}
