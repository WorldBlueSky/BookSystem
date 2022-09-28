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

    // 标签
    private JLabel labReaderID, labName,labType, labSex, labAge,
            labPhone, labDept, labRegisterDate;

    // 文本属性
    private JTextField txtReaderID,txtName, txtSex,
            txtAge, txtPhone,txtDept,txtRegisterDate;

    JComboBox cmbType;//组合框

    // 组件按钮
    private JButton btnAdd,btnReset,btnExit;


    public ReaderAdd(String s){
        super(s);
        setSize(400,200);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);
        //图书面板的信息
        GridLayout grid1=new GridLayout(4,4);//网格布局
        grid1.setHgap(5);
        grid1.setVgap(5);
        bookPanel=new JPanel(grid1);

        labReaderID =new JLabel("编号:");
        labReaderID.setHorizontalAlignment(SwingConstants.CENTER);//居中
        txtReaderID =new JTextField(15);

        labName = new JLabel("姓名:");
        labName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName=new JTextField(12);

        labType =new JLabel("类别：");
        labType.setHorizontalAlignment(SwingConstants.CENTER);
        cmbType =new JComboBox();
        cmbType.addItem("教师");
        cmbType.addItem("学生");


        labSex =new JLabel("性别:");
        labSex.setHorizontalAlignment(SwingConstants.CENTER);
        txtSex =new JTextField(12);



        labAge =new JLabel("年龄:");
        labAge.setHorizontalAlignment(SwingConstants.CENTER);
        txtAge =new JTextField();

        labPhone =new JLabel("电话:");
        labPhone.setHorizontalAlignment(SwingConstants.CENTER);
        txtPhone =new JTextField(12);

        labDept =new JLabel("所在部门:");
        labDept.setHorizontalAlignment(SwingConstants.CENTER);
        txtDept = new JTextField(12);

        labRegisterDate =new JLabel("注册日期:");
        labRegisterDate.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegisterDate =new JTextField(12);

        // 注册日期
        //TODO

        //其余类似，作者，出版社，出版社日期，价格，课后大家补充。
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

        // 注册日期
        //TODO

        //将各组件加入到面板
        panel.add(bookPanel,BorderLayout.CENTER);
        btnPanel=new JPanel();
        btnAdd=new JButton("增加");
        btnReset=new JButton("重置");
        btnExit=new JButton("退出");

        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
        btnReset.addActionListener(this);

        btnPanel.add(btnAdd);
        btnPanel.add(btnReset);
        btnPanel.add(btnExit);

        // 监听



        panel.add(btnPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        new ReaderAdd("读者信息添加");

    }

    public void actionPerformed(ActionEvent e){

        //重置和退出课后完成

        if(e.getSource()==btnAdd){//增加

            Reader reader = new Reader();

            reader.setReaderid(txtReaderID.getText());
            reader.setName(txtName.getText());
            reader.setSex(txtSex.getText());
            reader.setAge(Integer.valueOf(txtAge.getText())); // 将文本框中的String类型转化成 int类型
            reader.setPhone(txtPhone.getText());
            reader.setDept(txtDept.getText());
            reader.setRegdate(txtRegisterDate.getText());

            String typeName=cmbType.getSelectedItem().toString().trim();


            int ret= ReaderDao.insertReader(reader, typeName);

            if(ret==1){
                JOptionPane.showMessageDialog(null, "成功");
            } else{
                JOptionPane.showMessageDialog(null, "不成功");
            }

        }

        if(e.getSource()==btnExit){//退出
            System.exit(1);
        }


        if(e.getSource()==btnReset) {// 重置
            //清除文本框输入的内容
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
