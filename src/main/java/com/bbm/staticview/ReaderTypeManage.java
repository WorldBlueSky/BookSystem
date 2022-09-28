package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class ReaderTypeManage extends JFrame {
    private JPanel panel,selectConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JComboBox cmbChoice,cmbType;

    private JTextField txtSelect, txtTypeID, txtLimit,txtTypeName,txtMaxBorrowNum;

    private JLabel labTypeID, labMaxBorrowNum, labLimit,labTypeName,labSelect;

    private JButton btnSelect,btnModify,btnDelete,btnExit,binInsert;

    private JTable table;

    private JScrollPane scrollPane;


    public ReaderTypeManage(){
        setTitle("读者类型管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("读者类型");
        btnSelect=new JButton("查询");

        selectConditionPane.add(labSelect);
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

        bookPane=new JPanel(new GridLayout(2,4));

        labTypeID =new JLabel("读者类型编号:");
        labTypeName = new JLabel("读者类型名称:");
        labMaxBorrowNum =new JLabel("可借图书数量:");
        labLimit =new JLabel("可借图书期限:");

        txtTypeID =new JTextField(8);
        txtTypeName =new JTextField(8);
        txtMaxBorrowNum =new JTextField(8);
        txtLimit =new JTextField(8);

        bookPane.add(labTypeID);
        labTypeID.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtTypeID);

        bookPane.add(labTypeName);
        labTypeName.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtTypeName);

        bookPane.add(labMaxBorrowNum);
        labMaxBorrowNum.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtMaxBorrowNum);


        bookPane.add(labLimit);
        labLimit.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtLimit);




        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);

        btnPanel=new JPanel();

        binInsert = new JButton("添加");
        btnModify=new JButton("修改");
        btnDelete=new JButton("删除");
        btnExit=new JButton("退出");

        btnPanel.add(binInsert);
        btnPanel.add(btnModify);
        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ReaderTypeManage();
    }

}
