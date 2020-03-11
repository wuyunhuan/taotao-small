package com.taotao.common.jedis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @ClassName JedisClientCluster
 * @Description TODO
 * @author wuyunhuan
 * @date 2019/05/14
 */

public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Long hdel(String key, String... field) {
		// TODO Auto-generated method stub
		return jedisCluster.hdel(key, field);
	}

	@Override
	public Map<String, String> hgetAll(String key) {

		return jedisCluster.hgetAll(key);
	}

	@Override
	public Long del(String key) {

		return jedisCluster.del(key);
	}

}
