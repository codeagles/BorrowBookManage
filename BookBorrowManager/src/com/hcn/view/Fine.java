package com.hcn.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hcn.model.BookBorrow;

public class Fine extends JFrame {
	private JLabel fineJL,moneyJL;
	private JTextField fineJTF;
	private JButton setJB,exitJB;
	private JPanel buttonJP,fineJP;
	 public static double fune;
	public Fine(){
		setBounds(400, 200, 500, 100);
		setTitle("��������");
		buttonJP = new JPanel();
		fineJP = new JPanel();
		fineJL = new JLabel("�������ã� ");
		fineJTF = new JTextField();
		fineJTF.setColumns(20);
		moneyJL = new JLabel("Ԫ/��");
		fineJP.add(fineJL);
		fineJP.add(fineJTF);
		fineJP.add(moneyJL);
		setJB = new JButton("����");
		exitJB = new JButton("�˳�");
		buttonJP.add(setJB);
		buttonJP.add(exitJB);
		this.add(fineJP,new BorderLayout().CENTER);
		this.add(buttonJP,new BorderLayout().SOUTH);
		this.setVisible(true);
		setResizable(false);
		setJB.addActionListener(new SetActionListener());
		exitJB.addActionListener(new Fine_exitListener() );
	}
	public class Fine_exitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
	class SetActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 fune =Double.valueOf( fineJTF.getText().trim()) ;
			
			JOptionPane.showMessageDialog(null,"���óɹ�����������Ϊ"+fune+"Ԫ/��");
		}
		
	}
	public static void main(String[] args) {
		new Fine();
	}

}
