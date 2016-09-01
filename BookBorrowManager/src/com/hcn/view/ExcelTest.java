package com.hcn.view;


import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcn.db.Dao;
import com.hcn.model.Reader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Excel���뵼��
 * 
 * @author �����
 * @version 1.0 2015/1/12 17:52PM
 */
public class ExcelTest {

    /**
     * ����(����������)
     */
    
    public void exportExcel() {
        WritableWorkbook book = null;
        try {
            // ���ļ�
            book = Workbook.createWorkbook(new File("C:/Users/Hou/Desktop/����.xls"));
            // ������Ϊ"�ս���"�Ĺ���������0��ʾ���ǵ�һҳ
            WritableSheet sheet = book.createSheet("�ս���", 0);
            // ָ����Ԫ��λ���ǵ�һ�е�һ��(0, 0)�Լ���Ԫ������Ϊ����
            Label label = new Label(0, 0, "����");
            // ������õĵ�Ԫ����ӵ���������
            sheet.addCell(label);
            // �������ֵĵ�Ԫ�����ʹ��Number��������·��
            jxl.write.Number number = new jxl.write.Number(1, 0, 30);
            sheet.addCell(number);
            // д�����ݲ��ر��ļ�
            book.write();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(book!=null){
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }
    }
    
    /**
     * ��������д�뵽Excel
     */
  private Label str = new Label(0, 0, "asd");
    public void writeExcel() {
        WritableWorkbook book = null;
        try {
            // ���ļ�
            book = Workbook.createWorkbook(new File("C:/Users/Hou/Desktop/stu.xls"));
            // ������Ϊ"�ս���"�Ĺ���������0��ʾ���ǵ�һҳ
            WritableSheet sheet = book.createSheet("�ս���", 0);
            sheet.addCell(str);
            List<Reader> stuList=queryStudentList();
            if(stuList!=null && !stuList.isEmpty()){
                for(int i=1; i<stuList.size(); i++){
                    sheet.addCell(new Label(0, i, stuList.get(i).getName()));
                    sheet.addCell(new Number(1, i, stuList.get(i).getAge()));
                }
            }
            
            // д�����ݲ��ر��ļ�
            book.write();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(book!=null){
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }
    
    }
    private List<Reader> queryStudentList(){
        List<Reader> stuList=new ArrayList<Reader>();
        String sql = "select readerid,type,name,age,sex,phone,dept,regdate,typename,maxborrownum,limit from reader join readertype on reader.type = readertype.id";
		ResultSet rs = Dao.executeQuery(sql);
		try {
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setReaderid(rs.getInt("readerid"));
				reader.setType(rs.getInt("type"));
				reader.setName(rs.getString("name"));
				reader.setAge(rs.getInt("age"));
				reader.setSex(rs.getString("sex"));
				reader.setPhone(rs.getString("phone"));
				reader.setDept(rs.getString("dept"));
				reader.setRegdate(rs.getDate("regdate"));
				reader.setTypename(rs.getString("typename"));
				reader.setMaxborrownum(rs.getInt("maxborrownum"));
				reader.setLimit(rs.getInt("limit"));
				stuList.add(reader);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dao.close();
	
        return stuList;
    }
    public static void main(String[] args){
    	ExcelTest t = new ExcelTest();
    	t.exportExcel();
    }
}