package com.hcn.view;

import javax.swing.*;

import com.hcn.db.ReaderTypeDao;
import com.hcn.model.ReaderType;
import com.hcn.view.ReaderSelectandUpdate.JTableListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;

public class ReaderManager extends JFrame {
	private JPanel select_conditionJP, select_resultJP, selectJP, manageJP,
			buttonJP;
	private JLabel readercategroyJL, readerIDJL, readercategroyNameJL,
			bookNumberJL, bookTimeJL;
	private JScrollPane jscrollPane;
	private JTable jtable;
	private JButton selectJB, addJB, updateJB, deleteJB, exitJB;
	private JTextField readercategroyJTF, readerIDJTF, readercategroyNameJTF,
			bookNumberJTF, bookTimeJTF;
	private String[] readertyperearch = { "�������ͱ��", "������������", "�ɽ�ͼ������",
			"�ɽ�ͼ������" };

	private Object[][] getSSelect(List<ReaderType> list) {
		Object[][] results = new Object[list.size()][readertyperearch.length];
		for (int i = 0; i < list.size(); i++) {
			ReaderType readertype = list.get(i);
			results[i][0] = readertype.getId();
			results[i][1] = readertype.getTypename();
			results[i][2] = readertype.getMaxborrownum();
			results[i][3] = readertype.getLimit();
		}
		return results;
	}

	public ReaderManager() {
		setBounds(300, 100, 600, 400);
		setTitle("�������͹���");
		// �����������
		selectJP = new JPanel();
		selectJP.setLayout(new BorderLayout());
		manageJP = new JPanel();
		manageJP.setLayout(new GridLayout(2, 4));
		buttonJP = new JPanel();
		// ������ѯ������
		select_conditionJP = new JPanel();
		// select_conditionJP.setLayout(new GridLayout(1,3));
		readercategroyJL = new JLabel("�������ͣ�  ");
		readercategroyJL.setHorizontalAlignment(SwingConstants.CENTER);
		readercategroyJTF = new JTextField();
		readercategroyJTF.setColumns(20);
		selectJB = new JButton("��ѯ");
		select_conditionJP.add(readercategroyJL);
		select_conditionJP.add(readercategroyJTF);
		select_conditionJP.add(selectJB);
		selectJP.add(select_conditionJP, BorderLayout.NORTH);
		// ����������
		select_resultJP = new JPanel();
		jscrollPane = new JScrollPane();
		jscrollPane.setPreferredSize(new Dimension(400, 200));
		Object[][] results = getSSelect(ReaderTypeDao.selectReaderType());

		jtable = new JTable(results, readertyperearch);
		jscrollPane.setViewportView(jtable);
		// �û�����ͨ��������ƶ���ͷ
		jtable.getTableHeader().setReorderingAllowed(false);

		// �������û�������ͨ���������table��ͷ���϶����ı�����еĿ�ȡ�
		// jtable.getTableHeader().setResizingAllowed(true) ;

		//jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		select_resultJP.add(jscrollPane);
		selectJP.add(select_resultJP);
		// ����������
		readerIDJL = new JLabel("�������ͱ�ţ�  ");
		readerIDJL.setHorizontalAlignment(SwingConstants.CENTER);
		readercategroyNameJL = new JLabel("������������:  ");
		readercategroyNameJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookNumberJL = new JLabel("�ɽ�ͼ��������  ");
		bookNumberJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookTimeJL = new JLabel("�ɽ�ͼ�����ޣ�  ");
		bookTimeJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerIDJTF = new JTextField();

		readercategroyNameJTF = new JTextField();

		bookNumberJTF = new JTextField();

		bookTimeJTF = new JTextField();
		manageJP.add(readerIDJL);
		manageJP.add(readerIDJTF);
		manageJP.add(readercategroyNameJL);
		manageJP.add(readercategroyNameJTF);
		manageJP.add(bookNumberJL);
		manageJP.add(bookNumberJTF);
		manageJP.add(bookTimeJL);
		manageJP.add(bookTimeJTF);
		// ��ť������
		addJB = new JButton("���");
		updateJB = new JButton("�޸�");
		deleteJB = new JButton("ɾ��");
		exitJB = new JButton("�˳�");
		buttonJP.add(addJB);
		buttonJP.add(updateJB);
		buttonJP.add(deleteJB);
		buttonJP.add(exitJB);
		// ���������ڴ�����
		
		exitJB.addActionListener(new ReaderManager_exitListener());
		addJB.addActionListener(new AddBookTypeActionListener());
		selectJB.addActionListener(new SelectActionListener());
		updateJB.addActionListener(new UpdateActionListener());
		jtable.addMouseListener(new JTableListener());
		deleteJB.addActionListener(new DeleteActionListener());
		this.add(selectJP, new BorderLayout().NORTH);
		this.add(manageJP, new BorderLayout().CENTER);
		this.add(buttonJP, new BorderLayout().SOUTH);
		this.setVisible(true);
		setResizable(false);
	}

