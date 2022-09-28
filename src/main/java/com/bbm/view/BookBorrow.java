package com.bbm.view;

import com.bbm.db.BookDao;
import com.bbm.db.BorrowBookDao;
import com.bbm.model.Book;
import com.bbm.model.BorrowBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookBorrow extends JFrame implements ActionListener {
    private JPanel panel, ReaderConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JTextField txtReaderName,txtReaderType,txtReaderID, txtISBN, txtAuthor,txtTypeName, txtBookName,txtPublish,txtPublishdate,txtPrice ,txtBorrowDate,txtUser ;

    private JLabel labISBN, labBookName, labAuthor,labTypeName, labPublish,labPublishDate,labPrice,labBorrowDate,labUser;

    private JButton btnClose, btnBorrow;

    private JTable table;

    private JScrollPane scrollPane;


    public BookBorrow(){
        setTitle("ͼ�����");//���ñ���
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
        bookPane=new JPanel(new GridLayout(5,2));

        labISBN =new JLabel("ISBN:");
        labTypeName = new JLabel("���:");
        labBookName =new JLabel("����:");
        labAuthor =new JLabel("����:");
        labPublish =new JLabel("������:");
        labPublishDate = new JLabel("��������:");
        labPrice = new JLabel("����:");
        labBorrowDate = new JLabel("��ǰ����:");
        labUser = new JLabel("�����û�:");

        txtISBN =new JTextField(8);
        txtTypeName =new JTextField(8);
        txtBookName =new JTextField(8);
        txtAuthor =new JTextField(8);
        txtPublish =new JTextField(8);
        txtPublishdate = new JTextField(8);
        txtPrice =new JTextField(8) ;
        txtBorrowDate  = new JTextField(8);
        txtUser = new JTextField(8);

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

        bookPane.add(labUser);
        labUser.setHorizontalAlignment(SwingConstants.CENTER);
        bookPane.add(txtUser);


        centerPanel.add(selectResultPane);
        centerPanel.add(bookPane);
        panel.add(centerPanel,BorderLayout.CENTER);


        btnPanel=new JPanel();

        btnBorrow = new JButton("����");
        btnClose =new JButton("�ر�");

        btnBorrow.addActionListener(this);
        btnClose.addActionListener(this);


        btnPanel.add(btnBorrow);
        btnPanel.add(btnClose);


        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookBorrow();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBorrow){
            String readerid=txtReaderID.getText();
            String ISBN=txtISBN.getText();
            String borrowDate = txtBorrowDate.getText();
            int ret = BorrowBookDao.borrowBook(readerid,ISBN,borrowDate);
            if(ret==1)
                JOptionPane.showMessageDialog(null, "���ĳɹ�");
            else
                JOptionPane.showMessageDialog(null, "����ʧ��");
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
