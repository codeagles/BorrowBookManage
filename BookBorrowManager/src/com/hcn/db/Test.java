package com.hcn.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) {
	//����
//	String sql="insert into booktype values ('10','�����')";
//	int i=Dao.executeUpdate(sql);
//	if(i!=0){
//		System.out.println("success");
//	}else {
//		System.out.println("fail");
//	}
	//��ѯ
	String sql="select * from booktype";
	ResultSet rs=Dao.executeQuery(sql);
	try {
		while(rs.next()){
			System.out.println("idΪ��"+rs.getInt(1)+"  ͼ�����ͣ�"+rs.getString(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
