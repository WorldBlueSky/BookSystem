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
        setTitle("ͼ�����͹���");//���ñ���
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("ͼ������");
        btnSelect=new JButton("��ѯ");

        selectConditionPane.add(labSelect);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);
        panel.add(selectConditionPane,BorderLayout.NORTH);

        //�м����
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
        table=new JTable();
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//���С
        selectResultPane.add(scrollPane);

        bookPane=new JPanel(new GridLayout(2,4));

        labBookTypeID =new JLabel("ͼ�����ͱ��:");
        labBookTypeName = new JLabel("ͼ����������:");


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

        binInsert = new JButton("���");
        btnModify=new JButton("�޸�");
        btnDelete=new JButton("ɾ��");
        btnExit=new JButton("�˳�");

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
