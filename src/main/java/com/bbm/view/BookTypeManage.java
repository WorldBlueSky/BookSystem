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
        setTitle("图书类型管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("图书类型");
        btnSelect=new JButton("查询");

        selectConditionPane.add(labSelect);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);
        panel.add(selectConditionPane,BorderLayout.NORTH);

        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
        table=new JTable();

        // 表单 查询数据库，插入数据
        // TODO

        Object[][] r = getSelect(BookTypeDao.selectBookType());
        String[] colName= {"图书类型编号","图书类型名称"};
        table = new JTable(r,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);


        scrollPane.setViewportView(table);//表与滚动条联系起来



        bookPane=new JPanel(new GridLayout(2,4));

        labBookTypeID =new JLabel("图书类型编号:");
        labBookTypeName = new JLabel("图书类型名称:");


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

        btnInsert = new JButton("添加");
        btnModify=new JButton("修改");
        btnDelete=new JButton("删除");
        btnExit=new JButton("退出");

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
               JOptionPane.showMessageDialog(null,"增加成功!");
           }else{
               JOptionPane.showMessageDialog(null,"增加失败!");
           }
        }

        if(e.getSource()==btnDelete){
           // 读取输入的 图书类型编号，调用booktypeDao的delete 方法进行删除
            String typeid = txtBookTypeID.getText().trim();
            int id =Integer.valueOf(typeid);
            int ret = BookTypeDao.deleteBookType(id);
            if(ret==1){
                JOptionPane.showMessageDialog(null,"删除成功!");
            }else{
                JOptionPane.showMessageDialog(null,"删除失败!");
            }
        }

        if(e.getSource()==btnModify){//修改
            BookType bookType = new BookType();
            bookType.setTypename(txtBookTypeName.getText().trim());
            bookType.setTypeid(Integer.valueOf(txtBookTypeID.getText().trim()));

            int i = BookTypeDao.updateBookType(bookType);
            if(i>0)
                JOptionPane.showMessageDialog(null, "修改成功!");
            else
                JOptionPane.showMessageDialog(null, "修改失败!");
        }

        if(e.getSource()==btnSelect){
           String x = txtSelect.getText().trim();

           if(x.equals("")){
               Object[][] r = getSelect(BookTypeDao.selectBookType());
               String[] colName= {"图书类型编号","图书类型名称"};
               table = new JTable(r,colName);
               scrollPane.setViewportView(table);//表与滚动条联系起来

           }else{
               int numx = Integer.valueOf(x);
               Object[][] r = getSelect(BookTypeDao.selectBookTypeById(numx));
               String[] colName= {"图书类型编号","图书类型名称"};
               table = new JTable(r,colName);
               scrollPane.setViewportView(table);//表与滚动条联系起来
           }


        }

        if(e.getSource()==btnExit){
            System.exit(1);
        }
    }

    //把查询的结果放到一个二维数组中，目的是要放到JTable中
    private Object[][] getSelect(List<BookType> list){

        String[] colName= {"图书类型编号","图书类型名称"};

        //定义一个包含多行2列的二维数据：行根据list来判断
        Object[][] results=new Object[list.size()][colName.length];

        //将list中的每一个Reader中的各个列放到二维数据的各个行中
        for(int i=0;i<list.size();i++){
            BookType bookType= list.get(i);//获取list中的每一个reader
            results[i][0]= bookType.getTypeid();
            results[i][1]=bookType.getTypename();
        }

        return results;
    }

}
