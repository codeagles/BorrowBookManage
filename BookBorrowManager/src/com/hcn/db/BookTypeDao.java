package com.hcn.db;
import java.sql.*;
import java.util.*;
import com.hcn.model.*;

public class BookTypeDao {
	//��ѯ����ͼ������
	public static List<BookType> selectBookType (){
		List<BookType> list = new ArrayList<BookType>();
		String sql = "select * from booktype";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
			BookType booktype = new BookType();
			booktype.setTypeid(rs.getInt("id"));
			booktype.setTypename(rs.getString("typename"));
			list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	//����ͼ����������ѯͼ��������Ϣ
	public static List<BookType>selectBookTypeByname(String typename){
		List<BookType>list = new ArrayList<BookType>();
		String sql ="select * from booktype where typename like '%"+typename+"%'";
		
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while(rs.next()){
			BookType booktype = new BookType();		
			booktype.setTypeid(rs.getInt("id"));
			booktype.setTypename(rs.getString("typename"));
			
			list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	//���ͼ��������Ϣ
	public static int insertBookType(Integer id,String typename){
		int i =0;
		try {
			String sql = "insert into booktype values("+id+",'"+typename+"')";
			i= Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
	//�޸�ͼ��������Ϣ
	public static int updateBookType(Integer id,String typename){
		int i = 0;
		try {
			String sql = "update booktype set typename ='"+typename+"' where id ="+id+"";
			i = Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
	//
	//ɾ��ͼ�����
	public static int deleteBookType(Integer id){
		int i =0;
		try {
			String sql ="delete from booktype where id="+id+"";
			
			i = Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
}
