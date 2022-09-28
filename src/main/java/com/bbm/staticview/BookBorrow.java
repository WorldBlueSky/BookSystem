package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class BookBorrow extends JFrame {
    private JPanel panel, ReaderConditionPane,btnPanel,
            centerPanel,selectResultPane,bookPane;

    private JTextField txtReaderName,txtReaderType,txtReaderID, txtISBN, txtAuthor,txtTypeName, txtBookName,txtPublish,txtPublishdate,txtPrice ,txtBorrowDate,txtUser ;

    private JLabel labISBN, labBookName, labAuthor,labTypeName, labPublish,labPublishDate,labPrice,labBorrowDate,labUser;

    private JButton btnClose, binBorrow;

    private JTable table;

    private JScrollPane scrollPane;

    public BookBorrow(){
        setTitle("图书借阅");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);

        // 设置顶部面板

        ReaderConditionPane =new JPanel();

        JLabel labReaderID = new JLabel("读者编号:");
        txtReaderID =new JTextField(8);

        ReaderConditionPane.add(labReaderID);
        ReaderConditionPane.add(txtReaderID);

        JLabel labReaderName = new JLabel("读者姓名:");
        txtReaderName = new JTextField(8);

        ReaderConditionPane.add(labReaderName);
        ReaderConditionPane.add(txtReaderName);

        JLabel labReaderType = new JLabel("读者类别:");
        txtReaderType = new JTextField(8);

        ReaderConditionPane.add(labReaderType);
        ReaderConditionPane.add(txtReaderType);

        panel.add(ReaderConditionPane,BorderLayout.NORTH);

        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
        table=new JTable();
        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);


        // 底部面板
        bookPane=new JPanel(new GridLayout(5,2));

        labISBN =new JLabel("ISBN:");
        labTypeName = new JLabel("类别:");
        labBookName =new JLabel("书名:");
        labAuthor =new JLabel("作者:");
        labPublish =new JLabel("出版社:");
        labPublishDate = new JLabel("出版日期:");
        labPrice = new JLabel("单价:");
        labBorrowDate = new JLabel("当前日期:");
        labUser = new JLabel("操作用户:");

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

        binBorrow = new JButton("借阅");
        btnClose =new JButton("关闭");


        btnPanel.add(binBorrow);
        btnPanel.add(btnClose);


        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BookBorrow();
    }

}
