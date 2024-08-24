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


import com.cl.dao.XibugaikuangDao;
import com.cl.entity.XibugaikuangEntity;
import com.cl.service.XibugaikuangService;
import com.cl.entity.view.XibugaikuangView;

@Service("xibugaikuangService")
public class XibugaikuangServiceImpl extends ServiceImpl<XibugaikuangDao, XibugaikuangEntity> implements XibugaikuangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XibugaikuangEntity> page = this.selectPage(
                new Query<XibugaikuangEntity>(params).getPage(),
                new EntityWrapper<XibugaikuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XibugaikuangEntity> wrapper) {
		  Page<XibugaikuangView> page =new Query<XibugaikuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XibugaikuangView> selectListView(Wrapper<XibugaikuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XibugaikuangView selectView(Wrapper<XibugaikuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
