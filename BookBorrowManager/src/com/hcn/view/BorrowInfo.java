package com.hcn.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.hcn.db.BookBorrowDao;
import com.hcn.db.BookDao;
import com.hcn.db.ReaderDao;
import com.hcn.model.Book;
import com.hcn.model.BookBorrow;
import com.hcn.model.Reader;
import com.hcn.model.ReaderType;

public class BorrowInfo extends JFrame {
	private JPanel selectJP, borrowJP, buttonJP, select_conditionJP,
			select_resultJP;
	private JLabel IDJL, readerNameJL, readercategroyJL, ISBNJL, categroyJL,
			bookNameJL, authorJL, publishJL, publishDateJL, printTimeJL,
			priceJL, dateJL, workerJL;
	private JTextField IDJTF, readerNameJTF, readercategroyJTF, ISBNJTF,
			categroyJTF, bookNameJTF, authorJTF, publishJTF, publishDateJTF,
			printTimeJTF, priceJTF, dateJTF, workerJTF;
	private JScrollPane jscrollPane;
	private JTable tab;
	private JButton borrowJB, closeJB;
	private String[] bookreasch = { "ͼ����", "ͼ������", "��������" };
	public static int num=0;
	private Object[][] getSSelect(List<BookBorrow> list) {
		Object[][] results = new Object[list.size()][bookreasch.length];
		for (int i = 0; i < list.size(); i++) {
			BookBorrow borrowbook = list.get(i);
			results[i][0] = borrowbook.getISBN();
			results[i][1] = borrowbook.getBookname();
			results[i][2] = borrowbook.getBorroedate();
		}
		return results;
	}

	public BorrowInfo() {
		setBounds(300, 100, 700, 500);
		setTitle("ͼ�����");
		// ������Ҫ���������
		selectJP = new JPanel();
		selectJP.setLayout(new BorderLayout());
		buttonJP = new JPanel();
		borrowJP = new JPanel();
		borrowJP.setLayout(new GridLayout(5, 4));
		// ��ѯ����������
		select_conditionJP = new JPanel();
		// select_conditionJP.setLayout(new FlowLayout());
		select_conditionJP.setLayout(new GridLayout(1, 6));
		// �������齨�������������
		IDJL = new JLabel("���߱�ţ�  ");
		IDJL.setHorizontalAlignment(SwingConstants.CENTER);
		readerNameJL = new JLabel("����������  ");
		readerNameJL.setHorizontalAlignment(SwingConstants.CENTER);
		readercategroyJL = new JLabel("�������ͣ�  ");
		readercategroyJL.setHorizontalAlignment(SwingConstants.CENTER);
		IDJTF = new JTextField();
		readerNameJTF = new JTextField();
		readercategroyJTF = new JTextField();
		select_conditionJP.add(IDJL);
		select_conditionJP.add(IDJTF);
		select_conditionJP.add(readerNameJL);
		select_conditionJP.add(readerNameJTF);
		select_conditionJP.add(readercategroyJL);
		select_conditionJP.add(readercategroyJTF);
		selectJP.add(select_conditionJP, BorderLayout.NORTH);
		// ���������
		select_resultJP = new JPanel();
		jscrollPane = new JScrollPane();
		jscrollPane.setPreferredSize(new Dimension(550, 250));

		Object[][] results = getSSelect(BookBorrowDao
				.selectBorrowBookByReaderId(IDJTF.getText().trim()));
		tab = new JTable(results, bookreasch);
//		 tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jscrollPane.setViewportView(tab);
		select_resultJP.add(jscrollPane);

		selectJP.add(select_resultJP, BorderLayout.CENTER);
		// ͼ�����������
		ISBNJL = new JLabel("ISBN��  ");
		ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);
		categroyJL = new JLabel("���  ");
		categroyJL.setHorizontalAlignment(SwingConstants.CENTER);
		bookNameJL = new JLabel("������  ");
		bookNameJL.setHorizontalAlignment(SwingConstants.CENTER);
		authorJL = new JLabel("���ߣ�  ");
		authorJL.setHorizontalAlignment(SwingConstants.CENTER);
		publishJL = new JLabel("������:  ");
		publishJL.setHorizontalAlignment(SwingConstants.CENTER);
		publishDateJL = new JLabel("�������ڣ�  ");
		publishDateJL.setHorizontalAlignment(SwingConstants.CENTER);
		printTimeJL = new JLabel("ӡˢ����:  ");
		printTimeJL.setHorizontalAlignment(SwingConstants.CENTER);
		priceJL = new JLabel("���ۣ�  ");
		priceJL.setHorizontalAlignment(SwingConstants.CENTER);
		dateJL = new JLabel("�������ڣ�  ");
		dateJL.setHorizontalAlignment(SwingConstants.CENTER);
		workerJL = new JLabel("������Ա��  ");
		workerJL.setHorizontalAlignment(SwingConstants.CENTER);
		ISBNJTF = new JTextField();
		categroyJTF = new JTextField();
		bookNameJTF = new JTextField();
		authorJTF = new JTextField();
		publishJTF = new JTextField();
		publishDateJTF = new JTextField();
		printTimeJTF = new JTextField();
		priceJTF = new JTextField();
		dateJTF = new JTextField();
		workerJTF = new JTextField();
		workerJTF.setText(Login.operator);
		workerJTF.setEditable(false);

