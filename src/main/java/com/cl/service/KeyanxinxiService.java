package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KeyanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KeyanxinxiView;


/**
 * 科研信息
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface KeyanxinxiService extends IService<KeyanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeyanxinxiView> selectListView(Wrapper<KeyanxinxiEntity> wrapper);
   	
   	KeyanxinxiView selectView(@Param("ew") Wrapper<KeyanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeyanxinxiEntity> wrapper);
   	

}

