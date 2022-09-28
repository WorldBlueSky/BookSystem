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
		super(name);//����������
		setSize(250,150);
		setLocationRelativeTo(null);
		myPanel=new JPanel();
		setContentPane(myPanel);
		labName=new JLabel("�û�����");		
		labPassword=new JLabel("��  �룺");
		txtName=new JTextField(12);
		txtPassword=new JPasswordField(12);
		txtPassword.setEchoChar('*');
		btnConfirm=new JButton("��¼");
		btnReset=new JButton("����");

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
		new Login("��¼");
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnConfirm) {
			//�ȶ��û���������,Ӧ�����ݿ��û������ȶ�
			//�����ж��û����������Ƿ� �����ݿ��е��û�һ��

			char[] c1 = txtPassword.getPassword();//������ȡ����
			String pwd = new String(c1);

			String username = txtName.getText().trim();


//TODO ��һ��bug����������û�������һ�� ���ݿ�����û�е�name����ô���쳣
			// �ѽ��

//			���ݲ�������ѯ User�����бȶ�
			User user = UserDao.selectUserByName(username);

			// ������ڵĻ���password�Ƿ�� ���ݿ��е�һ��

			if(pwd.equals("")|| username.equals("")){
				JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ�գ�������!");

			} else if (user.getName()== null) {//�ȿ�name�� User�����Ƿ����
				// ˵������û��͸����鲻����Ϣ
				JOptionPane.showMessageDialog(null, "���û�������!");

			} else if (!user.getPassword().equals(pwd)) {// �������� ���ݿ��е��û����벻һ��

				JOptionPane.showMessageDialog(null, "�����������!");

			} else {  //�����һ�µĻ�����ô�൱�ڵ�½�ɹ�
				// ������������ּ�⣬��ʱ˵���û������ �û�������������ݿ��е���Ϣһ�£���ʱ��ʾ������
				new Library("ͼ�����ϵͳ");

			}

		}

		if(e.getActionCommand().equals("����")){
			//����ı������������
			txtName.setText("");
			txtPassword.setText("");
		}
	}



}