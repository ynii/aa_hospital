package com.hospital.service;

import java.util.List;

import com.hospital.dao.Dao_user;
import com.hospital.model.Model_user;

public class Service_user {
	
	static Model_user user = new Model_user();
	static Dao_user dao = new Dao_user();
	
	
	//查询数据库，返回list
		public List<Model_user> select_user(){
			return dao.select();
		}
		
	//通过ID找数据，返回一个对象
	public Model_user findUserById(int id){
		return dao.findUserById(id);
	}
	
	//通过用户名找数据，返回一个对象
		public Model_user findUserByName(String name){
			return dao.findUserByName(name);
		}
	
		
	//注册用户,添加数据库
	public int insert(Model_user user){
		if(user!=null){
		return dao.insert(user);
		}
		return 0;
	}
		
	
	//update数据，返回int
	public int update_user(Model_user user){
		return dao.update(user);
	}
	
	//delete 数据，返回int
	public int delete_user(int id){
		return dao.delete(id);
	}
	
	
	
	
}
