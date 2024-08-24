package com.cl.dao;

import com.cl.entity.JiaoxuexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuexinxiView;


/**
 * 教学信息
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface JiaoxuexinxiDao extends BaseMapper<JiaoxuexinxiEntity> {
	
	List<JiaoxuexinxiView> selectListView(@Param("ew") Wrapper<JiaoxuexinxiEntity> wrapper);

	List<JiaoxuexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxuexinxiEntity> wrapper);
	
	JiaoxuexinxiView selectView(@Param("ew") Wrapper<JiaoxuexinxiEntity> wrapper);
	

}
