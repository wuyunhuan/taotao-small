//package com.taotao.content.test.jedis;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.Test;
//
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//public class TestJedis {
//	@Test
//	public void testJediSingle()
//	{
//		Jedis jedis=new Jedis("192.168.43.48", 6379);
//		jedis.set("user", "we");
//		String userValue=jedis.get("user");
//		System.out.println(userValue);
//		jedis.close();
//	}
//	@Test
//	public void testJedisPool()
//	{
//		JedisPool jedisPool=new JedisPool("192.168.43.48", 6379);
//		Jedis jedis=jedisPool.getResource();
//		jedis.set("password", "123");
//		String passwordValue=jedis.get("password");
//		System.out.println(passwordValue);
//		jedis.close();
//		jedisPool.close();
//	}
//	
//	@Test
//	 public void testJedisCluster() throws IOException
//	 
//	 {
//		 JedisPoolConfig config =new JedisPoolConfig();
//
//		 config.setMaxTotal(100);
//
//		 config.setMaxIdle(50);
//
//		 config.setMinIdle(20);
//
//		 config.setMaxWaitMillis(6 * 1000);
//
//		 config.setTestOnBorrow(true);
//		 
//		Set<HostAndPort> nodes=new HashSet<>();
//		nodes.add(new HostAndPort("127.0.0.1", 7001));
//		nodes.add(new HostAndPort("127.0.0.1", 7002));
//		nodes.add(new HostAndPort("127.0.0.1", 7003));
//		nodes.add(new HostAndPort("127.0.0.1", 7004));
//		nodes.add(new HostAndPort("127.0.0.1", 7005));
//		nodes.add(new HostAndPort("127.0.0.1", 7006));
//		JedisCluster jedisCluster=new JedisCluster(nodes,config);
//		jedisCluster.set("teacher", "4efsdcds");
//		System.out.println(jedisCluster.get("teacher"));
//		jedisCluster.close();
//	 }
	
//}
