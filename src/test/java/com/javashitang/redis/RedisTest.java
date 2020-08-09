package com.javashitang.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author lilimin
 * @since 2020-08-01
 */
public class RedisTest {

    @Test
    public void test1() {
        Jedis jedis = new Jedis("redis01.test.suixinhuan.com", 6379);
        jedis.auth("H8mvJqmDskO12VHa");
        double score = 1596252360000L;
        String auctionId = "427834328362934273";
        jedis.zadd("price-operation-queue", score, auctionId);
    }
}
