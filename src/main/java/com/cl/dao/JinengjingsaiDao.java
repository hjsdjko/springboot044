package com.cl.dao;

import com.cl.entity.JinengjingsaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JinengjingsaiView;


/**
 * 技能竞赛
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JinengjingsaiDao extends BaseMapper<JinengjingsaiEntity> {
	
	List<JinengjingsaiView> selectListView(@Param("ew") Wrapper<JinengjingsaiEntity> wrapper);

	List<JinengjingsaiView> selectListView(Pagination page,@Param("ew") Wrapper<JinengjingsaiEntity> wrapper);
	
	JinengjingsaiView selectView(@Param("ew") Wrapper<JinengjingsaiEntity> wrapper);
	

}
