package com.javashitang.util.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodecDemoTest {

    @Test
    public void test1() {
        String encodeStr = Base64.encodeBase64String("test".getBytes());
        System.out.println(encodeStr);
        DigestUtils.md5Hex("test");
    }

}