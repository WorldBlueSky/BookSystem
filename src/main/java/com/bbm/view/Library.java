package com.bbm.view;
import com.bbm.model.BorrowBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//TODO 已完成事件

public class Library extends JFrame 
implements ActionListener {
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
		itemBookAdd.addActionListener(this);//监听
		itemBookSelect.addActionListener(this);


		// 读者信息管理模块

		menuReader = new JMenu("读者信息管理");

		itemReaderAdd = new JMenuItem("读者添加");
		itemReaderSelect = new JMenuItem("读者查询与修改");

		menuReader.add(itemReaderAdd);
		menuReader.add(itemReaderSelect);

		itemReaderAdd.addActionListener(this);// 加监听
		itemReaderSelect.addActionListener(this);

		// 类型管理

		menuType = new JMenu("类型管理");

		itemBookTypeManage = new JMenuItem("图书类型管理");
		itemReaderTypeManage = new JMenuItem("读者类型管理");

		menuType.add(itemBookTypeManage);
		menuType.add(itemReaderTypeManage);

		itemBookTypeManage.addActionListener(this);
		itemReaderTypeManage.addActionListener(this);

		// 用户管理

		menuUser = new JMenu("用户管理");

		itemUserAdd =new JMenuItem("注册用户");
		itemUserDelete = new JMenuItem("删除用户");
		itemUserUpdate = new JMenuItem("修改密码");

		menuUser.add(itemUserAdd);
		menuUser.add(itemUserDelete);
		menuUser.add(itemUserUpdate);

		itemUserAdd.addActionListener(this);
		itemUserDelete.addActionListener(this);
		itemUserUpdate.addActionListener(this);

		// 借阅管理

		menuBorrowBook = new JMenu("借阅管理");

		itemBookBorrow = new JMenuItem("图书借阅");
		itemBookReturn = new JMenuItem("图书归还");

		menuBorrowBook.add(itemBookBorrow);
		menuBorrowBook.add(itemBookReturn);

		itemBookBorrow.addActionListener(this);
		itemBookReturn.addActionListener(this);

		// 添加组件

		menuBook.add(itemBookAdd);
		menuBook.add(itemBookSelect);
		bar.add(menuBook);
		bar.add(menuReader);
		bar.add(menuType);
		bar.add(menuUser);
		bar.add(menuBorrowBook);
		setVisible(true);			
	}
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==itemBookAdd)
			new BookAdd("图书增加界面");

		if(e.getSource()==itemBookSelect)
			new BookSelectModify();

		if(e.getSource()==itemReaderAdd){
			new ReaderAdd("读者增加界面");
		}

		if(e.getSource()==itemReaderSelect){
		    new ReaderSelectModify();
		}

		if(e.getSource()==itemBookTypeManage){
			new BookTypeManage();
		}

		if(e.getSource()==itemReaderTypeManage){
			new ReaderTypeManage();
		}

		if(e.getSource()==itemUserAdd){
			new UserAdd("增加用户");
		}

		if(e.getSource()==itemUserDelete){
			new UserDelete();
		}

		if(e.getSource()==itemUserUpdate){
			new UpdatePassword("修改密码");
		}

		if(e.getSource()==itemBookBorrow){
			new BookBorrow();
		}

		if(e.getSource()==itemBookReturn){
			new BookReturn();
		}
	}


	public static void main(String[] args){
		// TODO Auto-generated method stub
		new com.bbm.view.Library("图书借阅系统");
	}
	
}
