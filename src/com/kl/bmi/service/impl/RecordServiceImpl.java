package com.kl.bmi.service.impl;

import java.util.*;

import com.kl.bmi.dao.RecordDao;
import com.kl.bmi.dao.impl.RecordDaoImpl;
import com.kl.bmi.pojo.Message;
import com.kl.bmi.pojo.Record;
import com.kl.bmi.service.RecordService;

/**
 * ��¼��ҵ���
 * @author ������
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
				record.setSex("Ů");
				recordss.add(record);
			}
			if (record.getSex().equals("0")) {
				record.setSex("��");
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
			msg.setMsg("ɾ���ɹ�������");
		}else {
			msg.setMsg("ɾ��ʧ�ܣ�");
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
