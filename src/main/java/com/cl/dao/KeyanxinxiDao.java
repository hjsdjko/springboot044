package com.cl.dao;

import com.cl.entity.KeyanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanxinxiView;


/**
 * 科研信息
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface KeyanxinxiDao extends BaseMapper<KeyanxinxiEntity> {
	
	List<KeyanxinxiView> selectListView(@Param("ew") Wrapper<KeyanxinxiEntity> wrapper);

	List<KeyanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KeyanxinxiEntity> wrapper);
	
	KeyanxinxiView selectView(@Param("ew") Wrapper<KeyanxinxiEntity> wrapper);
	

}
