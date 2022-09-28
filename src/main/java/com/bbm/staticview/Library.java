package com.bbm.staticview;

import javax.swing.*;

public class Library extends JFrame {
	private JMenuBar bar;//�˵���

	private JMenu menuBook,menuReader,menuType,menuUser,menuBorrowBook;//�˵�

	private JMenuItem itemBookAdd,itemBookSelect,itemReaderAdd,itemReaderSelect,
			itemBookTypeManage,itemReaderTypeManage,itemUserAdd,
			itemUserDelete,itemUserUpdate,itemBookBorrow,itemBookReturn;//�˵���

	public Library(String s){
		super(s);
		setSize(1000,800);
		setLocationRelativeTo(null);
		bar=new JMenuBar();
		setJMenuBar(bar);

		// ͼ����Ϣ����ģ��

		menuBook=new JMenu("ͼ����Ϣ����");//�˵�

		itemBookAdd=new JMenuItem("ͼ������");//�˵���
		itemBookSelect=new JMenuItem("ͼ���ѯ���޸�");

		menuBook.add(itemBookAdd);
		menuBook.add(itemBookSelect);

		// ������Ϣ����ģ��

		menuReader = new JMenu("������Ϣ����");

		itemReaderAdd = new JMenuItem("�������");
		itemReaderSelect = new JMenuItem("���߲�ѯ���޸�");

		menuReader.add(itemReaderAdd);
		menuReader.add(itemReaderSelect);

       // ���͹���

		menuType = new JMenu("���͹���");

		itemBookTypeManage = new JMenuItem("ͼ�����͹���");
		itemReaderTypeManage = new JMenuItem("�������͹���");

		menuType.add(itemBookTypeManage);
		menuType.add(itemReaderTypeManage);

		// �û�����

		menuUser = new JMenu("�û�����");

		itemUserAdd =new JMenuItem("ע���û�");
		itemUserDelete = new JMenuItem("ɾ���û�");
		itemUserUpdate = new JMenuItem("�޸�����");

		menuUser.add(itemUserAdd);
		menuUser.add(itemUserDelete);
		menuUser.add(itemUserUpdate);

		// ���Ĺ���

		menuBorrowBook = new JMenu("���Ĺ���");

		itemBookBorrow = new JMenuItem("ͼ�����");
		itemBookReturn = new JMenuItem("ͼ��黹");

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
		new Library("ͼ�����ϵͳ");
	}
}
