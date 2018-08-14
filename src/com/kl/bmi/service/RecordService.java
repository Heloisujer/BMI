package com.kl.bmi.service;

import java.util.List;

import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;

/**
 * 记录的业务接口
 * @author 胡家兴
 *
 */
public interface RecordService {

	List<Record> findAll();

	Message deleteById(String rId);

	void addRecord(Record record);
	
}
