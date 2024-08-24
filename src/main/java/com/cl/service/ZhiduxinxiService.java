package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiduxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiduxinxiView;


/**
 * 制度信息
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface ZhiduxinxiService extends IService<ZhiduxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiduxinxiView> selectListView(Wrapper<ZhiduxinxiEntity> wrapper);
   	
   	ZhiduxinxiView selectView(@Param("ew") Wrapper<ZhiduxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiduxinxiEntity> wrapper);
   	

}

