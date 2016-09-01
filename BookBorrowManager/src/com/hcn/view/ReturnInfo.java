package com.hcn.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
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

public class ReturnInfo extends JFrame {
	private JPanel selectJP, borrowJP, buttonJP, select_conditionJP,
			select_resultJP;
	private JLabel IDJL, readerNameJL, readercategroyJL, ISBNJL, categroyJL,
			bookNameJL, authorJL, publishJL, publishDateJL, printTimeJL,
			priceJL, dateJL, workerJL, overDateJL, fineJL;
	private JTextField IDJTF, readerNameJTF, readercategroyJTF, ISBNJTF,
			categroyJTF, bookNameJTF, authorJTF, publishJTF, publishDateJTF,
			printTimeJTF, priceJTF, dateJTF, workerJTF, overDateJTF, fineJTF;
	private JScrollPane jscrollPane;
	private JTable tab;
	private JButton borrowJB, closeJB;
	private String[] resch = { "ͼ����", "ͼ������", "��������" };

	private Object[][] getSSelect(List<BookBorrow> list) {
		Object[][] results = new Object[list.size()][resch.length];
		for (int i = 0; i < list.size(); i++) {
			BookBorrow borrowbook = list.get(i);
			results[i][0] = borrowbook.getISBN();
			results[i][1] = borrowbook.getBookname();
			results[i][2] = borrowbook.getBorroedate();
		}
		return results;
	}

	public ReturnInfo() {
		setBounds(300, 100, 700, 500);
		setTitle("ͼ��黹");
		// ������Ҫ���������
		selectJP = new JPanel();
		selectJP.setLayout(new BorderLayout());
		buttonJP = new JPanel();
		borrowJP = new JPanel();
		borrowJP.setLayout(new GridLayout(6, 4));
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
		tab = new JTable(results, resch);
		// tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
		overDateJL = new JLabel("����������  ");
		overDateJL.setHorizontalAlignment(SwingConstants.CENTER);
		fineJL = new JLabel("����  ");
		fineJL.setHorizontalAlignment(SwingConstants.CENTER);
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
		overDateJTF = new JTextField();
		fineJTF = new JTextField();
		workerJTF = new JTextField();

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
		borrowJP.add(overDateJL);
		borrowJP.add(overDateJTF);
		borrowJP.add(fineJL);
		borrowJP.add(fineJTF);
		borrowJP.add(workerJL);
		borrowJP.add(workerJTF);
		// ��ư�ť���
		borrowJB = new JButton("�黹");
		closeJB = new JButton("�ر�");
		buttonJP.add(borrowJB);
		buttonJP.add(closeJB);
		// �������� ���� ������
		this.add(selectJP, new BorderLayout().NORTH);
		this.add(borrowJP, new BorderLayout().CENTER);
		this.add(buttonJP, new BorderLayout().SOUTH);
		this.setVisible(true);
		setResizable(false);
		// ע��
		borrowJB.addActionListener(new ReturnInfoAction());
		IDJTF.addKeyListener(new SelectReaderAction());
		ISBNJTF.addKeyListener(new SelectByISBN());
		closeJB.addActionListener(new Return_closeListner());
		workerJTF.setText(Login.operator);
	}

	// �رս��������ʵ��
	public class Return_closeListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

