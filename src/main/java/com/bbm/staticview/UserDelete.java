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
        setTitle("ɾ���û�");//���ñ���
        setSize(500,400);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);


        //�м����
        centerPanel=new JPanel();
        selectResultPane=new JPanel(); // ��ѯ���
        table=new JTable();  // ��
        scrollPane=new JScrollPane(table);  // �ѱ������ѯ���
        scrollPane.setPreferredSize(new Dimension(400,300));//���ѯ���Ĵ�С
        selectResultPane.add(scrollPane);

        // ������İ�ť����
        bookPane=new JPanel(new GridLayout(1,2));

        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);

        btnPanel=new JPanel();


        btnDelete=new JButton("ɾ��");
        btnExit=new JButton("�˳�");


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
