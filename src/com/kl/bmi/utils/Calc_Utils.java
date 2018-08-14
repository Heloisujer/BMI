package com.kl.bmi.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

/**
 * 计算BMI工具类及时间格式转化工具
 * @author 胡家兴
 *
 */

public class Calc_Utils {
	
	/**
	 * 计算bmi
	 * @return
	 */
	public static double calcBmi(double height,double weight) {
		
		double bmi = weight / ((height/100) * (height/100));
		DecimalFormat df = new DecimalFormat("#.00");
		String bmi1 = df.format(bmi);
		double bmi2 = Double.valueOf(bmi1);
		return bmi2;	
		
	}
	
	
	/**
	 * 计算理想体重
	 * @param height
	 * @return
	 */
	public static double calcDream(double height) {
		
		double dream = (height-100)*0.9;
		return dream;
		
	}
	
	/**
	 * 获取时间
	 * @return
	 */
	public static String getTime() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		return time;
	}

}
