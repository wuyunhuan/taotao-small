package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.taotao.pojo.TbContentExample.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.jedis.JedisClient;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	TbContentMapper tbContentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${CONTENT_KEY}")
	private String CONTENT_KEY;

	@Override
	public EasyUIDataGridResult getContentList(Integer page, Integer rows, long categoryId) {
		// 1.设置分页的信息 使用pagehelper
		if (page == null)
			page = 1;
		if (rows == null)
			rows = 20;
		PageHelper.startPage(page, rows);
		// 2.注入mapper
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		// 4.根据mapper调用查询所有数据的方法
		List<TbContent> list = tbContentMapper.selectByExample(example);
		// 5.获取分页的信息
		PageInfo<TbContent> info = new PageInfo<>(list);
		// 6.封装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) info.getTotal());
		result.setRows(info.getList());
		// 7.返回
		return result;

	}

	@Override
	public TaotaoResult addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		tbContentMapper.insert(content);
		try {
			jedisClient.hdel(CONTENT_KEY, content.getCategoryId().toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult getContent(long id) {
		TbContent tbContent = tbContentMapper.selectByPrimaryKey(id);
		String content = tbContent.getContent();
		return TaotaoResult.ok(content);
	}

	@Override
	public TaotaoResult updateContent(TbContent tbContent) {
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		tbContentMapper.updateByPrimaryKeySelective(tbContent);

		try {
			jedisClient.hdel(CONTENT_KEY, tbContent.getCategoryId().toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteContent(List<Long> ids) {
		for (long id : ids) {
			tbContentMapper.deleteByPrimaryKey(id);
		}

		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContentListByCategoryId(long categoryId) {
		try {
			String json = jedisClient.hget(CONTENT_KEY, categoryId + "");
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		TbContentExample tbContentExample = new TbContentExample();
		Criteria criteria = tbContentExample.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = tbContentMapper.selectByExample(tbContentExample);
		try {
			System.out.println("添加缓存");
			jedisClient.hset(CONTENT_KEY, categoryId + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

}
