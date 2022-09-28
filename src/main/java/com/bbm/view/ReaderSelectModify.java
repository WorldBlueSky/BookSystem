package com.bbm.view;

import com.bbm.db.BookDao;
import com.bbm.db.ReaderDao;
import com.bbm.model.Book;
import com.bbm.model.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class  ReaderSelectModify extends JFrame implements ActionListener {
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
//        table=new JTable();

        // �ڼ���ű���ʱ��ֱ�Ӳ�ѯ���ݿ⣬Ȼ�� ���ı�־�У������ݿ��е���Ϣһ��Ž�ȥ
        String name=cmbChoice.getSelectedItem().toString();
        String value=txtSelect.getText();
        Object[][] r1=getSelect(ReaderDao.selectReader(name,value));
        String[] colName= {"���","����","�Ա�", "����","�绰","����","ע������","���"};

        table = new JTable(r1,colName);

        scrollPane=new JScrollPane(table); // �������������ϵ
        scrollPane.setViewportView(table);//�����������ϵ����

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
        btnDelete = new JButton("ɾ��");
        btnExit=new JButton("�˳�");

        btnPanel.add(btnModify);
        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        panel.add(btnPanel,BorderLayout.SOUTH);

        // �������
        btnSelect.addActionListener(this);
        btnDelete.addActionListener(this);
        btnModify.addActionListener(this);
        btnExit.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ReaderSelectModify();
    }


    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnExit){//�˳�
            System.exit(1);
        }

        if(e.getSource()==btnDelete){//ɾ��
            String readerid=txtReaderID.getText().trim();
            //����ReaderDao�е�deleteReader������������Ӱ�������
            int ret= ReaderDao.deleteReader(readerid);
            if(ret==1)
                JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
            else
                JOptionPane.showMessageDialog(null, "û�ɹ�");
        }


        // ������ �����޸�����ʧ�ܣ�����book�����Ա�֮����ԭ���Ļ����ϸ�reader�����һ���ֶ� typename
        if(e.getSource()==btnModify){//�޸�
            Reader reader = new Reader();

            reader.setReaderid(txtReaderID.getText());
            reader.setName(txtName.getText());
            reader.setSex(txtSex.getText());
            reader.setAge(Integer.valueOf(txtAge.getText())); // ���ı����е�String����ת���� int����
            reader.setPhone(txtPhone.getText());
            reader.setDept(txtDept.getText());
            reader.setRegdate(txtRegisterDate.getText());

            String typename = cmbType.getSelectedItem().toString().trim();
            reader.setTypename(typename);

            int ret= ReaderDao.updateReader(reader);

            if(ret==1){
                JOptionPane.showMessageDialog(null, "�ɹ�");
            } else{
                JOptionPane.showMessageDialog(null, "���ɹ�");
            }
        }

        if(e.getSource()==btnSelect){
            //��ѯ
            String name=cmbChoice.getSelectedItem().toString();
            String value=txtSelect.getText();
            Object[][] r1=getSelect(ReaderDao.selectReader(name,value));
            String[] colName= {"���","����","�Ա�","����","�绰","����","ע������","���"};
            table=new JTable(r1,colName);//���е�����
            scrollPane.setViewportView(table);//�����������ϵ����
        }
    }


    //�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
    private Object[][] getSelect(List<Reader> list){

        String[] colName= {"���","����","�Ա�","����","�绰","����","ע������","���"};

        //����һ����������8�еĶ�ά���ݣ��и���list���ж�
        Object[][] results=new Object[list.size()][colName.length];

        //��list�е�ÿһ��Reader�еĸ����зŵ���ά���ݵĸ�������
        for(int i=0;i<list.size();i++){
           Reader reader = list.get(i);//��ȡlist�е�ÿһ��reader
            results[i][0]=reader.getReaderid();
            results[i][1]=reader.getName();
            results[i][2]=reader.getSex();
            results[i][3]=reader.getAge();
            results[i][4]=reader.getPhone();
            results[i][5]=reader.getDept();
            results[i][6]=reader.getRegdate();
            results[i][7]=reader.getTypename();
        }

        return results;
    }

}


