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

import com.cl.entity.ZhiduxinxiEntity;
import com.cl.entity.view.ZhiduxinxiView;

import com.cl.service.ZhiduxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 制度信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@RestController
@RequestMapping("/zhiduxinxi")
public class ZhiduxinxiController {
    @Autowired
    private ZhiduxinxiService zhiduxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiduxinxiEntity zhiduxinxi,
		HttpServletRequest request){
        EntityWrapper<ZhiduxinxiEntity> ew = new EntityWrapper<ZhiduxinxiEntity>();

		PageUtils page = zhiduxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiduxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiduxinxiEntity zhiduxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhiduxinxiEntity> ew = new EntityWrapper<ZhiduxinxiEntity>();

		PageUtils page = zhiduxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiduxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiduxinxiEntity zhiduxinxi){
       	EntityWrapper<ZhiduxinxiEntity> ew = new EntityWrapper<ZhiduxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiduxinxi, "zhiduxinxi")); 
        return R.ok().put("data", zhiduxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiduxinxiEntity zhiduxinxi){
        EntityWrapper< ZhiduxinxiEntity> ew = new EntityWrapper< ZhiduxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiduxinxi, "zhiduxinxi")); 
		ZhiduxinxiView zhiduxinxiView =  zhiduxinxiService.selectView(ew);
		return R.ok("查询制度信息成功").put("data", zhiduxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiduxinxiEntity zhiduxinxi = zhiduxinxiService.selectById(id);
		zhiduxinxi = zhiduxinxiService.selectView(new EntityWrapper<ZhiduxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhiduxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiduxinxiEntity zhiduxinxi = zhiduxinxiService.selectById(id);
		zhiduxinxi = zhiduxinxiService.selectView(new EntityWrapper<ZhiduxinxiEntity>().eq("id", id));
        return R.ok().put("data", zhiduxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiduxinxiEntity zhiduxinxi, HttpServletRequest request){
    	zhiduxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiduxinxi);
        zhiduxinxiService.insert(zhiduxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiduxinxiEntity zhiduxinxi, HttpServletRequest request){
    	zhiduxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiduxinxi);
        zhiduxinxiService.insert(zhiduxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiduxinxiEntity zhiduxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiduxinxi);
        zhiduxinxiService.updateById(zhiduxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiduxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
