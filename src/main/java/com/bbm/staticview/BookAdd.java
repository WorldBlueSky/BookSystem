package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class BookAdd extends JFrame {
	private JPanel panel,bookPanel,btnPanel;
	private JLabel labISBN,labType,labName,labAuthor,
	labPublish,labPublishDate,labPrice;
	private JTextField txtISBN,txtName,txtAuthor,
	txtPublish,txtPublishDate,txtPrice;
	JComboBox cmbBookType;//组合框
	private JButton btnAdd,btnReset,btnExit;
	public BookAdd(String s)
	{
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
		labISBN=new JLabel("ISBN:");
		labISBN.setHorizontalAlignment(SwingConstants.CENTER);//居中
		txtISBN=new JTextField(15);
		labType=new JLabel("图书类别：");
		cmbBookType=new JComboBox();
		cmbBookType.addItem("计算机类");
		cmbBookType.addItem("外语类");
		labName=new JLabel("书名：");
		txtName=new JTextField(12);
		labAuthor=new JLabel("作者");
		txtAuthor=new JTextField(12);
		labPublish=new JLabel("出版社");
		txtPublish=new JTextField();
		labPublishDate=new JLabel("出版日期");
		txtPublishDate=new JTextField(12);
		labPrice=new JLabel("价格");
		txtPrice=new JTextField(12);
		//其余类似，作者，出版社，出版社日期，价格，课后大家补充。
		bookPanel.add(labISBN);
		bookPanel.add(txtISBN);
		bookPanel.add(labType);
		bookPanel.add(cmbBookType);
		bookPanel.add(labName);
		bookPanel.add(txtName);
		bookPanel.add(labAuthor);
		bookPanel.add(txtAuthor);
		bookPanel.add(labPublish);
		bookPanel.add(txtPublish);
		bookPanel.add(labPublishDate);
		bookPanel.add(txtPublishDate);
		bookPanel.add(labPrice);
		bookPanel.add(txtPrice);
		//将各组件加入到面板
		panel.add(bookPanel,BorderLayout.CENTER);
		btnPanel=new JPanel();
		btnAdd=new JButton("增加");
		btnReset=new JButton("重置");
		btnExit=new JButton("退出");
		btnPanel.add(btnAdd);
		btnPanel.add(btnReset);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);		
		
		setVisible(true);		
	}
	public static void main(String[] args) {
		new BookAdd("图书添加");

	}

}
