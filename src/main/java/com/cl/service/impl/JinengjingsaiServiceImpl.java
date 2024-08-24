package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JinengjingsaiDao;
import com.cl.entity.JinengjingsaiEntity;
import com.cl.service.JinengjingsaiService;
import com.cl.entity.view.JinengjingsaiView;

@Service("jinengjingsaiService")
public class JinengjingsaiServiceImpl extends ServiceImpl<JinengjingsaiDao, JinengjingsaiEntity> implements JinengjingsaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinengjingsaiEntity> page = this.selectPage(
                new Query<JinengjingsaiEntity>(params).getPage(),
                new EntityWrapper<JinengjingsaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinengjingsaiEntity> wrapper) {
		  Page<JinengjingsaiView> page =new Query<JinengjingsaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JinengjingsaiView> selectListView(Wrapper<JinengjingsaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinengjingsaiView selectView(Wrapper<JinengjingsaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
