package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DangjiangongzuoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DangjiangongzuoView;


/**
 * 党建工作
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
public interface DangjiangongzuoService extends IService<DangjiangongzuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DangjiangongzuoView> selectListView(Wrapper<DangjiangongzuoEntity> wrapper);
   	
   	DangjiangongzuoView selectView(@Param("ew") Wrapper<DangjiangongzuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DangjiangongzuoEntity> wrapper);
   	

}

