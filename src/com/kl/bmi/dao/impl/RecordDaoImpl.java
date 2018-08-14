package com.kl.bmi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.kl.bmi.pojo.Record;
import com.kl.bmi.dao.RecordDao;

import com.kl.bmi.utils.JDBC_Utils;

/**
 * 数据操作层DAO
 * @author 胡家兴
 *
 */
public class RecordDaoImpl implements RecordDao{

	@Override
	public List<Record> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from b";
		Connection connection = JDBC_Utils.getConnection();
		List<Record> records = new ArrayList<>();
		PreparedStatement ps =null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String time = resultSet.getString("time");
				double height = resultSet.getDouble("height");
				double weight = resultSet.getDouble("weight");
				String sex = resultSet.getString("sex");
				double bmi = resultSet.getDouble("bmi");
				double dream_value = resultSet.getDouble("dream_value");
				Record record = new Record(id, time, height, weight, sex, bmi, dream_value);
				records.add(record);
			}
			return records;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询异常！！！");
		}finally {
			JDBC_Utils.close(resultSet, ps, connection);
		}
		
	}

	@Override
	public int deleteById(String rId) {
		// TODO Auto-generated method stub
		String sql = "delete from b where id=?";
		Object[] params = {rId};
		int i = JDBC_Utils.executeUpdate(sql, params);
		return i;
	}

	@Override
	public void addRecord(Record record) {
		// TODO Auto-generated method stub
		String sql ="insert into b(id, time, height, weight, sex, bmi, dream_value) values(?,?,?,?,?,?,?)";
		Object[] params = {record.getId(),record.getTime(),record.getHeight(),record.getWeight(),record.getSex(),record.getBmi(),record.getDream_value()};
	    JDBC_Utils.executeUpdate(sql, params);
	}

}
