package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	EasyUIDataGridResult getContentList(Integer page,Integer rows,long categoryId);
	TaotaoResult addContent(TbContent content);
	TaotaoResult getContent(long id);
	TaotaoResult updateContent(TbContent content);
	TaotaoResult deleteContent(List<Long> ids);
	List<TbContent> getContentListByCategoryId(long categoryId);
	
}
