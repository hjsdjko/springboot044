package com.cl.entity.view;

import com.cl.entity.JinengjingsaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 技能竞赛
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 11:07:41
 */
@TableName("jinengjingsai")
public class JinengjingsaiView  extends JinengjingsaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JinengjingsaiView(){
	}
 
 	public JinengjingsaiView(JinengjingsaiEntity jinengjingsaiEntity){
 	try {
			BeanUtils.copyProperties(this, jinengjingsaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
