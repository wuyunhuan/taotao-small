package com.taotao.mapper;

import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 
 * @ClassName TbContentCategoryMapper
 * @author wuyunhuan
 * @date 2019/05/14
 */
public interface TbContentCategoryMapper {
	/**
	 * 根据example条件统计
	 * @param example
	 * @return int
	 */
    int countByExample(TbContentCategoryExample example);
    /**
     * 根据example删除
     * @param example
     * @return int
     */
    int deleteByExample(TbContentCategoryExample example);
   /**
    * 根据主键id删除
    * @param id
    * @return int
    */
    int deleteByPrimaryKey(Long id);
    /**
     * 添加
     * @param record
     * @return int
     */
    int insert(TbContentCategory record);
    /**
     * 添加被选择的
     * @param record
     * @return int
     */
    int insertSelective(TbContentCategory record);
    /**
     * 根据example查找
     * @param example
     * @return List<TbContentCategory>
     */
    List<TbContentCategory> selectByExample(TbContentCategoryExample example);
    /**
     * 根据主键id查找
     * @param id
     * @return TbContentCategory
     */
    TbContentCategory selectByPrimaryKey(Long id);
    /**
     * 根据被选择example更新
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);
    /**
     * 根据example更新
     * @param record
     * @param example
     * @return int
     */
    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);
    /**
     * 根据被选的主键id更新
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(TbContentCategory record);
    /**
     * 根据主键id更新
     * @param record
     * @return int
     */
    int updateByPrimaryKey(TbContentCategory record);
}