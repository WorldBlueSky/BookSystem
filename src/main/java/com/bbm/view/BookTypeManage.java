package com.bbm.view;

import com.bbm.db.BookDao;
import com.bbm.db.BookTypeDao;
import com.bbm.db.ReaderDao;
import com.bbm.model.Book;
import com.bbm.model.BookType;
import com.bbm.model.Reader;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class  BookTypeManage extends JFrame implements ActionListener {
    private JPanel panel,selectConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JComboBox cmbChoice,cmbType;

    private JTextField txtSelect, txtBookTypeID, txtBookTypeName;

    private JLabel labBookTypeID,labBookTypeName;

    private JButton btnSelect,btnModify,btnDelete,btnExit, btnInsert;

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

        // �� ��ѯ���ݿ⣬��������
        // TODO

        Object[][] r = getSelect(BookTypeDao.selectBookType());
        String[] colName= {"ͼ�����ͱ��","ͼ����������"};
        table = new JTable(r,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//���С
        selectResultPane.add(scrollPane);


        scrollPane.setViewportView(table);//�����������ϵ����



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

        btnInsert = new JButton("���");
        btnModify=new JButton("�޸�");
        btnDelete=new JButton("ɾ��");
        btnExit=new JButton("�˳�");

        btnPanel.add(btnInsert);
        btnPanel.add(btnModify);
        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        btnInsert.addActionListener(this);
        btnDelete.addActionListener(this);
        btnModify.addActionListener(this);
        btnSelect.addActionListener(this);
        btnExit.addActionListener(this);


        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BookTypeManage();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== btnInsert){
           String typeid = txtBookTypeID.getText().trim();
           String typename = txtBookTypeName.getText().trim();
           BookType bookType = new BookType();
           bookType.setTypeid(Integer.valueOf(typeid));
           bookType.setTypename(typename);

           int ret = BookTypeDao.insertBookType(bookType);
           if(ret==1){
               JOptionPane.showMessageDialog(null,"���ӳɹ�!");
           }else{
               JOptionPane.showMessageDialog(null,"����ʧ��!");
           }
        }

        if(e.getSource()==btnDelete){
           // ��ȡ����� ͼ�����ͱ�ţ�����booktypeDao��delete ��������ɾ��
            String typeid = txtBookTypeID.getText().trim();
            int id =Integer.valueOf(typeid);
            int ret = BookTypeDao.deleteBookType(id);
            if(ret==1){
                JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
            }else{
                JOptionPane.showMessageDialog(null,"ɾ��ʧ��!");
            }
        }

        if(e.getSource()==btnModify){//�޸�
            BookType bookType = new BookType();
            bookType.setTypename(txtBookTypeName.getText().trim());
            bookType.setTypeid(Integer.valueOf(txtBookTypeID.getText().trim()));

            int i = BookTypeDao.updateBookType(bookType);
            if(i>0)
                JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");
            else
                JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
        }

        if(e.getSource()==btnSelect){
           String x = txtSelect.getText().trim();

           if(x.equals("")){
               Object[][] r = getSelect(BookTypeDao.selectBookType());
               String[] colName= {"ͼ�����ͱ��","ͼ����������"};
               table = new JTable(r,colName);
               scrollPane.setViewportView(table);//�����������ϵ����

           }else{
               int numx = Integer.valueOf(x);
               Object[][] r = getSelect(BookTypeDao.selectBookTypeById(numx));
               String[] colName= {"ͼ�����ͱ��","ͼ����������"};
               table = new JTable(r,colName);
               scrollPane.setViewportView(table);//�����������ϵ����
           }


        }

        if(e.getSource()==btnExit){
            System.exit(1);
        }
    }

    //�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
    private Object[][] getSelect(List<BookType> list){

        String[] colName= {"ͼ�����ͱ��","ͼ����������"};

        //����һ����������2�еĶ�ά���ݣ��и���list���ж�
        Object[][] results=new Object[list.size()][colName.length];

        //��list�е�ÿһ��Reader�еĸ����зŵ���ά���ݵĸ�������
        for(int i=0;i<list.size();i++){
            BookType bookType= list.get(i);//��ȡlist�е�ÿһ��reader
            results[i][0]= bookType.getTypeid();
            results[i][1]=bookType.getTypename();
        }

        return results;
    }

}
