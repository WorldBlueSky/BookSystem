package com.bbm.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import com.bbm.db.BookDao;
import com.bbm.model.Book;

public class BookSelectModify extends JFrame  implements ActionListener{
	private JPanel panel,selectConditionPane,btnPanel, centerPanel,selectResultPane,bookPane;

	private JComboBox cmbChoice,cmbType;

	private JTextField txtSelect,txtISBN,txtName,txtAuthor, txtPublish,txtPublishDate,txtPrice;

	private JLabel labISBN,labType,labName,labAuthor, labPublish,labPublishDate,labPrice;

	private JButton btnSelect,btnModify,btnDelete,btnExit;

	private JTable table;

	private JScrollPane scrollPane;
	
	public BookSelectModify(){
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

		//在中间面板中加入 表单，同时在表单中加入在数据库中查询到的数据
		table=new JTable();
		scrollPane=new JScrollPane(table);
		String name=cmbChoice.getSelectedItem().toString();
		String value=txtSelect.getText();
		Object[][] r1=getSelect(BookDao.selectBook(name, value));
		String[] colName= {"ISBN","书名","作者",
				"出版社","出版日期","单价","类型"};
		table=new JTable(r1,colName);//表中的数据
		scrollPane.setViewportView(table);//表与滚动条联系起来
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
		cmbType.addItem("外语类");
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


		//添加监听
		btnSelect.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);



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
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==btnExit){//退出
			System.exit(1);
		}

		if(e.getSource()==btnDelete){//删除
			String ISBN=txtISBN.getText().trim();
			//调用BookDao中的deleteBook方法，返回受影响的行数
			int i= BookDao.deleteBook(ISBN);
			if(i==1)
				JOptionPane.showMessageDialog(null, "删除成功");	
			else
				JOptionPane.showMessageDialog(null, "没成功");
		}

		if(e.getSource()==btnModify){//修改
			Book b1=new Book();
			b1.setISBN(txtISBN.getText().trim());
			b1.setAuthor(txtAuthor.getText().trim());
			b1.setBookName(txtName.getText().trim());
			b1.setPublish(txtPublish.getText().trim());
			b1.setPublishDate(txtPublishDate.getText().trim());
			//注意类型的转换
			b1.setPrice(Double.parseDouble(txtPrice.getText().trim()));
			//类型名
			b1.setTypeName(cmbType.getSelectedItem().toString());
			int i=BookDao.updateBook(b1);
			if(i>0)
				JOptionPane.showMessageDialog(null, "修改成功");
			else
				JOptionPane.showMessageDialog(null, "没成功");
		}
		if(e.getSource()==btnSelect){
			//查询
			String name=cmbChoice.getSelectedItem().toString();
			String value=txtSelect.getText();
			Object[][] r1=getSelect(BookDao.selectBook(name, value));
			String[] colName= {"ISBN","书名","作者",
					"出版社","出版日期","单价","类型"};
			table=new JTable(r1,colName);//表中的数据
			scrollPane.setViewportView(table);//表与滚动条联系起来
		}
	}
	//把查询的结果放到一个二维数组中，目的是要放到JTable中
	Object[][] getSelect(List<Book> list){
		String[] colName= {"ISBN","书名","作者",
				"出版社","出版日期","单价","类型"};
		//定义一个包含多行7列的二维数据：行根据list来判断
		Object[][] results=new Object[list.size()][colName.length];
		//将list中的每一个Book中的各个列放到二维数据的各个行中
		for(int i=0;i<list.size();i++){
			Book b1=list.get(i);//获取list中的每一个Book
			results[i][0]=b1.getISBN();
			results[i][1]=b1.getBookName();
			results[i][2]=b1.getAuthor();
			results[i][3]=b1.getPublish();
			results[i][4]=b1.getPublishDate();
			results[i][5]=b1.getPrice();
			results[i][6]=b1.getTypeName();			
		}

		return results;
	}

}
