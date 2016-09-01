
package com.hcn.view;

import com.hcn.db.UserDao;
import com.hcn.model.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*; 
import java.awt.event.*;

import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class Login extends JFrame {
	private static Users user;
	Font f1 = new Font("����",Font.BOLD,32);
	JLabel usernameJLabel,passwordJLabel;
	JTextField usernameJTF;
	JPasswordField pwdJPF;
	public static String operator;
	public Login() {
		setSize(260,180);//�������м���ʾ�Ĵ�С
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-130,height/2-90);
		setTitle("ͼ�����ϵͳ��¼����");
		JPanel textJPanel = new JPanel();//��ʾ��Ϣ���
		JPanel loginJPanel = new JPanel();//��¼��Ϣ���
		JPanel buttonJPanel = new JPanel();//��¼ȡ����ť���
		//��ʾ��Ϣ���
		JLabel j11 = new JLabel();
		j11.setFont(f1);
		j11.setText("ͼ�����ϵͳ");
		textJPanel.add(j11);
		//��¼��Ϣ������
		loginJPanel.setLayout(new GridLayout(2,2));
		usernameJLabel = new JLabel("�û�����   ");
		//�����ı���������ǩ���м�λ����ʾ
		usernameJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameJTF = new JTextField();
		passwordJLabel = new JLabel("��	�룺   ");
		passwordJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdJPF = new JPasswordField();
		loginJPanel.add(usernameJLabel);
		loginJPanel.add(usernameJTF);
		loginJPanel.add(passwordJLabel);	
		loginJPanel.add(pwdJPF);
		//��¼ȡ����ť������
		JButton confirmButton = new JButton("��¼");
		JButton resetButton = new JButton("����");
		buttonJPanel.add(confirmButton);
		buttonJPanel.add(resetButton);
		//���3����嵽�����У�λ�÷ֱ�ΪBorderLayout���ֵı����С��ϡ�
		this.add(textJPanel,BorderLayout.NORTH);
		this.add(loginJPanel,BorderLayout.CENTER);
		this.add(buttonJPanel,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���ʱ���˳�����	
		confirmButton.addActionListener(new LoginAction());
		resetButton.addActionListener(new ResetAction());
		this.setVisible(true);
		this.setResizable(false);
		
	}
	//���ڱ����û���¼���û���Ϣ��
	public static void setUser(Users user) {
		Login.user = user;
	}
	public static Users getUser() {
		return user;
	}
	//�������¼����ťʱ���������
	class LoginAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!"".equals(usernameJTF.getText())&&!"".equals(new String(pwdJPF.getPassword()))){
				user = UserDao.check(usernameJTF.getText(),new String (pwdJPF.getPassword()));
				if(user.getName()!= null){
					operator = usernameJTF.getText();
					try {
						
						Library frame = new Library();
						frame.setVisible(true);
						Login.this.setVisible(false);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null,"��������û�����������󣬲��ܵ�¼");
					usernameJTF.setText("");
					pwdJPF.setText("");
				}
					
			}else{
				JOptionPane.showMessageDialog(null, "�������û���������");
			}
		}
		
	}
	class ResetAction implements ActionListener{
		public void actionPerformed(final ActionEvent e) {
				usernameJTF.setText("");
				pwdJPF.setText("");
		}
		
	}
	public static void main(String[] args){
		 new Login();
		
	}

}
