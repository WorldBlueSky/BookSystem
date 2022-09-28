package com.bbm.view;

import com.bbm.db.UserDao;
import com.bbm.model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	private JPanel myPanel;
	private JLabel labName,labPassword;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnConfirm,btnReset;
	public Login(String name){
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

		btnConfirm.addActionListener(this);
		btnReset.addActionListener(this);		

		myPanel.add(labName);
		myPanel.add(txtName);
		myPanel.add(labPassword);
		myPanel.add(txtPassword);
		myPanel.add(btnConfirm);
		myPanel.add(btnReset);			
		setVisible(true);		
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		new Login("登录");
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnConfirm) {
			//比对用户名和密码,应与数据库用户表作比对
			//这里判断用户名和密码是否 和数据库中的用户一致

			char[] c1 = txtPassword.getPassword();//密码框获取密码
			String pwd = new String(c1);

			String username = txtName.getText().trim();


//TODO 有一个bug，就是如果用户名输入一个 数据库中中没有的name，那么报异常
			// 已解决

//			根据参数，查询 User表，进行比对
			User user = UserDao.selectUserByName(username);

			// 如果存在的话，password是否和 数据库中的一致

			if(pwd.equals("")|| username.equals("")){
				JOptionPane.showMessageDialog(null,"用户名和密码不能为空，请输入!");

			} else if (user.getName()== null) {//先看name在 User表中是否存在
				// 说明这个用户就根本查不到信息
				JOptionPane.showMessageDialog(null, "该用户不存在!");

			} else if (!user.getPassword().equals(pwd)) {// 如果密码和 数据库中的用户密码不一致

				JOptionPane.showMessageDialog(null, "输入密码错误!");

			} else {  //如果都一致的话，那么相当于登陆成功
				// 经过上面的两轮检测，此时说明用户输入的 用户名和密码和数据库中的信息一致，此时显示主界面
				new Library("图书借阅系统");

			}

		}

		if(e.getActionCommand().equals("重置")){
			//清除文本框输入的内容
			txtName.setText("");
			txtPassword.setText("");
		}
	}



}