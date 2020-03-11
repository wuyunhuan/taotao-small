package com.taotao.common.jedis;

import java.util.Map;

/**
 * 
 * @ClassName JedisClient
 * @author wuyunhuan
 * @date 2019/05/14
 */
public interface JedisClient {
	/**
	 * 
	 * @param key
	 * @param value
	 * @return String
	 */
	String set(String key, String value);
	/**
	 * 
	 * @param key
	 * @return String
	 */
	String get(String key);
	/**
	 * 
	 * @param key
	 * @return Boolean
	 */
	Boolean exists(String key);
	/**
	 * 
	 * @param key
	 * @param seconds
	 * @return Long
	 */
	Long expire(String key, int seconds);
	/**
	 * 
	 * @param key
	 * @return Long
	 */
	Long ttl(String key);
	/**
	 * 
	 * @param key
	 * @return Long
	 */
	Long incr(String key);
    /**
     * 
     * @param key
     * @param field
     * @param value
     * @return Long
     */
	Long hset(String key, String field, String value);
	/**
	 * 
	 * @param key
	 * @param field
	 * @return String
	 */
	String hget(String key, String field);
	/**
	 * 
	 * @param key
	 * @param field
	 * @return Long
	 */
	Long hdel(String key, String... field);
	/**
	 * 
	 * @param key
	 * @return Map<String,String>
	 */
	Map<String, String> hgetAll(String key);
	/**
	 * 
	 * @param key
	 * @return Long
	 */
	Long del(String key);
}
