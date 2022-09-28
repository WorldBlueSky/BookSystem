package com.bbm.staticview;

import javax.swing.*;

public class UserAdd extends JFrame {
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

}
