package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class  BookTypeManage extends JFrame {
    private JPanel panel,selectConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JComboBox cmbChoice,cmbType;

    private JTextField txtSelect, txtBookTypeID, txtBookTypeName;

    private JLabel labBookTypeID,labBookTypeName;

    private JButton btnSelect,btnModify,btnDelete,btnExit,binInsert;

    private JTable table;

    private JScrollPane scrollPane;


    public BookTypeManage(){
        setTitle("图书类型管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("图书类型");
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

        labBookTypeID =new JLabel("图书类型编号:");
        labBookTypeName = new JLabel("图书类型名称:");


        txtBookTypeID =new JTextField(13);
        txtBookTypeName =new JTextField(13);


        bookPane.add(labBookTypeID);
        labBookTypeID.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtBookTypeID);

        bookPane.add(labBookTypeName);
        labBookTypeName.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtBookTypeName);



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
        new BookTypeManage();
    }

}
