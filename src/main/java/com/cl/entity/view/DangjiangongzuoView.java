package com.cl.entity.view;

import com.cl.entity.DangjiangongzuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 党建工作
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:40
 */
@TableName("dangjiangongzuo")
public class DangjiangongzuoView  extends DangjiangongzuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DangjiangongzuoView(){
	}
 
 	public DangjiangongzuoView(DangjiangongzuoEntity dangjiangongzuoEntity){
 	try {
			BeanUtils.copyProperties(this, dangjiangongzuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
