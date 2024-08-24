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

import com.cl.entity.JiaoshifengcaiEntity;
import com.cl.entity.view.JiaoshifengcaiView;

import com.cl.service.JiaoshifengcaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教师风采
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@RestController
@RequestMapping("/jiaoshifengcai")
public class JiaoshifengcaiController {
    @Autowired
    private JiaoshifengcaiService jiaoshifengcaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoshifengcaiEntity jiaoshifengcai,
		HttpServletRequest request){
        EntityWrapper<JiaoshifengcaiEntity> ew = new EntityWrapper<JiaoshifengcaiEntity>();

		PageUtils page = jiaoshifengcaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoshifengcai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoshifengcaiEntity jiaoshifengcai, 
		HttpServletRequest request){
        EntityWrapper<JiaoshifengcaiEntity> ew = new EntityWrapper<JiaoshifengcaiEntity>();

		PageUtils page = jiaoshifengcaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoshifengcai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoshifengcaiEntity jiaoshifengcai){
       	EntityWrapper<JiaoshifengcaiEntity> ew = new EntityWrapper<JiaoshifengcaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoshifengcai, "jiaoshifengcai")); 
        return R.ok().put("data", jiaoshifengcaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoshifengcaiEntity jiaoshifengcai){
        EntityWrapper< JiaoshifengcaiEntity> ew = new EntityWrapper< JiaoshifengcaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoshifengcai, "jiaoshifengcai")); 
		JiaoshifengcaiView jiaoshifengcaiView =  jiaoshifengcaiService.selectView(ew);
		return R.ok("查询教师风采成功").put("data", jiaoshifengcaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoshifengcaiEntity jiaoshifengcai = jiaoshifengcaiService.selectById(id);
		jiaoshifengcai = jiaoshifengcaiService.selectView(new EntityWrapper<JiaoshifengcaiEntity>().eq("id", id));
        return R.ok().put("data", jiaoshifengcai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoshifengcaiEntity jiaoshifengcai = jiaoshifengcaiService.selectById(id);
		jiaoshifengcai = jiaoshifengcaiService.selectView(new EntityWrapper<JiaoshifengcaiEntity>().eq("id", id));
        return R.ok().put("data", jiaoshifengcai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoshifengcaiEntity jiaoshifengcai, HttpServletRequest request){
    	jiaoshifengcai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshifengcai);
        jiaoshifengcaiService.insert(jiaoshifengcai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoshifengcaiEntity jiaoshifengcai, HttpServletRequest request){
    	jiaoshifengcai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoshifengcai);
        jiaoshifengcaiService.insert(jiaoshifengcai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoshifengcaiEntity jiaoshifengcai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoshifengcai);
        jiaoshifengcaiService.updateById(jiaoshifengcai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoshifengcaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
