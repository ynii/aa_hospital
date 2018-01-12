package com.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import com.hospital.jdbc.Jdbc;
import com.hospital.model.Model_user;

public class Dao_user {
	
	
	static Jdbc jdbc = new Jdbc();
	static Model_user model_user= new Model_user();
	static int i = 0;
	
	//��ѯ���ݿ⣬���ؽ����
	public List<Model_user> select(){
		List<Model_user> list = new ArrayList<Model_user>();
		System.out.println("+++dao��++query++");
		String sql = "select * from user";
		list = jdbc.query(sql);
		return list;
	}
	
	//��ѯ���ݿ� ͨ��ID ��
		public Model_user findUserById(int id){
			List<Model_user> list = new ArrayList<Model_user>();
			System.out.println("+++dao��++findUserById++");
			String sql = "select id,username,password,timestamp from user where id="+id;
			list = jdbc.query(sql);
			if(list.size()>0){
			return  list.get(0);
			}
			return null;
		}
	//��ѯ���ݿ� ͨ���û��� ������һ������
		public Model_user findUserByName(String username){
			List<Model_user> list = new ArrayList<Model_user>();
			
			String sql = "select id,username,password,timestamp from user where username='"+username+"'";
			list = jdbc.query(sql);
			if(list.size()>0){
			return  list.get(0);
			}
			return null;
		}
	
	//�������ݿ⣬����int i
	public int insert(Model_user user){
		System.out.println("+++dao��++add_user++");
		String sql = "insert into user values(null,"+user.getusername()+","+user.getPassword()+","+user.getTimestamp()+")";
		i = jdbc.CUD(sql);
		return i;
	}
	
	//�������ݿ� ������int i;
	public int update(Model_user user){
		System.out.println("+++dao��++update_user++");
		String sql = "update ueser set password="+user.getPassword()+"where id="+user.getId()+"and name="+user.getusername();
		i = jdbc.CUD(sql);
		return i;
	}
	
	//ɾ�����ݿ⣬����int i;
	public int delete(int id){
		System.out.println("+++dao��++delete_user++");
		String sql = "delete from user where id="+id;
		i = jdbc.CUD(sql);
		return i;
	}
	
	
	
	
}