	// ʵ��ѧ������ָ��ѧ�� �س� ����Ӧ�¼�
	class SelectReaderAction extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			List<Reader> reader_list = ReaderDao.selectReaderById(IDJTF
					.getText().trim());
			// for (int i = 0; i < list.size(); i++) {
			// Book book = list.get(i);
			if (reader_list.size() != 0) {
				for (Reader r : reader_list) {
					readerNameJTF.setText(r.getName());
					readercategroyJTF.setText(r.getTypename());
				}
			} else {
				readerNameJTF.setText("");
				readercategroyJTF.setText("");
			}
			// ���²�ѯ��Ϣ
			Object[][] bookdata = getSSelect(BookBorrowDao
					.selectBorrowBookByReaderId(IDJTF.getText().toString()
							.trim()));
			tab = new JTable(bookdata, resch);
			// tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// �����еĿ��
			tab.getColumnModel().getColumn(0).setPreferredWidth(133);
			tab.getColumnModel().getColumn(1).setPreferredWidth(133);
			tab.getColumnModel().getColumn(2).setPreferredWidth(133);
			jscrollPane.setViewportView(tab);
		}
	}

	// �黹ͼ�� ���ж��Ƿ�ɹ� ʵ�� �黹��ť�Ĺ���
	class ReturnInfoAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String returndate = dateJTF.getText().toString().trim();
			Date re = Date.valueOf(returndate);
			String readerid = IDJTF.getText().trim();
			String isbn = ISBNJTF.getText().trim();
			int i = BookBorrowDao.returnBook(readerid, isbn, re);
			if (i != 0) {
				JOptionPane.showMessageDialog(null, "�黹�ɹ���");
				Object[][] results = getSSelect(BookBorrowDao
						.selectBorrowBookByReaderId(IDJTF.getText().trim()));
				tab = new JTable(results, resch);
				tab.getTableHeader().setReorderingAllowed(false);

				jscrollPane.setViewportView(tab);
				select_resultJP.add(jscrollPane);
			}
		}
	}

	// ʵ������ISBN�� ����ͼ�������Ϣ
	class SelectByISBN extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			List<Book> list = BookDao
					.selectBookByISNB(ISBNJTF.getText().trim());
			if (list.size() != 0) {
				for (Book book : list) {
					categroyJTF.setText(book.getTypename());
					bookNameJTF.setText(book.getBookname().trim());
					authorJTF.setText(book.getAuthor().trim());
					publishJTF.setText(book.getPublish().trim());
					publishDateJTF.setText(book.getPublishdate().toString()
							.trim());
					printTimeJTF.setText(String.valueOf(book.getPrinttime()));
					priceJTF.setText(book.getUnitprice().toString().trim());
				}
			} else {
				categroyJTF.setText("");
				bookNameJTF.setText("");
				authorJTF.setText("");
				publishJTF.setText("");
				publishDateJTF.setText("");
				printTimeJTF.setText("");
				priceJTF.setText("");
			}
			int selRow = tab.getSelectedRow();
			java.sql.Date borrowday, returnday;
			borrowday = java.sql.Date.valueOf(tab.getValueAt(selRow, 2)
					.toString().trim());
			returnday = java.sql.Date.valueOf(dateJTF.getText().trim());
			Long m_intervalday = returnday.getTime() - borrowday.getTime();// ��������Ϊ΢����
			Long borrowtime = m_intervalday / 1000 / 60 / 60 / 24 - 30;// �������õ�����
			List<Reader> list1 = ReaderDao.selectReaderById(IDJTF.getText()
					.trim());
			// for()
			int limit;
			for (int i = 0; i < list1.size(); i++) {
				Reader reader = list1.get(i);
				limit = reader.getLimit();

				if (borrowtime > limit) {
					overDateJTF.setText(String.valueOf(borrowtime));
					Double zfk = Double.valueOf(borrowtime - 30) * Fine.fune;//Login.username
					fineJTF.setText(String.valueOf(zfk));
				} else {
					overDateJTF.setText("û�г����涨����");
					fineJTF.setText("0");
				}
			}
			// �Ա�������������� ��ʵ�� ����� �Զ���ȡͼ�������Ϣ��ѯ����ʾ����

			/*
			 * class TableListener extends MouseAdapter {
			 * 
			 * public void mouseClicked(final MouseEvent e) {
			 * 
			 * int selRow = table.getSelectedRow();
			 * ISBNJTF.setText(table.getValueAt(selRow, 0).toString().trim());
			 * System.out.println(ISBNJTF.getText()); List<Book>
			 * list=BookDao.selectBookByISBN(ISBNJTF.getText().trim()); for (int
			 * i = 0; i < list.size(); i++) { Book book = list.get(i);
			 * //��ȡͼ����������
			 * 
			 * booktypeJTF.setText(book.getTypename());
			 * booknameJTF.setText(book.getBookname());
			 * authorJTF.setText(book.getAuthor());
			 * publishJTF.setText(book.getPublish()); DateFormat format = new
			 * SimpleDateFormat("yyyy-MM-dd"); String
			 * date=format.format(book.getPublishdate());
			 * publishdateJTF.setText(date); String
			 * time=String.valueOf(book.getPrinttime());
			 * printtimeJTF.setText(time); String
			 * unitprice=String.valueOf(book.getUnitprice());
			 * unitpriceJTF.setText(unitprice); } //���ó�������ֵ java.sql.Date
			 * borrowday,returnday; borrowday
			 * =java.sql.Date.valueOf(table.getValueAt(selRow,
			 * 2).toString().trim());
			 * returnday=java.sql.Date.valueOf(returndate.getText().trim());
			 * Long m_intervalday = returnday.getTime() -
			 * borrowday.getTime();//��������Ϊ΢���� Long borrowtime = m_intervalday /
			 * 1000 / 60 / 60 / 24;//�������õ����� System.out.println(borrowtime);
			 * List<Reader>
			 * list1=ReaderDao.selectReaderById(readeridJTF.getText().trim());
			 * //for() int limit; for (int i = 0; i < list1.size(); i++) {
			 * Reader reader = list1.get(i); limit=reader.getLimit();
			 * 
			 * if(borrowtime>limit){
			 * overlimitJTF.setText(String.valueOf(borrowtime)); Double
			 * zfk=Double.valueOf(borrowtime)*FineSet.fine;
			 * fineJTF.setText(String.valueOf(zfk)); } else{
			 * overlimitJTF.setText("û�г����涨����"); fineJTF.setText("0"); } } }
			 * 
			 * }
			 */
			// =======================================================================================
			// Calendar
			// nowDate=Calendar.getInstance(),oldDate=Calendar.getInstance();
			// nowDate.setTime(new Date());//����Ϊ��ǰϵͳʱ��
			// oldDate.set(1990, 5, 19);//����Ϊ1990�꣨6����29��
			// long timeNow=nowDate.getTimeInMillis();
			// long timeOld=oldDate.getTimeInMillis();
			// long �������=(timeNow-timeOld)/(1000*60*60*24);//��Ϊ��
			// System.out.println("���"+�������+"��");
			// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			// long to = df.parse("2008-4-25").getTime();
			// long from = df.parse("2008-1-20").getTime();
			// System.out.println((to - from) / (1000 * 60 * 60 * 24))
			// if (list.size() != 0) {
			// int selRow = tab.getSelectedRow();
			// String borrowdate = (tab.getValueAt(selRow, 2).toString()
			// .trim());
			// String nowdate = dateJTF.getText();
			// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			// long borrow = 0;
			// long now = 0;
			// try {
			// borrow = df.parse(borrowdate).getTime();
			// } catch (ParseException e1) {
			//
			// e1.printStackTrace();
			// }
			// try {
			// now = df.parse(nowdate).getTime();
			// } catch (ParseException e1) {
			// e1.printStackTrace();
			// }
			// BookBorrow bookborrow = new BookBorrow();
			// long c = ((now - borrow) / (1000 * 60 * 60 * 24));
			// overDateJTF.setText(String.valueOf(c));
			// // double m =
			// // ((now-borrow)/(1000*60*60*24))*bookborrow.getFune();
			// // fineJTF.setText(String.valueOf(m));
			// System.out.println(bookborrow.getFune());
			// if (((now - borrow) / (1000 * 60 * 60 * 24)) > 30) {
			// double money = (c - 30) * bookborrow.getFune();
			// System.out.println(money);
			// fineJTF.setText(String.valueOf(money));
			// }
			//
			// } else{
			// overDateJTF.setText("");
			// fineJTF.setText("");
			// }
			// ============================================================================================
		}
	}

	public static void main(String[] args) {
		new ReturnInfo();

	}

}
/*
 * java.util.Calendar c=java.util.Calendar.getInstance();
 * java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy��MM��dd��");
 * System.out.println(f.format(c.getTime()));
 */
