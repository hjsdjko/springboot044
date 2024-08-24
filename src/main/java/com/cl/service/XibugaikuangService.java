package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XibugaikuangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XibugaikuangView;


/**
 * 系部概况
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface XibugaikuangService extends IService<XibugaikuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XibugaikuangView> selectListView(Wrapper<XibugaikuangEntity> wrapper);
   	
   	XibugaikuangView selectView(@Param("ew") Wrapper<XibugaikuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XibugaikuangEntity> wrapper);
   	

}

