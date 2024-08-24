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


import com.cl.dao.ZhiduxinxiDao;
import com.cl.entity.ZhiduxinxiEntity;
import com.cl.service.ZhiduxinxiService;
import com.cl.entity.view.ZhiduxinxiView;

@Service("zhiduxinxiService")
public class ZhiduxinxiServiceImpl extends ServiceImpl<ZhiduxinxiDao, ZhiduxinxiEntity> implements ZhiduxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiduxinxiEntity> page = this.selectPage(
                new Query<ZhiduxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhiduxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiduxinxiEntity> wrapper) {
		  Page<ZhiduxinxiView> page =new Query<ZhiduxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiduxinxiView> selectListView(Wrapper<ZhiduxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiduxinxiView selectView(Wrapper<ZhiduxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
