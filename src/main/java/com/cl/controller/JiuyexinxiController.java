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

import com.cl.entity.JiuyexinxiEntity;
import com.cl.entity.view.JiuyexinxiView;

import com.cl.service.JiuyexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 就业信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@RestController
@RequestMapping("/jiuyexinxi")
public class JiuyexinxiController {
    @Autowired
    private JiuyexinxiService jiuyexinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuyexinxiEntity jiuyexinxi,
		HttpServletRequest request){
        EntityWrapper<JiuyexinxiEntity> ew = new EntityWrapper<JiuyexinxiEntity>();

		PageUtils page = jiuyexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuyexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuyexinxiEntity jiuyexinxi, 
		HttpServletRequest request){
        EntityWrapper<JiuyexinxiEntity> ew = new EntityWrapper<JiuyexinxiEntity>();

		PageUtils page = jiuyexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuyexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuyexinxiEntity jiuyexinxi){
       	EntityWrapper<JiuyexinxiEntity> ew = new EntityWrapper<JiuyexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuyexinxi, "jiuyexinxi")); 
        return R.ok().put("data", jiuyexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuyexinxiEntity jiuyexinxi){
        EntityWrapper< JiuyexinxiEntity> ew = new EntityWrapper< JiuyexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuyexinxi, "jiuyexinxi")); 
		JiuyexinxiView jiuyexinxiView =  jiuyexinxiService.selectView(ew);
		return R.ok("查询就业信息成功").put("data", jiuyexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuyexinxiEntity jiuyexinxi = jiuyexinxiService.selectById(id);
		jiuyexinxi = jiuyexinxiService.selectView(new EntityWrapper<JiuyexinxiEntity>().eq("id", id));
        return R.ok().put("data", jiuyexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuyexinxiEntity jiuyexinxi = jiuyexinxiService.selectById(id);
		jiuyexinxi = jiuyexinxiService.selectView(new EntityWrapper<JiuyexinxiEntity>().eq("id", id));
        return R.ok().put("data", jiuyexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuyexinxiEntity jiuyexinxi, HttpServletRequest request){
    	jiuyexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuyexinxi);
        jiuyexinxiService.insert(jiuyexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuyexinxiEntity jiuyexinxi, HttpServletRequest request){
    	jiuyexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuyexinxi);
        jiuyexinxiService.insert(jiuyexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiuyexinxiEntity jiuyexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuyexinxi);
        jiuyexinxiService.updateById(jiuyexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuyexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
