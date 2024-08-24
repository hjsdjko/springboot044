package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JinengjingsaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JinengjingsaiView;


/**
 * 技能竞赛
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JinengjingsaiService extends IService<JinengjingsaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinengjingsaiView> selectListView(Wrapper<JinengjingsaiEntity> wrapper);
   	
   	JinengjingsaiView selectView(@Param("ew") Wrapper<JinengjingsaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinengjingsaiEntity> wrapper);
   	

}

