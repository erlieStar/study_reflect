package com.javashitang.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private static JedisPool pool;
    private static Integer maxTotal = 20;
    private static Integer maxIdle = 10;
    private static Integer minIdle = 2;
    private static Boolean testOnBorrow = true;
    private static Boolean testOnReturn = true;

    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);

        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);

        //连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true
        config.setBlockWhenExhausted(true);

        //超时时间是2秒
        pool = new JedisPool(config, "", 6379, 1000 * 2);

    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = pool.getResource();
        jedis.set("mykey", "myvalue");
        System.out.println(jedis.get("mykey"));
        System.out.println("program is end");
    }

}
