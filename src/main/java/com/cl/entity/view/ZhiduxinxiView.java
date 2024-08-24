package com.cl.entity.view;

import com.cl.entity.ZhiduxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 制度信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@TableName("zhiduxinxi")
public class ZhiduxinxiView  extends ZhiduxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiduxinxiView(){
	}
 
 	public ZhiduxinxiView(ZhiduxinxiEntity zhiduxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhiduxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
