package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiuyexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiuyexinxiView;


/**
 * 就业信息
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JiuyexinxiService extends IService<JiuyexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuyexinxiView> selectListView(Wrapper<JiuyexinxiEntity> wrapper);
   	
   	JiuyexinxiView selectView(@Param("ew") Wrapper<JiuyexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuyexinxiEntity> wrapper);
   	

}