		// ����ʱ�� ��ȡϵͳʱ��
		java.util.Calendar c = java.util.Calendar.getInstance();
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String st = format.format(c.getTime());
		dateJTF.setText(st);
		borrowJP.add(ISBNJL);
		borrowJP.add(ISBNJTF);
		borrowJP.add(categroyJL);
		borrowJP.add(categroyJTF);
		borrowJP.add(bookNameJL);
		borrowJP.add(bookNameJTF);
		borrowJP.add(authorJL);
		borrowJP.add(authorJTF);
		borrowJP.add(publishJL);
		borrowJP.add(publishJTF);
		borrowJP.add(publishDateJL);
		borrowJP.add(publishDateJTF);
		borrowJP.add(printTimeJL);
		borrowJP.add(printTimeJTF);
		borrowJP.add(priceJL);
		borrowJP.add(priceJTF);
		borrowJP.add(dateJL);
		borrowJP.add(dateJTF);
		borrowJP.add(workerJL);
		borrowJP.add(workerJTF);
		// ��ư�ť���
		borrowJB = new JButton("����");
		closeJB = new JButton("�ر�");
		buttonJP.add(borrowJB);
		buttonJP.add(closeJB);
		// �������� ���� ������
		this.add(selectJP, new BorderLayout().NORTH);
		this.add(borrowJP, new BorderLayout().CENTER);
		this.add(buttonJP, new BorderLayout().SOUTH);
		this.setVisible(true);
		setResizable(false);
		borrowJB.addActionListener(new BorrowActionListener());
		closeJB.addActionListener(new borrow_closeListner());
		IDJTF.addKeyListener(new SelectByReaderidAction());
		ISBNJTF.addKeyListener(new SelectByISBN());
	}

	public class borrow_closeListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	class BorrowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ISBN = ISBNJTF.getText().trim();
			String readerid = IDJTF.getText().trim();
			String borrowdate = dateJTF.getText().trim();
			
			if (IDJTF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "���߱�Ų���Ϊ�գ�");
				return;
			}
			if (ISBNJTF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "ISBN����Ϊ�գ�");
				return;
			}
			
			if (readerNameJTF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "û�иö��ߣ����ɽ��ģ�");
				return;
			}
			if (categroyJTF.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "û�и�ͼ�飬���ɽ��ģ�");
				return;
			}
			List<BookBorrow> list =BookBorrowDao.selectBorrowBookByReaderId(readerid);
			for(BookBorrow bookborrow:list){
				if(ISBNJTF.getText().trim().equals(bookborrow.getISBN())){
					JOptionPane.showMessageDialog(null, "�ѽ��ĸ�ͼ�飬�����ڽ��ģ�");
					return;
				}
			}
			
			if(num>=2){
				JOptionPane.showMessageDialog(null, "�����ĵ�ͼ�������Ѵﵽ���ޣ�");
				return;
			}
			int i = BookBorrowDao.borrowBook(readerid, ISBN, borrowdate);
			if (i ==1) {
				JOptionPane.showMessageDialog(null, "���ĳɹ���");
				Object[][] bookdata = getSSelect(BookBorrowDao
						.selectBorrowBookByReaderId(IDJTF.getText().trim()));
				tab = new JTable(bookdata, bookreasch);
			//	tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				// �����еĿ��
				jscrollPane.setViewportView(tab);
				select_resultJP.add(jscrollPane);
			}

		}
	}

	class SelectByISBN extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			List<Book> list = BookDao.selectBookByISNB(ISBNJTF.getText().trim());
			if(list.size()!=0){
				for (Book book : list) {
					categroyJTF.setText(book.getTypename());
					bookNameJTF.setText(book.getBookname());
					authorJTF.setText(book.getAuthor());
					publishJTF.setText(book.getPublish());
					publishDateJTF.setText(book.getPublishdate().toString().trim());
					printTimeJTF.setText(String.valueOf(book.getPrinttime()));
					priceJTF.setText(book.getUnitprice().toString().trim());
					
				}
			}else {
				categroyJTF.setText("");
				bookNameJTF.setText("");
				authorJTF.setText("");
				publishJTF.setText("");
				publishDateJTF.setText("");
				printTimeJTF.setText("");
				priceJTF.setText("");
			}
			
		}
	}
	class SelectByReaderidAction extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			List<Reader> reader_list=ReaderDao.selectReaderById(IDJTF.getText().trim());
			if(reader_list.size()!=0){
				for(Reader r:reader_list){
					readerNameJTF.setText(r.getName());
					readercategroyJTF.setText(r.getTypename());
				}
			}else {
				readerNameJTF.setText("");
				readercategroyJTF.setText("");
			}
			
			Object[][] bookdata = getSSelect(BookBorrowDao.selectBorrowBookByReaderId(IDJTF.getText().toString().trim()));
			tab = new JTable(bookdata, bookreasch);
//			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			ReaderType readertype = new ReaderType();
			readertype.setMaxborrownum(tab.getRowCount());
			num = readertype.getMaxborrownum();
			
			
			// �����еĿ��
			tab.getColumnModel().getColumn(0).setPreferredWidth(133);
			tab.getColumnModel().getColumn(1).setPreferredWidth(133);
			tab.getColumnModel().getColumn(2).setPreferredWidth(133);
			jscrollPane.setViewportView(tab);
		}
	}
	public static void main(String[] args) {
		new BorrowInfo();

	}

}
