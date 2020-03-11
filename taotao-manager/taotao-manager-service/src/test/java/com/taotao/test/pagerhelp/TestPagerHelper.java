package com.taotao.test.pagerhelp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPagerHelper {
//	@Test
//	public void testPagerHelper()
//	{
//		PageHelper.startPage(1, 30);
//		@SuppressWarnings("resource")
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		TbItemMapper itemMapper=applicationContext.getBean(TbItemMapper.class);
//		TbItemExample example=new TbItemExample();
//		List<TbItem> list=itemMapper.selectByExample(example);
//		PageInfo<TbItem> info=new PageInfo<>(list);
//		System.out.println(info.getTotal());
//		System.out.println(info.getSize());
//		
//	}
}
