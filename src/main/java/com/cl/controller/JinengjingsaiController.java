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

import com.cl.entity.JinengjingsaiEntity;
import com.cl.entity.view.JinengjingsaiView;

import com.cl.service.JinengjingsaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 技能竞赛
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@RestController
@RequestMapping("/jinengjingsai")
public class JinengjingsaiController {
    @Autowired
    private JinengjingsaiService jinengjingsaiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinengjingsaiEntity jinengjingsai,
		HttpServletRequest request){
        EntityWrapper<JinengjingsaiEntity> ew = new EntityWrapper<JinengjingsaiEntity>();

		PageUtils page = jinengjingsaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinengjingsai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinengjingsaiEntity jinengjingsai, 
		HttpServletRequest request){
        EntityWrapper<JinengjingsaiEntity> ew = new EntityWrapper<JinengjingsaiEntity>();

		PageUtils page = jinengjingsaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinengjingsai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinengjingsaiEntity jinengjingsai){
       	EntityWrapper<JinengjingsaiEntity> ew = new EntityWrapper<JinengjingsaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinengjingsai, "jinengjingsai")); 
        return R.ok().put("data", jinengjingsaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinengjingsaiEntity jinengjingsai){
        EntityWrapper< JinengjingsaiEntity> ew = new EntityWrapper< JinengjingsaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinengjingsai, "jinengjingsai")); 
		JinengjingsaiView jinengjingsaiView =  jinengjingsaiService.selectView(ew);
		return R.ok("查询技能竞赛成功").put("data", jinengjingsaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinengjingsaiEntity jinengjingsai = jinengjingsaiService.selectById(id);
		jinengjingsai = jinengjingsaiService.selectView(new EntityWrapper<JinengjingsaiEntity>().eq("id", id));
        return R.ok().put("data", jinengjingsai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinengjingsaiEntity jinengjingsai = jinengjingsaiService.selectById(id);
		jinengjingsai = jinengjingsaiService.selectView(new EntityWrapper<JinengjingsaiEntity>().eq("id", id));
        return R.ok().put("data", jinengjingsai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinengjingsaiEntity jinengjingsai, HttpServletRequest request){
    	jinengjingsai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinengjingsai);
        jinengjingsaiService.insert(jinengjingsai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinengjingsaiEntity jinengjingsai, HttpServletRequest request){
    	jinengjingsai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinengjingsai);
        jinengjingsaiService.insert(jinengjingsai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JinengjingsaiEntity jinengjingsai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinengjingsai);
        jinengjingsaiService.updateById(jinengjingsai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinengjingsaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
