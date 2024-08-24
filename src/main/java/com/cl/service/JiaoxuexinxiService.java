package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoxuexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxuexinxiView;


/**
 * 教学信息
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface JiaoxuexinxiService extends IService<JiaoxuexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxuexinxiView> selectListView(Wrapper<JiaoxuexinxiEntity> wrapper);
   	
   	JiaoxuexinxiView selectView(@Param("ew") Wrapper<JiaoxuexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxuexinxiEntity> wrapper);
   	

}

