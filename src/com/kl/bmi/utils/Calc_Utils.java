package com.kl.bmi.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

/**
 * ����BMI�����༰ʱ���ʽת������
 * @author ������
 *
 */

public class Calc_Utils {
	
	/**
	 * ����bmi
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
	 * ������������
	 * @param height
	 * @return
	 */
	public static double calcDream(double height) {
		
		double dream = (height-100)*0.9;
		return dream;
		
	}
	
	/**
	 * ��ȡʱ��
	 * @return
	 */
	public static String getTime() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		return time;
	}

}
