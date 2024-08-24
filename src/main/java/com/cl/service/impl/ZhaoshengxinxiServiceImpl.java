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


import com.cl.dao.ZhaoshengxinxiDao;
import com.cl.entity.ZhaoshengxinxiEntity;
import com.cl.service.ZhaoshengxinxiService;
import com.cl.entity.view.ZhaoshengxinxiView;

@Service("zhaoshengxinxiService")
public class ZhaoshengxinxiServiceImpl extends ServiceImpl<ZhaoshengxinxiDao, ZhaoshengxinxiEntity> implements ZhaoshengxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaoshengxinxiEntity> page = this.selectPage(
                new Query<ZhaoshengxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhaoshengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaoshengxinxiEntity> wrapper) {
		  Page<ZhaoshengxinxiView> page =new Query<ZhaoshengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhaoshengxinxiView> selectListView(Wrapper<ZhaoshengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaoshengxinxiView selectView(Wrapper<ZhaoshengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
