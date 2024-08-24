package com.cl.dao;

import com.cl.entity.DangjiangongzuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DangjiangongzuoView;


/**
 * 党建工作
 * 
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface DangjiangongzuoDao extends BaseMapper<DangjiangongzuoEntity> {
	
	List<DangjiangongzuoView> selectListView(@Param("ew") Wrapper<DangjiangongzuoEntity> wrapper);

	List<DangjiangongzuoView> selectListView(Pagination page,@Param("ew") Wrapper<DangjiangongzuoEntity> wrapper);
	
	DangjiangongzuoView selectView(@Param("ew") Wrapper<DangjiangongzuoEntity> wrapper);
	

}
