package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;

public class BookSelectModify extends JFrame {
	private JPanel panel,selectConditionPane,btnPanel,
	centerPanel,selectResultPane,bookPane;
	private JComboBox cmbChoice,cmbType;
	private JTextField txtSelect,txtISBN,txtName,txtAuthor,
	txtPublish,txtPublishDate,txtPrice;
	private JLabel labISBN,labType,labName,labAuthor,
	labPublish,labPublishDate,labPrice;
	private JButton btnSelect,btnModify,btnDelete,btnExit;
	private JTable table;
	private JScrollPane scrollPane;
	
	public BookSelectModify()
	{
		setTitle("图书管理");//设置标题
		setSize(500,500);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);
		selectConditionPane=new JPanel();
		cmbChoice=new JComboBox();
		cmbChoice.addItem("全部");
		cmbChoice.addItem("书名");
		txtSelect=new JTextField(20);
		selectConditionPane.add(cmbChoice);
		selectConditionPane.add(txtSelect);
		panel.add(selectConditionPane,BorderLayout.NORTH);
		//中间面板
		centerPanel=new JPanel();
		selectResultPane=new JPanel();
		table=new JTable();
		scrollPane=new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400,240));//设大小
		selectResultPane.add(scrollPane);
		bookPane=new JPanel(new GridLayout(4,4));
		//4行4列，需要创建每个组件，加到bookPane中，另外6个课后完成
		labISBN=new JLabel("ISBN号");
		labType=new JLabel("图书类型");
		labName=new JLabel("书名");
		labAuthor=new JLabel("作者");
		labPublish=new JLabel("出版社");
		labPublishDate=new JLabel("出版日期");
		labPrice=new JLabel("价格");
		txtISBN=new JTextField(8);
		cmbType=new JComboBox();
		cmbType.addItem("计算机类");
		cmbType.addItem("管理类");
		txtName=new JTextField(8);
		txtAuthor=new JTextField(8);
		txtPublish=new JTextField(8);
		txtPublishDate=new JTextField(8);
		txtPrice=new JTextField(8);
		bookPane.add(labISBN);		
		bookPane.add(txtISBN);
		bookPane.add(labType);		
		bookPane.add(cmbType);
		bookPane.add(labName);		
		bookPane.add(txtName);
		bookPane.add(labAuthor);		
		bookPane.add(txtAuthor);
		bookPane.add(labPublish);		
		bookPane.add(txtPublish);
		bookPane.add(labPublishDate);		
		bookPane.add(txtPublishDate);
		bookPane.add(labPrice);		
		bookPane.add(txtPrice);
		centerPanel.add(selectResultPane);
		centerPanel.add(bookPane);
		panel.add(centerPanel,BorderLayout.CENTER);
		btnPanel=new JPanel();
		btnSelect=new JButton("查询");
		btnModify=new JButton("修改");
		btnDelete=new JButton("删除");
		btnExit=new JButton("退出");
		btnPanel.add(btnSelect);
		btnPanel.add(btnModify);
		btnPanel.add(btnDelete);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);		
		
		setVisible(true);
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookSelectModify();
	}

}
