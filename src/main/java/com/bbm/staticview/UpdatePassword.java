package com.bbm.staticview;

import javax.swing.*;

public class UpdatePassword extends JFrame {

    private JPanel myPanel;
    private JLabel labName,labPassword,labNewPassword,labConfirmPassword;
    private JTextField txtName;
    private JPasswordField txtPassword,txtNewPassword,txtConfirmPassword;
    private JButton btnConfirm, btnCancel;

    public  UpdatePassword(String name){
        super(name);//框架类设标题
        setSize(250,250);
        setLocationRelativeTo(null);
        myPanel=new JPanel();
        setContentPane(myPanel);

         // 定义标签
        labName=new JLabel("用户名：");
        labName.setHorizontalAlignment(SwingConstants.CENTER);

        labPassword=new JLabel("原密码：");
        labPassword.setHorizontalAlignment(SwingConstants.CENTER);

        labNewPassword = new JLabel("新密码");
        labNewPassword.setHorizontalAlignment(SwingConstants.CENTER);

        labConfirmPassword = new JLabel("确认新密码");
        labConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        // 原用户名
        txtName=new JTextField(12);

        // 原密码
        txtPassword=new JPasswordField(12);
        txtPassword.setEchoChar('*');

        // 新密码
        txtNewPassword = new JPasswordField(12);
        txtPassword.setEchoChar('*');

        //确认新密码
        txtConfirmPassword = new JPasswordField(12);
        txtConfirmPassword.setEchoChar('*');

        btnConfirm=new JButton("确认");
        btnCancel =new JButton("取消");

        // 面板添加组件
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
        new UpdatePassword("修改密码");
    }

}
