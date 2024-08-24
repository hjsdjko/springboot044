package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 招生信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@TableName("zhaoshengxinxi")
public class ZhaoshengxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhaoshengxinxiEntity() {
		
	}
	
	public ZhaoshengxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 学校名称
	 */
					
	private String xuexiaomingcheng;
	
	/**
	 * 招生计划
	 */
					
	private String zhaoshengjihua;
	
	/**
	 * 招生专业
	 */
					
	private String zhaoshengzhuanye;
	
	/**
	 * 招生对象
	 */
					
	private String zhaoshengduixiang;
	
	/**
	 * 报名方式
	 */
					
	private String baomingfangshi;
	
	/**
	 * 报名时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baomingshijian;
	
	/**
	 * 学费标准
	 */
					
	private String xuefeibiaozhun;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 招生简章
	 */
					
	private String zhaoshengjianzhang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学校名称
	 */
	public void setXuexiaomingcheng(String xuexiaomingcheng) {
		this.xuexiaomingcheng = xuexiaomingcheng;
	}
	/**
	 * 获取：学校名称
	 */
	public String getXuexiaomingcheng() {
		return xuexiaomingcheng;
	}
	/**
	 * 设置：招生计划
	 */
	public void setZhaoshengjihua(String zhaoshengjihua) {
		this.zhaoshengjihua = zhaoshengjihua;
	}
	/**
	 * 获取：招生计划
	 */
	public String getZhaoshengjihua() {
		return zhaoshengjihua;
	}
	/**
	 * 设置：招生专业
	 */
	public void setZhaoshengzhuanye(String zhaoshengzhuanye) {
		this.zhaoshengzhuanye = zhaoshengzhuanye;
	}
	/**
	 * 获取：招生专业
	 */
	public String getZhaoshengzhuanye() {
		return zhaoshengzhuanye;
	}
	/**
	 * 设置：招生对象
	 */
	public void setZhaoshengduixiang(String zhaoshengduixiang) {
		this.zhaoshengduixiang = zhaoshengduixiang;
	}
	/**
	 * 获取：招生对象
	 */
	public String getZhaoshengduixiang() {
		return zhaoshengduixiang;
	}
	/**
	 * 设置：报名方式
	 */
	public void setBaomingfangshi(String baomingfangshi) {
		this.baomingfangshi = baomingfangshi;
	}
	/**
	 * 获取：报名方式
	 */
	public String getBaomingfangshi() {
		return baomingfangshi;
	}
	/**
	 * 设置：报名时间
	 */
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	/**
	 * 获取：报名时间
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
	}
	/**
	 * 设置：学费标准
	 */
	public void setXuefeibiaozhun(String xuefeibiaozhun) {
		this.xuefeibiaozhun = xuefeibiaozhun;
	}
	/**
	 * 获取：学费标准
	 */
	public String getXuefeibiaozhun() {
		return xuefeibiaozhun;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：招生简章
	 */
	public void setZhaoshengjianzhang(String zhaoshengjianzhang) {
		this.zhaoshengjianzhang = zhaoshengjianzhang;
	}
	/**
	 * 获取：招生简章
	 */
	public String getZhaoshengjianzhang() {
		return zhaoshengjianzhang;
	}

}
