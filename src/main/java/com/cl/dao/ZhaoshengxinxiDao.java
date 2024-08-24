package com.cl.dao;

import com.cl.entity.ZhaoshengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaoshengxinxiView;


/**
 * 招生信息
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface ZhaoshengxinxiDao extends BaseMapper<ZhaoshengxinxiEntity> {
	
	List<ZhaoshengxinxiView> selectListView(@Param("ew") Wrapper<ZhaoshengxinxiEntity> wrapper);

	List<ZhaoshengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaoshengxinxiEntity> wrapper);
	
	ZhaoshengxinxiView selectView(@Param("ew") Wrapper<ZhaoshengxinxiEntity> wrapper);
	

}
