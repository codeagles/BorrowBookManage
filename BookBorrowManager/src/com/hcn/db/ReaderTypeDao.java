package com.hcn.db;
import java.sql.*;
import java.util.*;
import com.hcn.model.*;

public class ReaderTypeDao {
	//��ѯ�����û�����
	public static List<ReaderType> selectReaderType(){
		List<ReaderType> list = new ArrayList<ReaderType>();
		String sql = "select * from readertype" ;
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
			ReaderType readertype = new ReaderType();
			readertype.setId(rs.getInt("id"));
			readertype.setTypename(rs.getString("typename"));
			readertype.setMaxborrownum(rs.getInt("maxborrownum"));
			readertype.setLimit(rs.getInt("limit"));
			list.add(readertype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	//����ָ���������ͽ��в�ѯ
	public static List<ReaderType> selectType (String type){
		List<ReaderType> list = new ArrayList<ReaderType>();
		String sql = "select * from readertype where typename like '%"+type+"%'" ;
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
			ReaderType readertype = new ReaderType();
			readertype.setId(rs.getInt("id"));
			readertype.setTypename(rs.getString("typename"));
			readertype.setMaxborrownum(rs.getInt("maxborrownum"));
			readertype.setLimit(rs.getInt("limit"));
			list.add(readertype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return list;
	}
	//��Ӷ�������Ϣ
	public static int insertReaderType(Integer id,String typename,Integer num,Integer limit){
		int i =0;
		try {
			String sql = "insert into readertype values("+id+",'"+typename+"',"+num+","+limit+")";
			i= Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
	//�޸Ķ�������
	public static int updateReaderType(Integer id,String typename,Integer num,Integer limit){
		int i = 0;
		try {
			String sql = "update readertype set typename ='"+typename+"',maxborrownum="+num+",limit="+limit+" where id ="+id+"";
			i = Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
	//ɾ���������
	public static int deleteReaderType(Integer id){
		int i =0;
		try {
			String sql ="delete from readertype where id="+id+"";
			i = Dao.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
		return i;
	}
}
