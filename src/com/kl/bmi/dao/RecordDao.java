package com.kl.bmi.dao;

import java.util.List;

import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;

/**
 * 数据操作层Dao接口
 * @author 胡家兴
 *
 */
public interface RecordDao {

	List<Record> findAll();
	int deleteById(String rId);
	void addRecord(Record record);

}
