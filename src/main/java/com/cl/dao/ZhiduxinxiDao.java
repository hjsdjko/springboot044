package com.cl.dao;

import com.cl.entity.ZhiduxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiduxinxiView;


/**
 * 制度信息
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface ZhiduxinxiDao extends BaseMapper<ZhiduxinxiEntity> {
	
	List<ZhiduxinxiView> selectListView(@Param("ew") Wrapper<ZhiduxinxiEntity> wrapper);

	List<ZhiduxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiduxinxiEntity> wrapper);
	
	ZhiduxinxiView selectView(@Param("ew") Wrapper<ZhiduxinxiEntity> wrapper);
	

}
