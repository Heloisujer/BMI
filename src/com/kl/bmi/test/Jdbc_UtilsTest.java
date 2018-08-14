package com.kl.bmi.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.kl.bmi.pojo.Record;
import com.kl.bmi.utils.JDBC_Utils;

/**
 * JDBC工具测试类
 * @author 胡家兴
 *
 */
public class Jdbc_UtilsTest {
	public static void main(String[] args) {
		//执行添加操作
//		   String sql="insert into b(id, time, height, weight, sex, bmi, dream_value) values(?,?,?,?,?,?,?)";
//	       String id=UUID.randomUUID().toString().substring(0, 4);
//		   Object[] params = {id,"2018-06-26",190,80,"0",23,85};
//		   int i = JDBC_Utils.executeUpdate(sql, params);
//		   if (i>0) {
//			System.out.println("添加成功！");
//		   }
        //修改
//		   String sql = "update b set height =? where id=?";
//		   Object[] params = {110,"0001"};
//		   int i = JDBC_Utils.executeUpdate(sql, params);
//		   if (i>0) {
//			System.out.println("修改成功！");
//		   }
		//删除
//		String sql ="delete from b where id=?";
//		Object[] params = {"cda1"};
//		int i = JDBC_Utils.executeUpdate(sql, params);
//		if (i>0) {
//	    System.out.println("删除成功！");
//		}
		//查询
		String sql ="select * from b";
		Connection connection = JDBC_Utils.getConnection();
		PreparedStatement ps = null;
		ResultSet resultSet =null;
	    try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				double height = resultSet.getDouble("height");
				double weight = resultSet.getDouble("weight");
				double bmi = resultSet.getDouble("bmi");
				double dream_value = resultSet.getDouble("dream_value");
				String sex = resultSet.getString("sex");
				String time = resultSet.getString("time");
				Record record = new Record(id, time, height, weight, sex, bmi, dream_value);
				System.out.println(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC_Utils.close(resultSet, ps, connection);
		}
		
	}

}
