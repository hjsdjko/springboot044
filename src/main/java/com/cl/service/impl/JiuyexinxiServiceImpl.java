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


import com.cl.dao.JiuyexinxiDao;
import com.cl.entity.JiuyexinxiEntity;
import com.cl.service.JiuyexinxiService;
import com.cl.entity.view.JiuyexinxiView;

@Service("jiuyexinxiService")
public class JiuyexinxiServiceImpl extends ServiceImpl<JiuyexinxiDao, JiuyexinxiEntity> implements JiuyexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuyexinxiEntity> page = this.selectPage(
                new Query<JiuyexinxiEntity>(params).getPage(),
                new EntityWrapper<JiuyexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuyexinxiEntity> wrapper) {
		  Page<JiuyexinxiView> page =new Query<JiuyexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiuyexinxiView> selectListView(Wrapper<JiuyexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuyexinxiView selectView(Wrapper<JiuyexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
