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
 * 技能竞赛
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@TableName("jinengjingsai")
public class JinengjingsaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JinengjingsaiEntity() {
		
	}
	
	public JinengjingsaiEntity(T t) {
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
	 * 竞赛名称
	 */
					
	private String jingsaimingcheng;
	
	/**
	 * 竞赛图片
	 */
					
	private String jingsaitupian;
	
	/**
	 * 竞赛人数
	 */
					
	private String jingsairenshu;
	
	/**
	 * 竞赛规则
	 */
					
	private String jingsaiguize;
	
	/**
	 * 竞赛时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jingsaishijian;
	
	/**
	 * 竞赛详情
	 */
					
	private String jingsaixiangqing;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：竞赛名称
	 */
	public void setJingsaimingcheng(String jingsaimingcheng) {
		this.jingsaimingcheng = jingsaimingcheng;
	}
	/**
	 * 获取：竞赛名称
	 */
	public String getJingsaimingcheng() {
		return jingsaimingcheng;
	}
	/**
	 * 设置：竞赛图片
	 */
	public void setJingsaitupian(String jingsaitupian) {
		this.jingsaitupian = jingsaitupian;
	}
	/**
	 * 获取：竞赛图片
	 */
	public String getJingsaitupian() {
		return jingsaitupian;
	}
	/**
	 * 设置：竞赛人数
	 */
	public void setJingsairenshu(String jingsairenshu) {
		this.jingsairenshu = jingsairenshu;
	}
	/**
	 * 获取：竞赛人数
	 */
	public String getJingsairenshu() {
		return jingsairenshu;
	}
	/**
	 * 设置：竞赛规则
	 */
	public void setJingsaiguize(String jingsaiguize) {
		this.jingsaiguize = jingsaiguize;
	}
	/**
	 * 获取：竞赛规则
	 */
	public String getJingsaiguize() {
		return jingsaiguize;
	}
	/**
	 * 设置：竞赛时间
	 */
	public void setJingsaishijian(Date jingsaishijian) {
		this.jingsaishijian = jingsaishijian;
	}
	/**
	 * 获取：竞赛时间
	 */
	public Date getJingsaishijian() {
		return jingsaishijian;
	}
	/**
	 * 设置：竞赛详情
	 */
	public void setJingsaixiangqing(String jingsaixiangqing) {
		this.jingsaixiangqing = jingsaixiangqing;
	}
	/**
	 * 获取：竞赛详情
	 */
	public String getJingsaixiangqing() {
		return jingsaixiangqing;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
