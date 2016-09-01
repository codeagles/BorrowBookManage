package com.hcn.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;

import com.hcn.db.ReaderTypeDao;
import com.hcn.model.*;
import com.hcn.db.*;

public class ReaderSelectandUpdate extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel selectJP, select_conditionJP, select_resultJP, sexJP,
			updateJP, buttonJP;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton JRB1, JRB2;
	private JLabel IDJL, typeJL, readerNameJL, sexJL, phoneJL, deptJL, regJL,
			ageJL;
	private JTextField select_conditionJTF, IDJTF, ageJTF, readerNameJTF,
			deptJTF, regJTF, phoneJTF;
	private JComboBox conditionJCB, readertypeJCB;
	private JScrollPane jscrollPane;
	// ���������ڴ�Ų�ѯ�����Ķ�����Ϣ
	private JTable jtable;
	private JButton selectJB, updateJB, closeJB;
	// ��Ŷ�����Ϣ���ı�ͷ����
	private String[] readersearch = { "���", "����", "����", "����", "�Ա�", "�绰", "ϵ��",
			"ע������" };

	private Object[][] getSSelect(List<Reader>list){
		Object[][] results = new Object[list.size()][readersearch.length];
		for(int i= 0;i<list.size();i++){
			Reader reader = list.get(i);
			results[i][0] = reader.getReaderid();
			results[i][1] = reader.getTypename();
			results[i][2] = reader.getName();
			results[i][3] = reader.getAge();			
			results[i][4] = reader.getSex();	
			results[i][5] = reader.getPhone();
			results[i][6] = reader.getDept();
			results[i][7] = reader.getRegdate();
		}
		return results;
		
	}

	public ReaderSelectandUpdate() {
		setBounds(400, 100, 500, 500);
		setTitle("������Ϣ��ѯ���޸�");
		// ������Ϣ��ѯ������
		selectJP = new JPanel();
		selectJP.setLayout(new BorderLayout());
		// ��ѯ�������
		// ��ѯ���������б��
		select_conditionJP = new JPanel();
		conditionJCB = new JComboBox();
		String[] array = { "���߱��", "����", "����", "ϵ��" };
		for (int i = 0; i < array.length; i++) {
			conditionJCB.addItem(array[i]);
		}
		select_conditionJP.add(conditionJCB);
		// ��ѯ�����ı���
		select_conditionJTF = new JTextField();
		select_conditionJTF.setColumns(20);
		select_conditionJP.add(select_conditionJTF);
		// ��ѯ��ť
		selectJB = new JButton("��ѯ");
		// selectJB.addActionListener(new SelectAction());
		// selectJB.setText("��ѯ");
		select_conditionJP.add(selectJB);
		selectJP.add(select_conditionJP, BorderLayout.NORTH);
		// ��ѯ������
		select_resultJP = new JPanel();
		jscrollPane = new JScrollPane();
		jscrollPane.setPreferredSize(new Dimension(400, 200));
		Object[][] results = getSSelect(ReaderDao.selectReader());
		jtable = new JTable(results,readersearch);
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jscrollPane.setViewportView(jtable);////������jtable��ΪJScorrllPane����ͼ������ʾ��
		select_resultJP.add(jscrollPane);
		selectJP.add(select_resultJP, BorderLayout.CENTER);
		// ������Ϣ�޸����
		updateJP = new JPanel();
		updateJP.setBorder(new EmptyBorder(5, 10, 5, 10));
		GridLayout gridLayout = new GridLayout(4, 4);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		updateJP.setLayout(gridLayout);
		// ������ű�ǩ���ı�����ӵ�updateJP��
		IDJL = new JLabel("��ţ�  ");
		IDJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(IDJL);
		IDJTF = new JTextField();
		updateJP.add(IDJTF);
		// ����������ǩ���ı�����ӵ�updateJP��
		readerNameJL = new JLabel("������  ");
		readerNameJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(readerNameJL);
		readerNameJTF = new JTextField();
		updateJP.add(readerNameJTF);
		// ��������ǩ�������б����ӵ�updateJP��
		typeJL = new JLabel("���  ");
		typeJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(typeJL);
		// ������������б�
		readertypeJCB = new JComboBox();
		List<ReaderType>list = ReaderTypeDao.selectReaderType();
		for(int i=0;i<list.size();i++)
		{
			ReaderType rt = list.get(i);
			readertypeJCB.addItem(rt.getTypename());
			
		}
		updateJP.add(readertypeJCB);
		// �����Ա��ǩ�Ͱ�ť�����
		sexJL = new JLabel("�Ա� ");
		sexJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(sexJL);
		sexJP = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		sexJP.setLayout(flowLayout);
		updateJP.add(sexJP);
		JRB1 = new JRadioButton();
		JRB1.setText("��");
		sexJP.add(JRB1);
		JRB1.setSelected(true);
		buttonGroup.add(JRB1);
		JRB2 = new JRadioButton();
		JRB2.setText("Ů");
		sexJP.add(JRB2);
		buttonGroup.add(JRB2);
	
		// ���������ǩ���ı�����ӵ�updateJP��
		ageJL = new JLabel("���䣺  ");
		ageJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(ageJL);
		ageJTF = new JTextField();
		updateJP.add(ageJTF);
		// �����绰��ǩ���ı�����ӵ�updateJP��
		phoneJL = new JLabel("�绰��  ");
		phoneJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(phoneJL);
		phoneJTF = new JTextField();
		updateJP.add(phoneJTF);
		// �������ڲ��ű�ǩ���ı�����ӵ�updateJP��
		deptJL = new JLabel("���ڲ��ţ�  ");
		deptJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(deptJL);
		deptJTF = new JTextField();
		updateJP.add(deptJTF);
		// ����ע�����ڱ�ǩ���ı�����ӵ�updateJP��
		regJL = new JLabel("ע�����ڣ�  ");
		regJL.setHorizontalAlignment(SwingConstants.CENTER);
		updateJP.add(regJL);
		regJTF = new JTextField();
		updateJP.add(regJTF);
		// ��ť������
		buttonJP = new JPanel();
		updateJB = new JButton("�޸�");
		closeJB = new JButton("�ر�");
		buttonJP.add(updateJB);
		buttonJP.add(closeJB);
		// �����嵽������
		// ��Ӷ�����Ϣ��ѯ��嵽����ı���
		this.add(buttonJP, BorderLayout.SOUTH);
		this.add(updateJP, BorderLayout.CENTER);
		this.add(selectJP, BorderLayout.NORTH);
		this.setVisible(true);
		setResizable(true);
		closeJB.addActionListener(new CloseActionListener());
		selectJB.addActionListener(new SelectActionListener());
		updateJB.addActionListener(new ReaderUpdActionListener() );
	}
	class JTableListener extends MouseAdapter{
		public void mouseClicked(final MouseEvent e){
			int selRow = jtable.getSelectedRow();
			IDJTF.setText(jtable.getValueAt(selRow, 0).toString().trim());
////////////////////////////////////////////////////////////////////////////////
			readertypeJCB.setSelectedItem(jtable.getValueAt(selRow, 1).toString().trim());
			
			readerNameJTF.setText(jtable.getValueAt(selRow, 2).toString().trim());
			ageJTF.setText(jtable.getValueAt(selRow, 3).toString().trim());
			if(jtable.getValueAt(selRow, 4).toString().trim().equals("��")){
				JRB1.setSelected(true);
			}else{
				JRB2.setSelected(true);
			}
			phoneJTF.setText(jtable.getValueAt(selRow, 5).toString().trim());
			deptJTF.setText(jtable.getValueAt(selRow, 6).toString().trim());
			regJTF.setText(jtable.getValueAt(selRow, 7).toString().trim());
		}
	}
	
	//��������ѯ����
	class SelectActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String condition = (String)conditionJCB.getSelectedItem();
			if(condition.equals("���߱��")){
				Object[][] results =getSSelect(ReaderDao.selectReaderById(select_conditionJTF.getText().trim()));
				jtable = new JTable(results,readersearch);
				jscrollPane.setViewportView(jtable);
				jtable.getTableHeader().setReorderingAllowed(false);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jtable.addMouseListener(new JTableListener());
			}else if(condition.equals("����")){
				Object[][] results = getSSelect(ReaderDao.selectReaderByName(select_conditionJTF.getText().trim()));
				jtable = new JTable(results,readersearch);
				jscrollPane.setViewportView(jtable);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jtable.addMouseListener(new JTableListener());
				
			}else if(condition.equals("����")){
				Object[][] results = getSSelect(ReaderDao.selectReaderByType(select_conditionJTF.getText().trim()));
				jtable = new JTable(results,readersearch);
				jscrollPane.setViewportView(jtable);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jtable.addMouseListener(new JTableListener());
			}else if(condition.equals("ϵ��")){
				Object[][] results = getSSelect(ReaderDao.selectReaderByDept(select_conditionJTF.getText().trim()));
				jtable = new JTable(results,readersearch);
				jscrollPane.setViewportView(jtable);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jtable.addMouseListener(new JTableListener());
			}
			
			
		}
		
	}

	class ReaderUpdActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String id = IDJTF.getText().trim();
			String type = (String)readertypeJCB.getSelectedItem();
			String name = readerNameJTF.getText().trim();
			Integer age = Integer.parseInt(ageJTF.getText().trim());
			String sex = "��";
			if(JRB1.isShowing()){
				sex="Ů";
			}
			String phone = phoneJTF.getText().trim();
			String dept = deptJTF.getText().trim();
			String regdate = regJTF.getText().trim();
			int i = ReaderDao.UpdateReader(id, type,name, age, sex,  phone, dept, regdate);
			if(i==1){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				Object[][] resutls = getSSelect(ReaderDao.selectReader());
				jtable=new JTable(resutls,readersearch);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jtable.addMouseListener(new JTableListener());
				jscrollPane.setViewportView(jtable);
			}
			
		}
	}
	//�رհ�ť
	class CloseActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new ReaderSelectandUpdate();

	}

}
