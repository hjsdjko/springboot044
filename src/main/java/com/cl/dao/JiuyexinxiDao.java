package com.cl.dao;

import com.cl.entity.JiuyexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiuyexinxiView;


/**
 * 就业信息
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JiuyexinxiDao extends BaseMapper<JiuyexinxiEntity> {
	
	List<JiuyexinxiView> selectListView(@Param("ew") Wrapper<JiuyexinxiEntity> wrapper);

	List<JiuyexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiuyexinxiEntity> wrapper);
	
	JiuyexinxiView selectView(@Param("ew") Wrapper<JiuyexinxiEntity> wrapper);
	

}
