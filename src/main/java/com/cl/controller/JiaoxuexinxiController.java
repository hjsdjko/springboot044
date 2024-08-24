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

import com.cl.entity.JiaoxuexinxiEntity;
import com.cl.entity.view.JiaoxuexinxiView;

import com.cl.service.JiaoxuexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教学信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@RestController
@RequestMapping("/jiaoxuexinxi")
public class JiaoxuexinxiController {
    @Autowired
    private JiaoxuexinxiService jiaoxuexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoxuexinxiEntity jiaoxuexinxi,
		HttpServletRequest request){
        EntityWrapper<JiaoxuexinxiEntity> ew = new EntityWrapper<JiaoxuexinxiEntity>();

		PageUtils page = jiaoxuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoxuexinxiEntity jiaoxuexinxi, 
		HttpServletRequest request){
        EntityWrapper<JiaoxuexinxiEntity> ew = new EntityWrapper<JiaoxuexinxiEntity>();

		PageUtils page = jiaoxuexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxuexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoxuexinxiEntity jiaoxuexinxi){
       	EntityWrapper<JiaoxuexinxiEntity> ew = new EntityWrapper<JiaoxuexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoxuexinxi, "jiaoxuexinxi")); 
        return R.ok().put("data", jiaoxuexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoxuexinxiEntity jiaoxuexinxi){
        EntityWrapper< JiaoxuexinxiEntity> ew = new EntityWrapper< JiaoxuexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoxuexinxi, "jiaoxuexinxi")); 
		JiaoxuexinxiView jiaoxuexinxiView =  jiaoxuexinxiService.selectView(ew);
		return R.ok("查询教学信息成功").put("data", jiaoxuexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoxuexinxiEntity jiaoxuexinxi = jiaoxuexinxiService.selectById(id);
		jiaoxuexinxi = jiaoxuexinxiService.selectView(new EntityWrapper<JiaoxuexinxiEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoxuexinxiEntity jiaoxuexinxi = jiaoxuexinxiService.selectById(id);
		jiaoxuexinxi = jiaoxuexinxiService.selectView(new EntityWrapper<JiaoxuexinxiEntity>().eq("id", id));
        return R.ok().put("data", jiaoxuexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxuexinxiEntity jiaoxuexinxi, HttpServletRequest request){
    	jiaoxuexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuexinxi);
        jiaoxuexinxiService.insert(jiaoxuexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxuexinxiEntity jiaoxuexinxi, HttpServletRequest request){
    	jiaoxuexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxuexinxi);
        jiaoxuexinxiService.insert(jiaoxuexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoxuexinxiEntity jiaoxuexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoxuexinxi);
        jiaoxuexinxiService.updateById(jiaoxuexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoxuexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
