package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	private List<TbContentCategory> getContentCategoryListByParentId(long id) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		return list;
	}

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		// 1.注入mapper
		// 2.创建example
		TbContentCategoryExample example = new TbContentCategoryExample();
		// 3.设置条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);// select * from tbcontentcategory where parent_id=1
		// 4.执行查询
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		// 5.转成EasyUITreeNode 列表
		//
		List<EasyUITreeNode> nodes = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			node.setText(tbContentCategory.getName());// 分类名称
			nodes.add(node);
		}
		// 6.返回
		return nodes;

	}

	@Override
	public TaotaoResult createContentCategory(long parentId, String name) {
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setIsParent(false);
		tbContentCategory.setParentId(parentId);
		tbContentCategory.setName(name);
		tbContentCategory.setSortOrder(1);
		tbContentCategory.setStatus(1);
		tbContentCategory.setCreated(new Date());
		tbContentCategory.setUpdated(new Date());
		tbContentCategoryMapper.insert(tbContentCategory);
		TbContentCategory parentNode = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			tbContentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		return TaotaoResult.ok(tbContentCategory);
	}

	@Override
	public TaotaoResult updateContentCategory(long id, String name) {
		TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
		tbContentCategory.setName(name);
		tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteContentCategory(long id) {
		TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
		if (tbContentCategory.getIsParent()) {
			List<TbContentCategory> list = getContentCategoryListByParentId(id);
			for (TbContentCategory contentCategory : list) {
				deleteContentCategory(contentCategory.getId());
			}
		}
		if (getContentCategoryListByParentId(tbContentCategory.getParentId()).size() == 1) {
			TbContentCategory parentContentCategory = tbContentCategoryMapper
					.selectByPrimaryKey(tbContentCategory.getParentId());
			parentContentCategory.setIsParent(false);
			tbContentCategoryMapper.updateByPrimaryKey(parentContentCategory);
		}

		tbContentCategoryMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}

}
