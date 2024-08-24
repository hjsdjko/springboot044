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


import com.cl.dao.KeyanxinxiDao;
import com.cl.entity.KeyanxinxiEntity;
import com.cl.service.KeyanxinxiService;
import com.cl.entity.view.KeyanxinxiView;

@Service("keyanxinxiService")
public class KeyanxinxiServiceImpl extends ServiceImpl<KeyanxinxiDao, KeyanxinxiEntity> implements KeyanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeyanxinxiEntity> page = this.selectPage(
                new Query<KeyanxinxiEntity>(params).getPage(),
                new EntityWrapper<KeyanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KeyanxinxiEntity> wrapper) {
		  Page<KeyanxinxiView> page =new Query<KeyanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KeyanxinxiView> selectListView(Wrapper<KeyanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KeyanxinxiView selectView(Wrapper<KeyanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
