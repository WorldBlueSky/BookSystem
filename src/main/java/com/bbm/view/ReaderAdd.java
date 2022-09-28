package com.bbm.view;

import com.bbm.db.BookDao;
import com.bbm.db.ReaderDao;
import com.bbm.model.Book;
import com.bbm.model.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderAdd extends JFrame implements ActionListener{
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

        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
        btnReset.addActionListener(this);

        btnPanel.add(btnAdd);
        btnPanel.add(btnReset);
        btnPanel.add(btnExit);

        // ����



        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        new ReaderAdd("������Ϣ���");

    }

    public void actionPerformed(ActionEvent e){

        //���ú��˳��κ����

        if(e.getSource()==btnAdd){//����

            Reader reader = new Reader();

            reader.setReaderid(txtReaderID.getText());
            reader.setName(txtName.getText());
            reader.setSex(txtSex.getText());
            reader.setAge(Integer.valueOf(txtAge.getText())); // ���ı����е�String����ת���� int����
            reader.setPhone(txtPhone.getText());
            reader.setDept(txtDept.getText());
            reader.setRegdate(txtRegisterDate.getText());

            String typeName=cmbType.getSelectedItem().toString().trim();


            int ret= ReaderDao.insertReader(reader, typeName);

            if(ret==1){
                JOptionPane.showMessageDialog(null, "�ɹ�");
            } else{
                JOptionPane.showMessageDialog(null, "���ɹ�");
            }

        }

        if(e.getSource()==btnExit){//�˳�
            System.exit(1);
        }


        if(e.getSource()==btnReset) {// ����
            //����ı������������
            txtReaderID.setText("");
            txtName.setText("");
            txtSex.setText("");
            txtAge.setText("");
            txtPhone.setText("");
            txtDept.setText("");
            txtRegisterDate.setText("");
        }

    }

}
