package com.hcn.view;

import java.awt.Toolkit;
import java.awt.Desktop.Action;
import java.awt.event.*;
import java.awt.*;

import javax.print.DocFlavor.READER;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * ͼ����Ĺ���ϵͳ������
 * ʵ�ֲ˵��������
 * ˳�򣺴��ϵ��£������ҡ�
 * */
public class Library extends JFrame {
	// ���л���Ϊ�˱��ְ汾�ļ����ԣ����ڰ汾����ʱ�����л��Ա��ֶ����Ψһ�ԡ�
	private static final long serialVersionUID = 1L;

	// �ڴ˳����У�ͨ�����췽��Library()��ʵ�ֽ���ĳ�ʼ����
	public Library() {
		setSize(800, 600);
		setTitle("ͼ�����ϵͳ");
		JMenuBar jmenuBar = createJMenuBar();// �����˵���
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 6 + 50, height / 8 - 50);
		setJMenuBar(jmenuBar);// ��Ӳ˵����������壬����������˵�����
		// �رմ���ʱ�˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/*
	 * �˳����У��Զ��巽��createJMenuBar(),����һ��JMenuBar����������
	 * �˵����Ĺ��ܣ��ڹ��췽����Library()�е��ø÷�����
	 */
	private JMenuBar createJMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();// �˵���
		// ������Ϣ����˵�
		JMenu readerManageJMenu = new JMenu("������Ϣ����");
		JMenuItem readerAddJMI = new JMenuItem("������Ϣ���");
		readerManageJMenu.add(readerAddJMI);
		JMenuItem readerSelUpdJMI = new JMenuItem("������Ϣ��ѯ���޸�");
		readerManageJMenu.add(readerSelUpdJMI);
		// ͼ����Ϣ����˵�
		JMenu bookManageJMenu = new JMenu("ͼ����Ϣ����");
		JMenuItem bookAddJMI = new JMenuItem("ͼ����Ϣ���");
		bookManageJMenu.add(bookAddJMI);
		JMenuItem bookSelUpdJMI = new JMenuItem("ͼ����Ϣ��ѯ���޸�");
		bookManageJMenu.add(bookSelUpdJMI);
		// ͼ����Ĳ˵�
		JMenu bookBorrowJMenu = new JMenu("ͼ����Ĺ���");
		JMenuItem bookBorrowJMI = new JMenuItem("ͼ�����");
		JMenuItem bookReturnJMI = new JMenuItem("ͼ��黹");
		bookBorrowJMenu.add(bookBorrowJMI);
		bookBorrowJMenu.add(bookReturnJMI);
		// ������Ϣά���˵�
		JMenu baseInfoJMenu = new JMenu("������Ϣά��");
		JMenuItem readerTypeJMI = new JMenuItem("�����������");
		JMenuItem bookTypeJMI = new JMenuItem("ͼ���������");
		JMenuItem fineSetJMI = new JMenuItem("��������");
		baseInfoJMenu.add(readerTypeJMI);
		baseInfoJMenu.add(bookTypeJMI);
		baseInfoJMenu.add(fineSetJMI);
		// �û�����˵�
		JMenu userManageJMenu = new JMenu("�û�����");
		JMenuItem updPwdJMI = new JMenuItem("�޸�����");
		userManageJMenu.add(updPwdJMI);
		JMenuItem userAddJMI = new JMenuItem("�û����");
		userManageJMenu.add(userAddJMI);
		JMenuItem userDelJMI = new JMenuItem("�û�ɾ��");
		userManageJMenu.add(userDelJMI);
		// �������˵���ӵ��˵�����
		jMenuBar.add(bookManageJMenu);
		jMenuBar.add(readerManageJMenu);
		jMenuBar.add(bookBorrowJMenu);
		jMenuBar.add(baseInfoJMenu);
		jMenuBar.add(userManageJMenu);
		// createJMenuBar()����jMenuBar����
		readerAddJMI.addActionListener(new ReaderAddListener());
		readerSelUpdJMI.addActionListener(new ReaderSelectandUpdateListener());
		bookAddJMI.addActionListener(new BookAddListener());
		bookSelUpdJMI.addActionListener(new BookSelectandUpdateListener());
		bookReturnJMI.addActionListener(new ReturnInfoListener());
		bookBorrowJMI.addActionListener(new BorrowInfoListener());
		readerTypeJMI.addActionListener(new ReaderManagerListener());
		bookTypeJMI.addActionListener(new BookTypeListener());
		fineSetJMI.addActionListener(new FineListener());
		updPwdJMI.addActionListener(new UpdatePWDListener());
		userAddJMI.addActionListener(new AddUserListener());
		userDelJMI.addActionListener(new DeleteUserListener());
		return jMenuBar;

	}

	class ReaderAddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ReaderAdd();
		}
	}

	class ReaderManagerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ReaderManager();
		}
	}

	class DeleteUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new DeleteUser();
		}
	}

	class UpdatePWDListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new UpdatePWD();
		}
	}

	class AddUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new AddUser();
		}
	}

	class ReaderSelectandUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ReaderSelectandUpdate();
		}
	}

	class BookAddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new BookAdd();
		}
	}

	class BookSelectandUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new BookSelectandUpdate();
		}
	}

	class BorrowInfoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new BorrowInfo();
		}
	}

	class ReturnInfoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new ReturnInfo();
		}
	}

	class BookTypeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new BookType();
		}
	}

	class FineListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Fine();
		}
	}

	public static void main(String[] args) {
		new Library();

	}

}