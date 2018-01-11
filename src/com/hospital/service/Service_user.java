package com.hospital.service;

import java.util.List;

import com.hospital.dao.Dao_user;
import com.hospital.model.Model_user;

public class Service_user {
	
	static Model_user user = new Model_user();
	static Dao_user dao = new Dao_user();
	
	
	//��ѯ���ݿ⣬����list
		public List<Model_user> select_user(){
			return dao.select();
		}
		
	//ͨ��ID�����ݣ�����һ������
	public Model_user findUserById(int id){
		return dao.findUserById(id);
	}
	
	//ͨ���û��������ݣ�����һ������
		public Model_user findUserByName(String name){
			return dao.findUserByName(name);
		}
	
		
	//ע���û�,������ݿ�
	public int insert(Model_user user){
		if(user!=null){
		return dao.insert(user);
		}
		return 0;
	}
		
	
	//update���ݣ�����int
	public int update_user(Model_user user){
		return dao.update(user);
	}
	
	//delete ���ݣ�����int
	public int delete_user(int id){
		return dao.delete(id);
	}
	
	
	
	
}
