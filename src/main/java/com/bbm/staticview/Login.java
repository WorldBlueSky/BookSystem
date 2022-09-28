package com.bbm.staticview;

import javax.swing.*;

public class Login extends JFrame {
	private JPanel myPanel;
	private JLabel labName,labPassword;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnConfirm,btnReset;
	public Login(String name)
	{
		super(name);//框架类设标题
		setSize(250,150);
		setLocationRelativeTo(null);
		myPanel=new JPanel();
		setContentPane(myPanel);
		labName=new JLabel("用户名：");		
		labPassword=new JLabel("密  码：");
		txtName=new JTextField(12);
		txtPassword=new JPasswordField(12);
		txtPassword.setEchoChar('*');
		btnConfirm=new JButton("登录");
		btnReset=new JButton("重置");
		myPanel.add(labName);
		myPanel.add(txtName);
		myPanel.add(labPassword);
		myPanel.add(txtPassword);
		myPanel.add(btnConfirm);
		myPanel.add(btnReset);			
		setVisible(true);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login("登录");
	}

}
