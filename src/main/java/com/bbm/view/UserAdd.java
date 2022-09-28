package com.bbm.view;

import com.bbm.db.UserDao;
import com.bbm.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAdd extends JFrame implements ActionListener {
    private JPanel myPanel;
    private JLabel labName,labPassword;
    private JTextField txtName;
    private JPasswordField txtPassword;
    private JButton btnAdd, btnCancel;

    public UserAdd(String name){
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

        btnAdd =new JButton("���");
        btnCancel =new JButton("ȡ��");

        btnAdd.addActionListener(this);
        btnCancel.addActionListener(this);

        myPanel.add(labName);
        myPanel.add(txtName);
        myPanel.add(labPassword);
        myPanel.add(txtPassword);
        myPanel.add(btnAdd);
        myPanel.add(btnCancel);

        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new UserAdd("����û�");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnAdd){
            // ����û�
            // �����ݿ��е�user���в��� ���һ���û���Ϣ���൱��ע��
            String username = txtName.getText();
             char[] c = txtPassword.getPassword();
             String password = new String(c);

             if(username.equals("")|| password.equals("")){
                 JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��!");
                 return;
             }

             User user = new User();
             user.setName(username);
             user.setPassword(password);

             // username�����ظ� ,�����ݿ��е�user���е� username�ֶ����ó�not null
            int ret = UserDao.insertUser(user);
            if(ret==1){
                JOptionPane.showMessageDialog(null,"����ɹ�!");
            }else{
                JOptionPane.showMessageDialog(null,"����ʧ��!");
            }

        }

        if(e.getSource()==btnCancel){
            // �˳�
            System.exit(1);
        }


    }

}