	public class ReaderManager_exitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	class JTableListener extends MouseAdapter {
		public void  mouseClicked(final MouseEvent e) {
			int selRow = jtable.getSelectedRow();
			readerIDJTF.setText(jtable.getValueAt(selRow, 0).toString().trim());
			readercategroyNameJTF.setText(jtable.getValueAt(selRow, 1)
					.toString().trim());
			bookNumberJTF.setText(jtable.getValueAt(selRow, 2).toString()
					.trim());
			bookTimeJTF.setText(jtable.getValueAt(selRow, 3).toString().trim());
		}
	}

	class AddBookTypeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer id = Integer.parseInt(readerIDJTF.getText().trim());
			String category = readercategroyNameJTF.getText().trim();
			Integer num = Integer.parseInt(bookNumberJTF.getText().trim());
			Integer time = Integer.parseInt(bookTimeJTF.getText().trim());
			int i = ReaderTypeDao.insertReaderType(id, category, num, time);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				ReaderManager.this.setVisible(false);
			}

		}

	}

	class SelectActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object[][] results = getSSelect(ReaderTypeDao
					.selectType(readercategroyJTF.getText().trim()));
			jtable = new JTable(results, readertyperearch);
			jscrollPane.setViewportView(jtable);
			// �û�����ͨ��������ƶ���ͷ
			jtable.getTableHeader().setReorderingAllowed(false);
			jtable.addMouseListener(new JTableListener());

		}

	}

	class UpdateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer id = Integer.parseInt(readerIDJTF.getText().trim());
			String category = readercategroyNameJTF.getText().trim();
			Integer num = Integer.parseInt(bookNumberJTF.getText().trim());
			Integer time = Integer.parseInt(bookTimeJTF.getText().trim());
			int i = ReaderTypeDao.updateReaderType(id, category, num, time);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				Object[][] results = getSSelect(ReaderTypeDao
						.selectReaderType());
				jtable = new JTable(results, readertyperearch);
				jscrollPane.setViewportView(jtable);
				// �û�����ͨ��������ƶ���ͷ
				jtable.getTableHeader().setReorderingAllowed(false);
				jtable.addMouseListener(new JTableListener());
			}

		}

	}

	class DeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Integer id = Integer.parseInt(readerIDJTF.getText().trim());
			int i = ReaderTypeDao.deleteReaderType(id);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				Object[][] results = getSSelect(ReaderTypeDao
						.selectType(readercategroyJTF.getText().trim()));
				jtable = new JTable(results, readertyperearch);
				jscrollPane.setViewportView(jtable);
				jtable.getTableHeader().setReorderingAllowed(false);
				jtable.addMouseListener(new JTableListener());

			}
		}

	}

	public static void main(String[] args) {
		new ReaderManager();

	}

}
