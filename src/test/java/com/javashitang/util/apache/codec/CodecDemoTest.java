package com.javashitang.util.apache.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecDemoTest {

    @Test
    public void test1() {
        String encodeStr = Base64.encodeBase64String("test".getBytes());
        System.out.println(encodeStr);
        DigestUtils.md5Hex("test");
    }

}