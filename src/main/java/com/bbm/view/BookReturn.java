package com.bbm.view;

import com.bbm.db.BorrowBookDao;
import com.bbm.model.BorrowBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookReturn extends JFrame implements ActionListener {
    private JPanel panel, ReaderConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JTextField txtReaderName,txtReaderType,txtReaderID,
            txtISBN, txtAuthor,txtTypeName, txtBookName,txtPublish,
            txtPublishdate,txtPrice ,txtBorrowDate,txtUser,txtReturnDate,txtFine ;

    private JLabel labISBN, labBookName, labAuthor,labTypeName, labPublish,
            labPublishDate,labPrice,labBorrowDate,labUser,labReturnDate,labFine;

    private JButton btnClose, btnReturn;

    private JTable table;

    private JScrollPane scrollPane;


    public BookReturn(){
        setTitle("ͼ��黹");//���ñ���
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);

        // ���ö������

        ReaderConditionPane =new JPanel();

        JLabel labReaderID = new JLabel("���߱��:");
        txtReaderID =new JTextField(8);

        ReaderConditionPane.add(labReaderID);
        ReaderConditionPane.add(txtReaderID);

        JLabel labReaderName = new JLabel("��������:");
        txtReaderName = new JTextField(8);

        ReaderConditionPane.add(labReaderName);
        ReaderConditionPane.add(txtReaderName);

        JLabel labReaderType = new JLabel("�������:");
        txtReaderType = new JTextField(8);

        ReaderConditionPane.add(labReaderType);
        ReaderConditionPane.add(txtReaderType);

        panel.add(ReaderConditionPane,BorderLayout.NORTH);

        //�м����
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
        table=new JTable();
        List<BorrowBook> list = BorrowBookDao.selectBorrowBook();

        Object[][] r1=getSelect(list);
        String[] colName= {"ͼ����","ͼ������","��������"};
        table = new JTable(r1,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//���С
        selectResultPane.add(scrollPane);


        // �ײ����
        bookPane=new JPanel(new GridLayout(6,2));

        labISBN =new JLabel("ISBN:");
        labTypeName = new JLabel("���:");
        labBookName =new JLabel("����:");
        labAuthor =new JLabel("����:");
        labPublish =new JLabel("������:");
        labPublishDate = new JLabel("��������:");
        labPrice = new JLabel("����:");
        labBorrowDate = new JLabel("��ǰ����:");
        labUser = new JLabel("�����û�:");
        labReturnDate = new JLabel("�黹����:");
        labFine = new JLabel("����:");

        txtISBN =new JTextField(8);
        txtTypeName =new JTextField(8);
        txtBookName =new JTextField(8);
        txtAuthor =new JTextField(8);
        txtPublish =new JTextField(8);
        txtPublishdate = new JTextField(8);
        txtPrice =new JTextField(8) ;
        txtBorrowDate  = new JTextField(8);
        txtUser = new JTextField(8);
        txtReturnDate = new JTextField(8);
        txtFine = new JTextField(8);

        bookPane.add(labISBN);
        labISBN.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtISBN);

        bookPane.add(labTypeName);
        labTypeName.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtTypeName);

        bookPane.add(labBookName);
        labBookName.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtBookName);


        bookPane.add(labAuthor);
        labAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtAuthor);

        bookPane.add(labPublish);
        labPublish.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtPublish);

        bookPane.add(labPublishDate);
        labPublishDate.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtPublishdate);

        bookPane.add(labPrice);
        labPrice.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtPrice);

        bookPane.add(labBorrowDate);
        labBorrowDate.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtBorrowDate);

        //TODO
        bookPane.add(labReturnDate);
        labReturnDate.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtReturnDate);

        //TODO
        bookPane.add(labFine);
        labFine.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtFine);

        bookPane.add(labUser);
        labUser.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtUser);



        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);


        btnPanel=new JPanel();

        btnReturn = new JButton("�黹");
        btnClose =new JButton("�ر�");

        btnReturn.addActionListener(this);
        btnClose.addActionListener(this);

        btnPanel.add(btnReturn);
        btnPanel.add(btnClose);


        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BookReturn();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnReturn){
          String ISBN = txtISBN.getText();
          int ret = BorrowBookDao.returnBook(ISBN);
            if(ret==1)
                JOptionPane.showMessageDialog(null, "�黹�ɹ�");
            else
                JOptionPane.showMessageDialog(null, "�黹ʧ��");
        }

        if(e.getSource()==btnClose){
            System.exit(1);
        }
    }

    //�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
    Object[][] getSelect(List<BorrowBook> list){
        String[] colName= {"ͼ����","ͼ������","��������"};
        //����һ����������7�еĶ�ά���ݣ��и���list���ж�
        Object[][] results=new Object[list.size()][colName.length];
        //��list�е�ÿһ��Book�еĸ����зŵ���ά���ݵĸ�������
        for(int i=0;i<list.size();i++){
            BorrowBook borrowBook = list.get(i);
            results[i][0]= borrowBook.getISBN();
            results[i][1]=borrowBook.getBookname();
            results[i][2]=borrowBook.getBorrowdate();
        }
        return results;
    }

}
