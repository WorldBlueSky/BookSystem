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
        setTitle("图书归还");//设置标题
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
        List<BorrowBook> list = BorrowBookDao.selectBorrowBook();

        Object[][] r1=getSelect(list);
        String[] colName= {"图书编号","图书名称","借书日期"};
        table = new JTable(r1,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);


        // 底部面板
        bookPane=new JPanel(new GridLayout(6,2));

        labISBN =new JLabel("ISBN:");
        labTypeName = new JLabel("类别:");
        labBookName =new JLabel("书名:");
        labAuthor =new JLabel("作者:");
        labPublish =new JLabel("出版社:");
        labPublishDate = new JLabel("出版日期:");
        labPrice = new JLabel("单价:");
        labBorrowDate = new JLabel("当前日期:");
        labUser = new JLabel("操作用户:");
        labReturnDate = new JLabel("归还日期:");
        labFine = new JLabel("罚金:");

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

        btnReturn = new JButton("归还");
        btnClose =new JButton("关闭");

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
                JOptionPane.showMessageDialog(null, "归还成功");
            else
                JOptionPane.showMessageDialog(null, "归还失败");
        }

        if(e.getSource()==btnClose){
            System.exit(1);
        }
    }

    //把查询的结果放到一个二维数组中，目的是要放到JTable中
    Object[][] getSelect(List<BorrowBook> list){
        String[] colName= {"图书编号","图书名称","借书日期"};
        //定义一个包含多行7列的二维数据：行根据list来判断
        Object[][] results=new Object[list.size()][colName.length];
        //将list中的每一个Book中的各个列放到二维数据的各个行中
        for(int i=0;i<list.size();i++){
            BorrowBook borrowBook = list.get(i);
            results[i][0]= borrowBook.getISBN();
            results[i][1]=borrowBook.getBookname();
            results[i][2]=borrowBook.getBorrowdate();
        }
        return results;
    }

}
