package com.bbm.staticview;

import javax.swing.*;

public class Library extends JFrame {
	private JMenuBar bar;//菜单条

	private JMenu menuBook,menuReader,menuType,menuUser,menuBorrowBook;//菜单

	private JMenuItem itemBookAdd,itemBookSelect,itemReaderAdd,itemReaderSelect,
			itemBookTypeManage,itemReaderTypeManage,itemUserAdd,
			itemUserDelete,itemUserUpdate,itemBookBorrow,itemBookReturn;//菜单项

	public Library(String s){
		super(s);
		setSize(1000,800);
		setLocationRelativeTo(null);
		bar=new JMenuBar();
		setJMenuBar(bar);

		// 图书信息管理模块

		menuBook=new JMenu("图书信息管理");//菜单

		itemBookAdd=new JMenuItem("图书增加");//菜单项
		itemBookSelect=new JMenuItem("图书查询与修改");

		menuBook.add(itemBookAdd);
		menuBook.add(itemBookSelect);

		// 读者信息管理模块

		menuReader = new JMenu("读者信息管理");

		itemReaderAdd = new JMenuItem("读者添加");
		itemReaderSelect = new JMenuItem("读者查询与修改");

		menuReader.add(itemReaderAdd);
		menuReader.add(itemReaderSelect);

       // 类型管理

		menuType = new JMenu("类型管理");

		itemBookTypeManage = new JMenuItem("图书类型管理");
		itemReaderTypeManage = new JMenuItem("读者类型管理");

		menuType.add(itemBookTypeManage);
		menuType.add(itemReaderTypeManage);

		// 用户管理

		menuUser = new JMenu("用户管理");

		itemUserAdd =new JMenuItem("注册用户");
		itemUserDelete = new JMenuItem("删除用户");
		itemUserUpdate = new JMenuItem("修改密码");

		menuUser.add(itemUserAdd);
		menuUser.add(itemUserDelete);
		menuUser.add(itemUserUpdate);

		// 借阅管理

		menuBorrowBook = new JMenu("借阅管理");

		itemBookBorrow = new JMenuItem("图书借阅");
		itemBookReturn = new JMenuItem("图书归还");

		menuBorrowBook.add(itemBookBorrow);
		menuBorrowBook.add(itemBookReturn);

		bar.add(menuBook);
		bar.add(menuReader);
		bar.add(menuType);
		bar.add(menuUser);
		bar.add(menuBorrowBook);
		setVisible(true);			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Library("图书借阅系统");
	}
}
