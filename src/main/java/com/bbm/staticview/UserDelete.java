package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class UserDelete extends JFrame {
    private JPanel panel,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JButton btnDelete,btnExit;

    private JTable table;

    private JScrollPane scrollPane;


    public UserDelete(){
        setTitle("删除用户");//设置标题
        setSize(500,400);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);


        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel(); // 查询面板
        table=new JTable();  // 表单
        scrollPane=new JScrollPane(table);  // 把表单加入查询面板
        scrollPane.setPreferredSize(new Dimension(400,300));//设查询面板的大小
        selectResultPane.add(scrollPane);

        // 给下面的按钮布局
        bookPane=new JPanel(new GridLayout(1,2));

        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);

        btnPanel=new JPanel();


        btnDelete=new JButton("删除");
        btnExit=new JButton("退出");


        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new UserDelete();
    }

}
