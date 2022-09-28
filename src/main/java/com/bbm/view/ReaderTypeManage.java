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
        setTitle("读者类型管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        selectConditionPane=new JPanel();

        txtSelect=new JTextField(20);
        JLabel labSelect = new JLabel("读者类型");
        btnSelect=new JButton("查询");

        selectConditionPane.add(labSelect);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);
        panel.add(selectConditionPane,BorderLayout.NORTH);

        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel();

        // 表单查询数据库 ，展示信息
        table=new JTable();

        String[] colName= {"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};

        Object[][] r = getSelect(ReaderTypeDao.selectReaderType());
        table = new JTable(r,colName);

        scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);



        bookPane=new JPanel(new GridLayout(2,4));

        labTypeID =new JLabel("读者类型编号:");
        labTypeName = new JLabel("读者类型名称:");
        labMaxBorrowNum =new JLabel("可借图书数量:");
        labLimit =new JLabel("可借图书期限:");

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

        btnInsert = new JButton("添加");
        btnModify=new JButton("修改");
        btnDelete=new JButton("删除");
        btnExit=new JButton("退出");

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
                JOptionPane.showMessageDialog(null,"增加成功!");
            }else{
                JOptionPane.showMessageDialog(null,"增加失败!");
            }
        }

        if(e.getSource()==btnDelete){
            // 读取输入的 图书类型编号，调用readertypeDao的delete 方法进行删除

            String id = txtTypeID.getText().trim();

            int ret = ReaderTypeDao.deleteReaderType(Integer.valueOf(id));
            if(ret==1){
                JOptionPane.showMessageDialog(null,"删除成功!");
            }else{
                JOptionPane.showMessageDialog(null,"删除失败!");
            }
        }

        if(e.getSource()==btnModify){//修改
          ReaderType readerType = new ReaderType();
            readerType.setTypeid(Integer.valueOf(txtTypeID.getText()));
            readerType.setTypename(txtTypeName.getText().trim());
            readerType.setMaxborrownum(Integer.valueOf(txtMaxBorrowNum.getText().trim()));
            readerType.setLimit(Integer.valueOf(txtLimit.getText().trim()));

            int i = ReaderTypeDao.updateReaderType(readerType,readerType.getTypeid());
            if(i>0)
                JOptionPane.showMessageDialog(null, "修改成功!");
            else
                JOptionPane.showMessageDialog(null, "修改失败!");
        }

        if(e.getSource()==btnSelect){
            String x = txtSelect.getText().trim();

            if(x.equals("")){
                Object[][] r = getSelect(ReaderTypeDao.selectReaderType());
                String[] colName= {"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};
                table = new JTable(r,colName);
                scrollPane.setViewportView(table);//表与滚动条联系起来

            }else{
                int numx = Integer.valueOf(x);
                String[] colName= {"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};
                Object[][] r = getSelect(ReaderTypeDao.selectReaderTypeById(numx));
                table = new JTable(r,colName);
                scrollPane.setViewportView(table);//表与滚动条联系起来
            }
        }

        if(e.getSource()==btnExit){
            System.exit(1);
        }
    }

    //把查询的结果放到一个二维数组中，目的是要放到JTable中
    private Object[][] getSelect(List<ReaderType> list){

        String[] colName= {"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};

        //定义一个包含多行4列的二维数据：行根据list来判断
        Object[][] results=new Object[list.size()][colName.length];

        //将list中的每一个Reader中的各个列放到二维数据的各个行中
        for(int i=0;i<list.size();i++){
            ReaderType readerType = list.get(i);//获取list中的每一个reader
            results[i][0]= readerType.getTypeid();
            results[i][1]=readerType.getTypename();
            results[i][2]=readerType.getMaxborrownum();
            results[i][3]=readerType.getLimit();
        }

        return results;
    }

}
