package com.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import com.hospital.jdbc.Jdbc;
import com.hospital.model.Model_user;

public class Dao_user {
	
	
	static Jdbc jdbc = new Jdbc();
	static Model_user model_user= new Model_user();
	static int i = 0;
	
	//查询数据库，返回结果集
	public List<Model_user> select(){
		List<Model_user> list = new ArrayList<Model_user>();
		System.out.println("+++dao层++query++");
		String sql = "select * from user";
		list = jdbc.query(sql);
		return list;
	}
	
	//查询数据库 通过ID ，
		public Model_user findUserById(int id){
			List<Model_user> list = new ArrayList<Model_user>();
			System.out.println("+++dao层++findUserById++");
			String sql = "select id,username,password,timestamp from user where id="+id;
			list = jdbc.query(sql);
			if(list.size()>0){
			return  list.get(0);
			}
			return null;
		}
	//查询数据库 通过用户名 ，返回一个对象
		public Model_user findUserByName(String username){
			List<Model_user> list = new ArrayList<Model_user>();
			
			String sql = "select id,username,password,timestamp from user where username='"+username+"'";
			list = jdbc.query(sql);
			if(list.size()>0){
			return  list.get(0);
			}
			return null;
		}
	
	//增添数据库，返回int i
	public int insert(Model_user user){
		System.out.println("+++dao层++add_user++");
		String sql = "insert into user values(null,"+user.getusername()+","+user.getPassword()+","+user.getTimestamp()+")";
		i = jdbc.CUD(sql);
		return i;
	}
	
	//更新数据库 ，返回int i;
	public int update(Model_user user){
		System.out.println("+++dao层++update_user++");
		String sql = "update ueser set password="+user.getPassword()+"where id="+user.getId()+"and name="+user.getusername();
		i = jdbc.CUD(sql);
		return i;
	}
	
	//删除数据库，返回int i;
	public int delete(int id){
		System.out.println("+++dao层++delete_user++");
		String sql = "delete from user where id="+id;
		i = jdbc.CUD(sql);
		return i;
	}
	
	
	
	
}
