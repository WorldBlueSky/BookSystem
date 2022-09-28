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
        setTitle("���߹���");//���ñ���
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);

        // �����Ŀ�
        selectConditionPane=new JPanel();
        cmbChoice=new JComboBox();
        cmbChoice.addItem("ȫ��");
        cmbChoice.addItem("���߱��");
//        cmbChoice.addItem("��������");
        txtSelect=new JTextField(20);
        btnSelect=new JButton("��ѯ");

        selectConditionPane.add(cmbChoice);
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


        //4��4�У���Ҫ����ÿ��������ӵ�bookPane�У�����6���κ����
        bookPane=new JPanel(new GridLayout(4,4));
        labReaderID =new JLabel("���:");
        labName = new JLabel("����:");
        labType=new JLabel("���:");
        labSex =new JLabel("�Ա�:");
        labAge =new JLabel("����:");
        labPhone =new JLabel("�绰:");
        labDept =new JLabel("���ڲ���:");
        labRegisterDate =new JLabel("ע������:");
        txtReaderID =new JTextField(8);

        cmbType=new JComboBox();
        cmbType.addItem("��ʦ");
        cmbType.addItem("ѧ��");

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

        btnModify=new JButton("�޸�");
        btnExit=new JButton("�˳�");

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
