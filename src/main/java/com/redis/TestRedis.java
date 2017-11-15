package com.redis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class TestRedis {
    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("120.78.197.146",6379);
        //设置值
        jedis.set("java1712","萌萌哒");
        //取值
        String java1712 = jedis.get("java1712");
        System.out.println(java1712);
        //关闭
        jedis.close();
    }
    @Test
    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("120.78.197.146",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("zz","zz");
        String zz = jedis.get("zz");
        jedis.set("zxc","zxcp","nx");
        System.out.println(zz);
        jedis.close();
        /*
        * 我加了很多备注
        * 这是不是啊
        * */

    }

    @Test
    public void testJedisCluster(){
        Set<HostAndPort> set = new HashSet<HostAndPort>();
        set.add(new HostAndPort("120.78.197.146",6381));
        set.add(new HostAndPort("120.78.197.146",6382));
        set.add(new HostAndPort("120.78.197.146",6383));
        set.add(new HostAndPort("120.78.197.146",6384));
        set.add(new HostAndPort("120.78.197.146",6385));
        set.add(new HostAndPort("120.78.197.146",6386));
        JedisCluster  jedisCluster = new JedisCluster(set,10000,10000);
        jedisCluster.set("gwb","加油");
        String gwb = jedisCluster.get("gwb");
        System.out.println(gwb);
        jedisCluster.close();
    }
}
