package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaoshengxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaoshengxinxiView;


/**
 * 招生信息
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface ZhaoshengxinxiService extends IService<ZhaoshengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaoshengxinxiView> selectListView(Wrapper<ZhaoshengxinxiEntity> wrapper);
   	
   	ZhaoshengxinxiView selectView(@Param("ew") Wrapper<ZhaoshengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaoshengxinxiEntity> wrapper);
   	

}

