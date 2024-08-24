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


import com.cl.dao.JiaoshifengcaiDao;
import com.cl.entity.JiaoshifengcaiEntity;
import com.cl.service.JiaoshifengcaiService;
import com.cl.entity.view.JiaoshifengcaiView;

@Service("jiaoshifengcaiService")
public class JiaoshifengcaiServiceImpl extends ServiceImpl<JiaoshifengcaiDao, JiaoshifengcaiEntity> implements JiaoshifengcaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoshifengcaiEntity> page = this.selectPage(
                new Query<JiaoshifengcaiEntity>(params).getPage(),
                new EntityWrapper<JiaoshifengcaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoshifengcaiEntity> wrapper) {
		  Page<JiaoshifengcaiView> page =new Query<JiaoshifengcaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoshifengcaiView> selectListView(Wrapper<JiaoshifengcaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoshifengcaiView selectView(Wrapper<JiaoshifengcaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
