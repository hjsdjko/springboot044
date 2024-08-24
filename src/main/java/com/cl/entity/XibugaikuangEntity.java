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
 * 系部概况
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@TableName("xibugaikuang")
public class XibugaikuangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XibugaikuangEntity() {
		
	}
	
	public XibugaikuangEntity(T t) {
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
	 * 系部名称
	 */
					
	private String xibumingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 系部详情
	 */
					
	private String xibuxiangqing;
	
	/**
	 * 专业简介
	 */
					
	private String zhuanyejianjie;
	
	/**
	 * 基本情况
	 */
					
	private String jibenqingkuang;
	
	/**
	 * 培养目标
	 */
					
	private String peiyangmubiao;
	
	
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
	 * 设置：系部名称
	 */
	public void setXibumingcheng(String xibumingcheng) {
		this.xibumingcheng = xibumingcheng;
	}
	/**
	 * 获取：系部名称
	 */
	public String getXibumingcheng() {
		return xibumingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：系部详情
	 */
	public void setXibuxiangqing(String xibuxiangqing) {
		this.xibuxiangqing = xibuxiangqing;
	}
	/**
	 * 获取：系部详情
	 */
	public String getXibuxiangqing() {
		return xibuxiangqing;
	}
	/**
	 * 设置：专业简介
	 */
	public void setZhuanyejianjie(String zhuanyejianjie) {
		this.zhuanyejianjie = zhuanyejianjie;
	}
	/**
	 * 获取：专业简介
	 */
	public String getZhuanyejianjie() {
		return zhuanyejianjie;
	}
	/**
	 * 设置：基本情况
	 */
	public void setJibenqingkuang(String jibenqingkuang) {
		this.jibenqingkuang = jibenqingkuang;
	}
	/**
	 * 获取：基本情况
	 */
	public String getJibenqingkuang() {
		return jibenqingkuang;
	}
	/**
	 * 设置：培养目标
	 */
	public void setPeiyangmubiao(String peiyangmubiao) {
		this.peiyangmubiao = peiyangmubiao;
	}
	/**
	 * 获取：培养目标
	 */
	public String getPeiyangmubiao() {
		return peiyangmubiao;
	}

}
