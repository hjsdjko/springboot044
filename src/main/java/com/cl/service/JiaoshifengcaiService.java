package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoshifengcaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoshifengcaiView;


/**
 * 教师风采
 *
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
public interface JiaoshifengcaiService extends IService<JiaoshifengcaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoshifengcaiView> selectListView(Wrapper<JiaoshifengcaiEntity> wrapper);
   	
   	JiaoshifengcaiView selectView(@Param("ew") Wrapper<JiaoshifengcaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoshifengcaiEntity> wrapper);
   	

}

