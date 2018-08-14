package com.kl.bmi.service.impl;

import java.util.*;

import com.kl.bmi.dao.RecordDao;
import com.kl.bmi.dao.impl.RecordDaoImpl;
import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;
import com.kl.bmi.service.RecordService;

/**
 * 记录的业务层
 * @author 胡家兴
 *
 */
public class RecordServiceImpl implements RecordService{

	@Override
	public List<Record> findAll() {
		// TODO Auto-generated method stub
		RecordDao recordDao = new RecordDaoImpl();
		List<Record> records = recordDao.findAll();
		List<Record> recordss = new ArrayList<>();
		for (Record record : records) {
			if (record.getSex().equals("1")) {
				record.setSex("女");
				recordss.add(record);
			}
			if (record.getSex().equals("0")) {
				record.setSex("男");
				recordss.add(record);
			}
		}
		return recordss; 
	}
	@Override
	public Message deleteById(String rId) {
		Message msg = new Message();
		RecordDao recordDao = new RecordDaoImpl();
		int i = recordDao.deleteById(rId);
		if(i>0) {
			msg.setMsg("删除成功！！！");
		}else {
			msg.setMsg("删除失败！");
		}
			return msg;
	}
	@Override
	public void addRecord(Record record) {
		// TODO Auto-generated method stub
		RecordDao recordDao = new RecordDaoImpl();
		recordDao.addRecord(record);
	}
	
	
}
