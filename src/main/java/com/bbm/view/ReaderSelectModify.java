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
        setTitle("读者管理");//设置标题
        setSize(500,500);
        setLocationRelativeTo(null);
        panel=new JPanel(new BorderLayout());
        setContentPane(panel);

        // 顶部的框
        selectConditionPane=new JPanel();
        cmbChoice=new JComboBox();
        cmbChoice.addItem("全部");
        cmbChoice.addItem("读者编号");
//        cmbChoice.addItem("读者名字");
        txtSelect=new JTextField(20);
        btnSelect=new JButton("查询");

        selectConditionPane.add(cmbChoice);
        selectConditionPane.add(txtSelect);
        selectConditionPane.add(btnSelect);

        panel.add(selectConditionPane,BorderLayout.NORTH);
        //中间面板
        centerPanel=new JPanel();
        selectResultPane=new JPanel();
//        table=new JTable();

        // 在加入放表单的时候，直接查询数据库，然后将 表单的标志行，与数据库中的信息一块放进去
        String name=cmbChoice.getSelectedItem().toString();
        String value=txtSelect.getText();
        Object[][] r1=getSelect(ReaderDao.selectReader(name,value));
        String[] colName= {"编号","姓名","性别", "年龄","电话","部门","注册日期","类别"};

        table = new JTable(r1,colName);

        scrollPane=new JScrollPane(table); // 将滚动条与表联系
        scrollPane.setViewportView(table);//表与滚动条联系起来

        scrollPane.setPreferredSize(new Dimension(400,240));//设大小
        selectResultPane.add(scrollPane);


        //4行4列，需要创建每个组件，加到bookPane中，另外6个课后完成
        bookPane=new JPanel(new GridLayout(4,4));
        labReaderID =new JLabel("编号:");
        labName = new JLabel("姓名:");
        labType=new JLabel("类别:");
        labSex =new JLabel("性别:");
        labAge =new JLabel("年龄:");
        labPhone =new JLabel("电话:");
        labDept =new JLabel("所在部门:");
        labRegisterDate =new JLabel("注册日期:");
        txtReaderID =new JTextField(8);

        cmbType=new JComboBox();
        cmbType.addItem("教师");
        cmbType.addItem("学生");

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

        btnModify=new JButton("修改");
        btnDelete = new JButton("删除");
        btnExit=new JButton("退出");

        btnPanel.add(btnModify);
        btnPanel.add(btnDelete);
        btnPanel.add(btnExit);

        panel.add(btnPanel,BorderLayout.SOUTH);

        // 加入监听
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

        if(e.getSource()==btnExit){//退出
            System.exit(1);
        }

        if(e.getSource()==btnDelete){//删除
            String readerid=txtReaderID.getText().trim();
            //调用ReaderDao中的deleteReader方法，返回受影响的行数
            int ret= ReaderDao.deleteReader(readerid);
            if(ret==1)
                JOptionPane.showMessageDialog(null, "删除成功");
            else
                JOptionPane.showMessageDialog(null, "没成功");
        }


        // ！！！ 这里修改总是失败，我与book表经过对比之后，在原来的基础上给reader表加了一个字段 typename
        if(e.getSource()==btnModify){//修改
            Reader reader = new Reader();

            reader.setReaderid(txtReaderID.getText());
            reader.setName(txtName.getText());
            reader.setSex(txtSex.getText());
            reader.setAge(Integer.valueOf(txtAge.getText())); // 将文本框中的String类型转化成 int类型
            reader.setPhone(txtPhone.getText());
            reader.setDept(txtDept.getText());
            reader.setRegdate(txtRegisterDate.getText());

            String typename = cmbType.getSelectedItem().toString().trim();
            reader.setTypename(typename);

            int ret= ReaderDao.updateReader(reader);

            if(ret==1){
                JOptionPane.showMessageDialog(null, "成功");
            } else{
                JOptionPane.showMessageDialog(null, "不成功");
            }
        }

        if(e.getSource()==btnSelect){
            //查询
            String name=cmbChoice.getSelectedItem().toString();
            String value=txtSelect.getText();
            Object[][] r1=getSelect(ReaderDao.selectReader(name,value));
            String[] colName= {"编号","姓名","性别","年龄","电话","部门","注册日期","类别"};
            table=new JTable(r1,colName);//表中的数据
            scrollPane.setViewportView(table);//表与滚动条联系起来
        }
    }


    //把查询的结果放到一个二维数组中，目的是要放到JTable中
    private Object[][] getSelect(List<Reader> list){

        String[] colName= {"编号","姓名","性别","年龄","电话","部门","注册日期","类别"};

        //定义一个包含多行8列的二维数据：行根据list来判断
        Object[][] results=new Object[list.size()][colName.length];

        //将list中的每一个Reader中的各个列放到二维数据的各个行中
        for(int i=0;i<list.size();i++){
           Reader reader = list.get(i);//获取list中的每一个reader
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


