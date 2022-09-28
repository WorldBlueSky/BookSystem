package com.bbm.staticview;

import javax.swing.*;
import java.awt.*;

public class ReaderAdd extends JFrame {
    private JPanel panel,bookPanel,btnPanel;

    // ��ǩ
    private JLabel labReaderID, labName,labType, labSex, labAge,
            labPhone, labDept, labRegisterDate;

    // �ı�����
    private JTextField txtReaderID,txtName, txtSex,
            txtAge, txtPhone,txtDept,txtRegisterDate;

    JComboBox cmbType;//��Ͽ�

    // �����ť
    private JButton btnAdd,btnReset,btnExit;


    public ReaderAdd(String s){
        super(s);
        setSize(400,200);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        //ͼ��������Ϣ
        GridLayout grid1=new GridLayout(4,4);//���񲼾�
        grid1.setHgap(5);
        grid1.setVgap(5);
        bookPanel=new JPanel(grid1);

        labReaderID =new JLabel("���:");
        labReaderID.setHorizontalAlignment(SwingConstants.CENTER);//����
        txtReaderID =new JTextField(15);

        labName = new JLabel("����:");
        labName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName=new JTextField(12);

        labType =new JLabel("���");
        labType.setHorizontalAlignment(SwingConstants.CENTER);
        cmbType =new JComboBox();
        cmbType.addItem("��ʦ");
        cmbType.addItem("ѧ��");


        labSex =new JLabel("�Ա�:");
        labSex.setHorizontalAlignment(SwingConstants.CENTER);
        txtSex =new JTextField(12);



        labAge =new JLabel("����:");
        labAge.setHorizontalAlignment(SwingConstants.CENTER);
        txtAge =new JTextField();

        labPhone =new JLabel("�绰:");
        labPhone.setHorizontalAlignment(SwingConstants.CENTER);
        txtPhone =new JTextField(12);

        labDept =new JLabel("���ڲ���:");
        labDept.setHorizontalAlignment(SwingConstants.CENTER);
        txtDept = new JTextField(12);

        labRegisterDate =new JLabel("ע������:");
        labRegisterDate.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegisterDate =new JTextField(12);

        // ע������
        //TODO

        //�������ƣ����ߣ������磬���������ڣ��۸񣬿κ��Ҳ��䡣
        bookPanel.add(labReaderID);
        bookPanel.add(txtReaderID);
        bookPanel.add(labName);
        bookPanel.add(txtName);
        bookPanel.add(labType);
        bookPanel.add(cmbType);
        bookPanel.add(labSex);
        bookPanel.add(txtSex);
        bookPanel.add(labAge);
        bookPanel.add(txtAge);
        bookPanel.add(labPhone);
        bookPanel.add(txtPhone);
        bookPanel.add(labDept);
        bookPanel.add(txtDept);
        bookPanel.add(labRegisterDate);
        bookPanel.add(txtRegisterDate);

        // ע������
        //TODO

        //����������뵽���
        panel.add(bookPanel,BorderLayout.CENTER);
        btnPanel=new JPanel();
        btnAdd=new JButton("����");
        btnReset=new JButton("����");
        btnExit=new JButton("�˳�");
        btnPanel.add(btnAdd);
        btnPanel.add(btnReset);
        btnPanel.add(btnExit);
        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        new ReaderAdd("������Ϣ���");
    }

}
