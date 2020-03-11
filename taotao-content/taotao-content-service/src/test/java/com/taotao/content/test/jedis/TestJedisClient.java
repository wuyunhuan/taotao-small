//package com.taotao.content.test.jedis;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.taotao.common.jedis.JedisClient;
//
//public class TestJedisClient {
//	@Test
//	public void testJedisClientPool() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:spring/applicationContext-redis.xml");
//		JedisClient jedisClient = context.getBean(JedisClient.class);
//		jedisClient.set("cd23", "ddew");
//		String cdValue = jedisClient.get("cd");
//		System.out.println(cdValue);
//	}
//	@Test
//	public void testJedisClientCluster()
//	{
//	ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
//	JedisClient jedisClient=context.getBean(JedisClient.class);
//	jedisClient.set("wu", "fee");
//	String  wuValue=jedisClient.get("wu");
//	System.out.println(wuValue);
//	 
//	}
//
//}
