package com.kl.bmi.service;

import java.util.List;

import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;

/**
 * ��¼��ҵ��ӿ�
 * @author ������
 *
 */
public interface RecordService {

	List<Record> findAll();

	Message deleteById(String rId);

	void addRecord(Record record);
	
}
