package com.rainasmoon.mix;

import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MixTest {

    Logger LOGGER = LoggerFactory.getLogger("MIX");

    public String[] n = new String[] { "老人", "小孩子", "K12", "女人", "宅男", "婴儿", "老外" };
    public String[] b = new String[] { "教育", "英语", "早餐", "洗车", "网赚", "卖花", "超市", "化妆品" };
    public String[] l = new String[] { "国内", "日本", "国外", "第三世界", "农村", "旅游区", "澳大利亚", "新西兰", "办公楼", "小区", "公园" };

    Random rand = new Random();

    @Test
    public void testMix() {

        for (int i = 0; i < 10; i++) {
            LOGGER.info("Great:[" + i + "]:" + createOne());
        }

    }

    private String createOne() {
        int n1 = 0;
        int b1 = 0;
        int l1 = 0;

        n1 = selectRandomeId(n.length);
        b1 = selectRandomeId(b.length);
        l1 = selectRandomeId(l.length);

        return n[n1] + ":" + l[l1] + ":" + b[b1];
    }

    private int selectRandomeId(int length) {

        return rand.nextInt(length);
    }
}
