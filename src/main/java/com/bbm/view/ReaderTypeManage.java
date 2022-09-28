package com.bbm.view;

import com.bbm.db.BookTypeDao;
import com.bbm.db.ReaderTypeDao;
import com.bbm.model.BookType;
import com.bbm.model.ReaderType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReaderTypeManage extends JFrame implements ActionListener {
    private JPanel panel,selectConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JComboBox cmbChoice,cmbType;

    private JTextField txtSelect, txtTypeID, txtLimit,txtTypeName,txtMaxBorrowNum;

    private JLabel labTypeID, labMaxBorrowNum, labLimit,labTypeName,labSelect;

    private JButton btnSelect,btnModify,btnDelete,btnExit, btnInsert;

    private JTable table;

    private JScrollPane scrollPane;


    public ReaderTypeManage(){
        setTitle("�������͹���");//���ñ���
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("��������");
        btnSelect=new JButton("��ѯ");

        selectConditionPane.add(labSelect);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);
        panel.add(selectConditionPane,BorderLayout.NORTH);

        //�м����
        centerPanel=new JPanel();
        selectResultPane=new JPanel();

        // ����ѯ���ݿ� ��չʾ��Ϣ
        table=new JTable();

        String[] colName= {"�������ͱ��","������������","�ɽ�ͼ������","�ɽ�ͼ������"};

        Object[][] r = getSelect(ReaderTypeDao.selectReaderType());
        table = new JTable(r,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//���С
        selectResultPane.add(scrollPane);



        bookPane=new JPanel(new GridLayout(2,4));

        labTypeID =new JLabel("�������ͱ��:");
        labTypeName = new JLabel("������������:");
        labMaxBorrowNum =new JLabel("�ɽ�ͼ������:");
        labLimit =new JLabel("�ɽ�ͼ������:");

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

        btnInsert = new JButton("���");
        btnModify=new JButton("�޸�");
        btnDelete=new JButton("ɾ��");
        btnExit=new JButton("�˳�");

        btnPanel.add(btnInsert);
        btnPanel.add(btnModify);
        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        btnInsert.addActionListener(this);
        btnModify.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        btnSelect.addActionListener(this);



        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ReaderTypeManage();
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()== btnInsert){
            ReaderType readerType = new ReaderType();
            readerType.setTypeid(Integer.valueOf(txtTypeID.getText()));
            readerType.setTypename(txtTypeName.getText().trim());
            readerType.setMaxborrownum(Integer.valueOf(txtMaxBorrowNum.getText().trim()));
            readerType.setLimit(Integer.valueOf(txtLimit.getText().trim()));

            int ret = ReaderTypeDao.insertReaderType(readerType);
            if(ret==1){
                JOptionPane.showMessageDialog(null,"���ӳɹ�!");
            }else{
                JOptionPane.showMessageDialog(null,"����ʧ��!");
            }
        }

        if(e.getSource()==btnDelete){
            // ��ȡ����� ͼ�����ͱ�ţ�����readertypeDao��delete ��������ɾ��

            String id = txtTypeID.getText().trim();

            int ret = ReaderTypeDao.deleteReaderType(Integer.valueOf(id));
            if(ret==1){
                JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
            }else{
                JOptionPane.showMessageDialog(null,"ɾ��ʧ��!");
            }
        }

        if(e.getSource()==btnModify){//�޸�
          ReaderType readerType = new ReaderType();
            readerType.setTypeid(Integer.valueOf(txtTypeID.getText()));
            readerType.setTypename(txtTypeName.getText().trim());
            readerType.setMaxborrownum(Integer.valueOf(txtMaxBorrowNum.getText().trim()));
            readerType.setLimit(Integer.valueOf(txtLimit.getText().trim()));

            int i = ReaderTypeDao.updateReaderType(readerType,readerType.getTypeid());
            if(i>0)
                JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
            else
                JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
        }

        if(e.getSource()==btnSelect){
            String x = txtSelect.getText().trim();

            if(x.equals("")){
                Object[][] r = getSelect(ReaderTypeDao.selectReaderType());
                String[] colName= {"�������ͱ��","������������","�ɽ�ͼ������","�ɽ�ͼ������"};
                table = new JTable(r,colName);
                scrollPane.setViewportView(table);//�����������ϵ����

            }else{
                int numx = Integer.valueOf(x);
                String[] colName= {"�������ͱ��","������������","�ɽ�ͼ������","�ɽ�ͼ������"};
                Object[][] r = getSelect(ReaderTypeDao.selectReaderTypeById(numx));
                table = new JTable(r,colName);
                scrollPane.setViewportView(table);//�����������ϵ����
            }
        }

        if(e.getSource()==btnExit){
            System.exit(1);
        }
    }

    //�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
    private Object[][] getSelect(List<ReaderType> list){

        String[] colName= {"�������ͱ��","������������","�ɽ�ͼ������","�ɽ�ͼ������"};

        //����һ����������4�еĶ�ά���ݣ��и���list���ж�
        Object[][] results=new Object[list.size()][colName.length];

        //��list�е�ÿһ��Reader�еĸ����зŵ���ά���ݵĸ�������
        for(int i=0;i<list.size();i++){
            ReaderType readerType = list.get(i);//��ȡlist�е�ÿһ��reader
            results[i][0]= readerType.getTypeid();
            results[i][1]=readerType.getTypename();
            results[i][2]=readerType.getMaxborrownum();
            results[i][3]=readerType.getLimit();
        }

        return results;
    }

}
