package com.kl.bmi.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.UUID;

import com.kl.bmi.pojo.Record;

/**
 * 数据库连接测试
 * @author 胡家兴
 *
 */

public class JdbcTest {

	public static void main(String[] args) throws Exception {
		
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接     ctrl+1
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi", "root","root");
		//System.out.println(connection);
		//创建编译对象     
		
		//删除操作
		PreparedStatement ps = connection.prepareStatement("delete from b where id=?");
	    ps.setString(1, "9065");
	    int i = ps.executeUpdate();
	    if (i>0) {
			System.out.println("删除成功！！！");
		}
		
		//修改操作
//		PreparedStatement ps = connection.prepareStatement("update b set height =? where id=?");
//		ps.setDouble(1, 200);
//		ps.setString(2, "9065");
//		int i = ps.executeUpdate();
//		if (i>0) {
//			System.out.println("修改成功！！！");
//		}
		
		//添加操作
//		PreparedStatement ps = connection.prepareStatement("insert into b(id, time, height, weight, sex, bmi, dream_value) values(?,?,?,?,?,?,?)");
//		String id = UUID.randomUUID().toString().substring(0, 4);
//		ps.setString(1, id);
//		ps.setString(2, "2018-6-26");
//		ps.setDouble(3, 170);
//		ps.setDouble(4,50);
//		ps.setString(5, "1");
//		ps.setDouble(6, 22.2);
//		ps.setDouble(7,55);
//		int i = ps.executeUpdate();
//		if (i>0) {
//			System.out.println("添加成功！！！");
//		}
		
		//查询操作     sql注入
		/*PreparedStatement ps = connection.prepareStatement("select * from b");
		//执行sql
		ResultSet  resultSet= ps.executeQuery();
		//处理结果集
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
		//关闭流
		resultSet.close();
		ps.close();
		connection.close();
		*/
	}

}
