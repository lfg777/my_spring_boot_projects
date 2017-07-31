package com.lfg.beans;

import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by lifengguang on 2017/7/28.
 */
@Service
public class RedisReadWriteBean {

    private ShardedJedisPool shardedJedisPool;

    public void write(String key, String value) {

        ShardedJedis jedis = shardedJedisPool.getResource();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            System.out.println(e);
            shardedJedisPool.returnBrokenResource(jedis);
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
    }

    public String read(String key) {

        ShardedJedis jedis = shardedJedisPool.getResource();
        String result = "";
        try {
            result = jedis.get(key);

        } catch (Exception e) {
            System.out.println(e);
            shardedJedisPool.returnBrokenResource(jedis);
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return result;
    }
}
