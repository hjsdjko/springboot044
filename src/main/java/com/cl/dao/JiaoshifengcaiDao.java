package com.cl.dao;

import com.cl.entity.JiaoshifengcaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoshifengcaiView;


/**
 * 教师风采
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JiaoshifengcaiDao extends BaseMapper<JiaoshifengcaiEntity> {
	
	List<JiaoshifengcaiView> selectListView(@Param("ew") Wrapper<JiaoshifengcaiEntity> wrapper);

	List<JiaoshifengcaiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoshifengcaiEntity> wrapper);
	
	JiaoshifengcaiView selectView(@Param("ew") Wrapper<JiaoshifengcaiEntity> wrapper);
	

}
