package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XibugaikuangEntity;
import com.cl.entity.view.XibugaikuangView;

import com.cl.service.XibugaikuangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 系部概况
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@RestController
@RequestMapping("/xibugaikuang")
public class XibugaikuangController {
    @Autowired
    private XibugaikuangService xibugaikuangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XibugaikuangEntity xibugaikuang,
		HttpServletRequest request){
        EntityWrapper<XibugaikuangEntity> ew = new EntityWrapper<XibugaikuangEntity>();

		PageUtils page = xibugaikuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xibugaikuang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XibugaikuangEntity xibugaikuang, 
		HttpServletRequest request){
        EntityWrapper<XibugaikuangEntity> ew = new EntityWrapper<XibugaikuangEntity>();

		PageUtils page = xibugaikuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xibugaikuang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XibugaikuangEntity xibugaikuang){
       	EntityWrapper<XibugaikuangEntity> ew = new EntityWrapper<XibugaikuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xibugaikuang, "xibugaikuang")); 
        return R.ok().put("data", xibugaikuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XibugaikuangEntity xibugaikuang){
        EntityWrapper< XibugaikuangEntity> ew = new EntityWrapper< XibugaikuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xibugaikuang, "xibugaikuang")); 
		XibugaikuangView xibugaikuangView =  xibugaikuangService.selectView(ew);
		return R.ok("查询系部概况成功").put("data", xibugaikuangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XibugaikuangEntity xibugaikuang = xibugaikuangService.selectById(id);
		xibugaikuang = xibugaikuangService.selectView(new EntityWrapper<XibugaikuangEntity>().eq("id", id));
        return R.ok().put("data", xibugaikuang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XibugaikuangEntity xibugaikuang = xibugaikuangService.selectById(id);
		xibugaikuang = xibugaikuangService.selectView(new EntityWrapper<XibugaikuangEntity>().eq("id", id));
        return R.ok().put("data", xibugaikuang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XibugaikuangEntity xibugaikuang, HttpServletRequest request){
    	xibugaikuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xibugaikuang);
        xibugaikuangService.insert(xibugaikuang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XibugaikuangEntity xibugaikuang, HttpServletRequest request){
    	xibugaikuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xibugaikuang);
        xibugaikuangService.insert(xibugaikuang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XibugaikuangEntity xibugaikuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xibugaikuang);
        xibugaikuangService.updateById(xibugaikuang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xibugaikuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}