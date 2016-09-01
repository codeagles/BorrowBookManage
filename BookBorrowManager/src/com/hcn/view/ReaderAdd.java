package com.hcn.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.hcn.db.ReaderDao;
import com.hcn.db.ReaderTypeDao;

public class ReaderAdd extends JFrame {
	private static final long serialVersionUID = 1L;
	// �������
	private JPanel readerAddJP, sexJP, buttonJP;
	// ���尴ť��������İ�ť�������Ա�ѡ��ť��
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton JRB1, JRB2;
	// �����ǩ
	private JLabel IDJL, categoryJL, readerNameJL, sexJL, phoneJL, ageJL,
			deptJL, regJL;
	// �����ı���
	private JTextField IDJTF, readerNameJTF, phoneJTF, deptJTF, ageJTF, regJTF;
	// ��������ı���
	private JComboBox readertypeJCB;
	private JButton addJB, closeJB;

	// ���췽��
	public ReaderAdd() {
		setBounds(400, 200, 500, 200);
		setTitle("������Ϣ���");
		buttonJP = new JPanel();// ��¼ȡ����ť

		// ������Ϣ���������
		readerAddJP = new JPanel();
		readerAddJP.setBorder(new EmptyBorder(5, 10, 5, 10));
		final GridLayout gridLayout = new GridLayout(4, 4);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		readerAddJP.setLayout(gridLayout);
		getContentPane().add(readerAddJP);

		// ��Ӷ��߱�ű�ǩ���ı��ŵ�����������
		IDJL = new JLabel("��ţ�  ");
		IDJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(IDJL);
		IDJTF = new JTextField();
		readerAddJP.add(IDJTF);

		// ��������������ǩ���ı�����ӵ�����������
		readerNameJL = new JLabel("������  ");
		readerNameJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerNameJTF = new JTextField();
		readerAddJP.add(readerNameJL);
		readerAddJP.add(readerNameJTF);

		// ��Ӷ�������ǩ������������
		categoryJL = new JLabel("���  ");
		categoryJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(categoryJL);

		// �������������б�
		readertypeJCB = new JComboBox();
		List<com.hcn.model.ReaderType> list = ReaderTypeDao.selectReaderType();
		for (int i = 0; i < list.size(); i++) {
			com.hcn.model.ReaderType rt = list.get(i);
			readertypeJCB.addItem(rt.getTypename());
		}
		readerAddJP.add(readertypeJCB);
		sexJL = new JLabel("�Ա�  ");
		sexJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(sexJL);
//		String[] array = { "��ʦ", "ѧ��" };
//		for (int i = 0; i < array.length; i++) {
//			readertypeJCB.addItem(array[i]);
//		}

		/*
		 * �����Ա���壬���ڴ���Ա�ť�������С��͡�Ů����ť����ButtonGroup�й���
		 * ��ѡ��ť�飬���Ա�ֻ��Ϊ�к�Ů����������ť�ȷŵ�sexJP�У�Ȼ���ٽ�sexJP�� ��ŵ�readerAddJP����С�
		 */
		sexJP = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		sexJP.setLayout(flowLayout);
		readerAddJP.add(sexJP);
		JRB1 = new JRadioButton();
		sexJP.add(JRB1);
		buttonGroup.add(JRB1);
		JRB1.setText("��");
		JRB2 = new JRadioButton();
		sexJP.add(JRB2);
		JRB2.setText("Ů");
		buttonGroup.add(JRB2);
		// �������������ǩ���ı��� ����ӵ�������ӵ����
		ageJL = new JLabel("���䣺  ");
		ageJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(ageJL);
		ageJTF = new JTextField();
		readerAddJP.add(ageJTF);
		// �������ߵ绰��ǩ���ı�����ӵ�����������
		phoneJL = new JLabel("�绰��  ");
		phoneJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(phoneJL);
		phoneJTF = new JTextField();
		readerAddJP.add(phoneJTF);
		// �����������ڲ��ű�ǩ���ı�����ӵ�����������
		deptJL = new JLabel("���ţ�  ");
		deptJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(deptJL);
		deptJTF = new JTextField();
		readerAddJP.add(deptJTF);
		// ��������ע�����ڱ�ǩ���ı�����ӵ����������塣�˴�����ҪĬ����ʾϵͳ��ǰʱ��
		// ��ȡ��ǰϵͳʱ��ķ�����new java.util.Date(),��ͨ��SimpleDateFormat��ָ��ʱ�����ʾ��ʽ
		regJL = new JLabel("ע�����ڣ�  ");
		regJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerAddJP.add(regJL);
		regJTF = new JTextField();
		// ʱ���ʽΪ��yyy-mm-dd��
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String st = format.format(new java.util.Date());
		regJTF.setText(st);
		readerAddJP.add(regJTF);
		/*
		 * Date dt=new Date();
		   SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		   System.out.println(matter1.format(dt));
		 * regJL=new JLabel("ע������");
		   regJL.setHorizontalAlignment(SwingConstants.CENTER);
		   regtime=new JFormattedTextField(DateFormat.getDateInstance());
		   regtime.setValue(new Date());
		 * */
		// ��ť������
		addJB = new JButton("���");
		closeJB = new JButton("�ر�");
		buttonJP.add(addJB);
		buttonJP.add(closeJB);
		// ��ӡ����������塱���ڴ����м�
		this.add(readerAddJP, BorderLayout.CENTER);
		// ��ӡ���ť��塱���ڴ����ϲ�
		this.add(buttonJP, BorderLayout.SOUTH);

		this.setVisible(true);
		setResizable(false);
		closeJB.addActionListener(new CloseBtListener());
		addJB.addActionListener(new AddBtListener(JRB1));
	}

	class CloseBtListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	class AddBtListener implements ActionListener {
		private final JRadioButton button1;

		AddBtListener(JRadioButton button1) {
			this.button1 = button1;
		}

		public void actionPerformed(final ActionEvent e) {
			if (IDJTF.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "���߱�Ų�����Ϊ��");
				return;
			}
			if (IDJTF.getText().length() != 10) {
				JOptionPane.showMessageDialog(null, "���߱��λ������");
				return;
			}
			if (readerNameJTF.getText().length() >= 4) {
				JOptionPane.showMessageDialog(null, "������������Ϊ��");
				return;
			}
			String ID = IDJTF.getText().trim();
			// ��ȡѡ��Ķ�������
			String readertype = (String)readertypeJCB.getSelectedItem();
			// String.valueOf(readertypeJCB.getSelectedIndex()) ;
			String name = readerNameJTF.getText().trim();
			String age = ageJTF.getText().trim();
			// ��ȡ���ߵ��Ա�
			String sex = "Ů";
			if (button1.isSelected()) {
				sex = "��";
			}
			String phone = phoneJTF.getText().trim();
			String dept = deptJTF.getText().trim();
			String regdate = regJTF.getText().trim();
			int i = ReaderDao.insertReader(ID, readertype, name, age, sex,
					phone, dept, regdate);
			System.out.println("readertype:"+readertype);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				ReaderAdd.this.setVisible(false);
			}
		}

	}

	public static void main(String[] args) {
		new ReaderAdd();

	}

}
