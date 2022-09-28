package com.bbm.staticview;

import javax.swing.*;

public class UpdatePassword extends JFrame {

    private JPanel myPanel;
    private JLabel labName,labPassword,labNewPassword,labConfirmPassword;
    private JTextField txtName;
    private JPasswordField txtPassword,txtNewPassword,txtConfirmPassword;
    private JButton btnConfirm, btnCancel;

    public  UpdatePassword(String name){
        super(name);//����������
        setSize(250,250);
        setLocationRelativeTo(null);
        myPanel=new JPanel();
        setContentPane(myPanel);

         // �����ǩ
        labName=new JLabel("�û�����");
        labName.setHorizontalAlignment(SwingConstants.CENTER);

        labPassword=new JLabel("ԭ���룺");
        labPassword.setHorizontalAlignment(SwingConstants.CENTER);

        labNewPassword = new JLabel("������");
        labNewPassword.setHorizontalAlignment(SwingConstants.CENTER);

        labConfirmPassword = new JLabel("ȷ��������");
        labConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        // ԭ�û���
        txtName=new JTextField(12);

        // ԭ����
        txtPassword=new JPasswordField(12);
        txtPassword.setEchoChar('*');

        // ������
        txtNewPassword = new JPasswordField(12);
        txtPassword.setEchoChar('*');

        //ȷ��������
        txtConfirmPassword = new JPasswordField(12);
        txtConfirmPassword.setEchoChar('*');

        btnConfirm=new JButton("ȷ��");
        btnCancel =new JButton("ȡ��");

        // ���������
        myPanel.add(labName);
        myPanel.add(txtName);

        myPanel.add(labPassword);
        myPanel.add(txtPassword);

        myPanel.add(labNewPassword);
        myPanel.add(txtNewPassword);

        myPanel.add(labConfirmPassword);
        myPanel.add(txtConfirmPassword);

        myPanel.add(btnConfirm);
        myPanel.add(btnCancel);

        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new UpdatePassword("�޸�����");
    }

}
