package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
/**
 * 
 * @ClassName ItemService
 * @author wuyunhuan
 * @date 2019/05/14
 */
public interface ItemService {
	/**
	 * 根据page,row 展示商品列表
	 * @param page
	 * @param rows
	 * @return EasyUIDataGridResult
	 */
	EasyUIDataGridResult getItemList(Integer page,Integer rows);
	/**
	 * 添加商品
	 * @param item
	 * @param desc
	 * @return TaotaoResult
	 */
	TaotaoResult saveItem(TbItem item,String desc);
	/**
	 * 根据商品id获取商品
	 * @param itemId
	 * @return TbItem
	 */
	TbItem getItemById(Long itemId);
	/**
	 * 根据商品id获取购物车商品
	 * @param itemId
	 * @return TbItem
	 */
	TbItem getCartItemById(Long itemId);
	/**
	 * 根据商品id获得商品描述
	 * @param itemId
	 * @return TbItemDesc
	 */
	TbItemDesc getItemDescById(Long itemId);
}
