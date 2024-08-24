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


import com.cl.dao.DangjiangongzuoDao;
import com.cl.entity.DangjiangongzuoEntity;
import com.cl.service.DangjiangongzuoService;
import com.cl.entity.view.DangjiangongzuoView;

@Service("dangjiangongzuoService")
public class DangjiangongzuoServiceImpl extends ServiceImpl<DangjiangongzuoDao, DangjiangongzuoEntity> implements DangjiangongzuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DangjiangongzuoEntity> page = this.selectPage(
                new Query<DangjiangongzuoEntity>(params).getPage(),
                new EntityWrapper<DangjiangongzuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DangjiangongzuoEntity> wrapper) {
		  Page<DangjiangongzuoView> page =new Query<DangjiangongzuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DangjiangongzuoView> selectListView(Wrapper<DangjiangongzuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DangjiangongzuoView selectView(Wrapper<DangjiangongzuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
