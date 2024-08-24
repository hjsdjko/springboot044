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

import com.cl.entity.DangjiangongzuoEntity;
import com.cl.entity.view.DangjiangongzuoView;

import com.cl.service.DangjiangongzuoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 党建工作
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@RestController
@RequestMapping("/dangjiangongzuo")
public class DangjiangongzuoController {
    @Autowired
    private DangjiangongzuoService dangjiangongzuoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DangjiangongzuoEntity dangjiangongzuo,
		HttpServletRequest request){
        EntityWrapper<DangjiangongzuoEntity> ew = new EntityWrapper<DangjiangongzuoEntity>();

		PageUtils page = dangjiangongzuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dangjiangongzuo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DangjiangongzuoEntity dangjiangongzuo, 
		HttpServletRequest request){
        EntityWrapper<DangjiangongzuoEntity> ew = new EntityWrapper<DangjiangongzuoEntity>();

		PageUtils page = dangjiangongzuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dangjiangongzuo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DangjiangongzuoEntity dangjiangongzuo){
       	EntityWrapper<DangjiangongzuoEntity> ew = new EntityWrapper<DangjiangongzuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dangjiangongzuo, "dangjiangongzuo")); 
        return R.ok().put("data", dangjiangongzuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DangjiangongzuoEntity dangjiangongzuo){
        EntityWrapper< DangjiangongzuoEntity> ew = new EntityWrapper< DangjiangongzuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dangjiangongzuo, "dangjiangongzuo")); 
		DangjiangongzuoView dangjiangongzuoView =  dangjiangongzuoService.selectView(ew);
		return R.ok("查询党建工作成功").put("data", dangjiangongzuoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DangjiangongzuoEntity dangjiangongzuo = dangjiangongzuoService.selectById(id);
		dangjiangongzuo = dangjiangongzuoService.selectView(new EntityWrapper<DangjiangongzuoEntity>().eq("id", id));
        return R.ok().put("data", dangjiangongzuo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DangjiangongzuoEntity dangjiangongzuo = dangjiangongzuoService.selectById(id);
		dangjiangongzuo = dangjiangongzuoService.selectView(new EntityWrapper<DangjiangongzuoEntity>().eq("id", id));
        return R.ok().put("data", dangjiangongzuo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DangjiangongzuoEntity dangjiangongzuo, HttpServletRequest request){
    	dangjiangongzuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dangjiangongzuo);
        dangjiangongzuoService.insert(dangjiangongzuo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DangjiangongzuoEntity dangjiangongzuo, HttpServletRequest request){
    	dangjiangongzuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dangjiangongzuo);
        dangjiangongzuoService.insert(dangjiangongzuo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DangjiangongzuoEntity dangjiangongzuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dangjiangongzuo);
        dangjiangongzuoService.updateById(dangjiangongzuo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dangjiangongzuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
