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

import com.cl.entity.KeyanxinxiEntity;
import com.cl.entity.view.KeyanxinxiView;

import com.cl.service.KeyanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 科研信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@RestController
@RequestMapping("/keyanxinxi")
public class KeyanxinxiController {
    @Autowired
    private KeyanxinxiService keyanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeyanxinxiEntity keyanxinxi,
		HttpServletRequest request){
        EntityWrapper<KeyanxinxiEntity> ew = new EntityWrapper<KeyanxinxiEntity>();

		PageUtils page = keyanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeyanxinxiEntity keyanxinxi, 
		HttpServletRequest request){
        EntityWrapper<KeyanxinxiEntity> ew = new EntityWrapper<KeyanxinxiEntity>();

		PageUtils page = keyanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeyanxinxiEntity keyanxinxi){
       	EntityWrapper<KeyanxinxiEntity> ew = new EntityWrapper<KeyanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keyanxinxi, "keyanxinxi")); 
        return R.ok().put("data", keyanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeyanxinxiEntity keyanxinxi){
        EntityWrapper< KeyanxinxiEntity> ew = new EntityWrapper< KeyanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keyanxinxi, "keyanxinxi")); 
		KeyanxinxiView keyanxinxiView =  keyanxinxiService.selectView(ew);
		return R.ok("查询科研信息成功").put("data", keyanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeyanxinxiEntity keyanxinxi = keyanxinxiService.selectById(id);
		keyanxinxi = keyanxinxiService.selectView(new EntityWrapper<KeyanxinxiEntity>().eq("id", id));
        return R.ok().put("data", keyanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeyanxinxiEntity keyanxinxi = keyanxinxiService.selectById(id);
		keyanxinxi = keyanxinxiService.selectView(new EntityWrapper<KeyanxinxiEntity>().eq("id", id));
        return R.ok().put("data", keyanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanxinxiEntity keyanxinxi, HttpServletRequest request){
    	keyanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanxinxi);
        keyanxinxiService.insert(keyanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KeyanxinxiEntity keyanxinxi, HttpServletRequest request){
    	keyanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanxinxi);
        keyanxinxiService.insert(keyanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeyanxinxiEntity keyanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keyanxinxi);
        keyanxinxiService.updateById(keyanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keyanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
