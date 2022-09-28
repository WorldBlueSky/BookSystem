package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class  ReaderSelectModify extends JFrame {
    private JPanel panel,selectConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JComboBox cmbChoice,cmbType;

    private JTextField txtSelect, txtReaderID, txtSex, txtAge,
            txtPhone, txtDept, txtRegisterDate,txtName;

    private JLabel labReaderID,labType, labSex, labAge,
            labPhone, labDept, labRegisterDate,labName;

    private JButton btnSelect,btnModify,btnDelete,btnExit;

    private JTable table;

    private JScrollPane scrollPane;


    public ReaderSelectModify(){
        setTitle("读者管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);

        // 顶部的框
        selectConditionPane=new JPanel();
        cmbChoice=new JComboBox();
        cmbChoice.addItem("全部");
        cmbChoice.addItem("读者编号");
//        cmbChoice.addItem("读者名字");
        txtSelect=new JTextField(20);
        btnSelect=new JButton("查询");

        selectConditionPane.add(cmbChoice);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);

        panel.add(selectConditionPane,BorderLayout.NORTH);
        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
        table=new JTable();
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);


        //4行4列，需要创建每个组件，加到bookPane中，另外6个课后完成
        bookPane=new JPanel(new GridLayout(4,4));
        labReaderID =new JLabel("编号:");
        labName = new JLabel("姓名:");
        labType=new JLabel("类别:");
        labSex =new JLabel("性别:");
        labAge =new JLabel("年龄:");
        labPhone =new JLabel("电话:");
        labDept =new JLabel("所在部门:");
        labRegisterDate =new JLabel("注册日期:");
        txtReaderID =new JTextField(8);

        cmbType=new JComboBox();
        cmbType.addItem("教师");
        cmbType.addItem("学生");

        txtSex =new JTextField(8);
        txtAge =new JTextField(8);
        txtPhone =new JTextField(8);
        txtDept =new JTextField(8);
        txtRegisterDate =new JTextField(8);
        txtName = new JTextField(8);


        bookPane.add(labReaderID);
        labReaderID.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtReaderID);

        bookPane.add(labName);
        labName.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtName);

        bookPane.add(labType);
        labType.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(cmbType);


        bookPane.add(labSex);
        labSex.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtSex);


        bookPane.add(labAge);
        labAge.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtAge);


        bookPane.add(labPhone);
        labPhone.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtPhone);


        bookPane.add(labDept);
        labDept.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtDept);


        bookPane.add(labRegisterDate);
        labRegisterDate.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtRegisterDate);


        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);
        btnPanel=new JPanel();

        btnModify=new JButton("修改");
        btnExit=new JButton("退出");

        btnPanel.add(btnModify);
        btnPanel.add(btnExit);
        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ReaderSelectModify();
    }

}
