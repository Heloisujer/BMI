package com.kl.bmi.dao;

import java.util.List;

import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;

/**
 * ���ݲ�����Dao�ӿ�
 * @author ������
 *
 */
public interface RecordDao {

	List<Record> findAll();
	int deleteById(String rId);
	void addRecord(Record record);

}
