package com.cl.dao;

import com.cl.entity.XibugaikuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XibugaikuangView;


/**
 * 系部概况
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface XibugaikuangDao extends BaseMapper<XibugaikuangEntity> {
	
	List<XibugaikuangView> selectListView(@Param("ew") Wrapper<XibugaikuangEntity> wrapper);

	List<XibugaikuangView> selectListView(Pagination page,@Param("ew") Wrapper<XibugaikuangEntity> wrapper);
	
	XibugaikuangView selectView(@Param("ew") Wrapper<XibugaikuangEntity> wrapper);
	

}
