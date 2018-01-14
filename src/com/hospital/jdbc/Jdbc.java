package com.hospital.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.TabableView;

import com.hospital.model.Model_user;

public class Jdbc {
	
	static String url = "jdbc:mysql://localhost:3306/hospital?CharacterEncoding=utf-8" ;
	static String user = "root" ;
	static String password = "root" ;
	
	static Connection cn = null ;
	static Statement st = null ;
	static PreparedStatement pr = null ;
	static ResultSet rs = null ;
	
	
	//��ѯ����  ���� ����� query();
	public List<Model_user> query(String sql){
		List<Model_user> list = new ArrayList<Model_user>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	cn = DriverManager.getConnection(url,user,password);
			cn = DriverManager.getConnection(url, user, password);
			System.out.println("���ӳɹ�.....");
			st = cn.createStatement();
			System.out.println("++++++bbb");
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				list.add(new Model_user(rs.getInt(1) ,rs.getString(2),rs.getString(3),rs.getTimestamp(4)));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	/* ���/����/ɾ�� ���ݿ�������� CUD() */
	public int CUD(String sql){
		System.out.println("--JDBC��--��ɾ�ĵ�һ��--");
		int i = 0;
		try {
			cn = DriverManager.getConnection(url, user, password);
			st = cn.createStatement();
			 i = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--JDBC��--���ؽ��i--"+i);
		return i;
	}
	

	//��ѯ���ݿ� ������
	public Long query_totalCount(String sql){
		long totalCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	cn = DriverManager.getConnection(url,user,password);
			cn = DriverManager.getConnection(url, user, password);
			System.out.println("���ӳɹ�.....");
			st = cn.createStatement();
			System.out.println("++++++bbb");
			rs = st.executeQuery(sql);
			while(rs.next()){
				totalCount = rs.getLong(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
	
}
