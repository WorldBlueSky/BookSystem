package com.bbm.view;
import com.bbm.model.BorrowBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//TODO ������¼�

public class Library extends JFrame 
implements ActionListener {
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
		itemBookAdd.addActionListener(this);//����
		itemBookSelect.addActionListener(this);


		// ������Ϣ����ģ��

		menuReader = new JMenu("������Ϣ����");

		itemReaderAdd = new JMenuItem("�������");
		itemReaderSelect = new JMenuItem("���߲�ѯ���޸�");

		menuReader.add(itemReaderAdd);
		menuReader.add(itemReaderSelect);

		itemReaderAdd.addActionListener(this);// �Ӽ���
		itemReaderSelect.addActionListener(this);

		// ���͹���

		menuType = new JMenu("���͹���");

		itemBookTypeManage = new JMenuItem("ͼ�����͹���");
		itemReaderTypeManage = new JMenuItem("�������͹���");

		menuType.add(itemBookTypeManage);
		menuType.add(itemReaderTypeManage);

		itemBookTypeManage.addActionListener(this);
		itemReaderTypeManage.addActionListener(this);

		// �û�����

		menuUser = new JMenu("�û�����");

		itemUserAdd =new JMenuItem("ע���û�");
		itemUserDelete = new JMenuItem("ɾ���û�");
		itemUserUpdate = new JMenuItem("�޸�����");

		menuUser.add(itemUserAdd);
		menuUser.add(itemUserDelete);
		menuUser.add(itemUserUpdate);

		itemUserAdd.addActionListener(this);
		itemUserDelete.addActionListener(this);
		itemUserUpdate.addActionListener(this);

		// ���Ĺ���

		menuBorrowBook = new JMenu("���Ĺ���");

		itemBookBorrow = new JMenuItem("ͼ�����");
		itemBookReturn = new JMenuItem("ͼ��黹");

		menuBorrowBook.add(itemBookBorrow);
		menuBorrowBook.add(itemBookReturn);

		itemBookBorrow.addActionListener(this);
		itemBookReturn.addActionListener(this);

		// ������

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
			new BookAdd("ͼ�����ӽ���");

		if(e.getSource()==itemBookSelect)
			new BookSelectModify();

		if(e.getSource()==itemReaderAdd){
			new ReaderAdd("�������ӽ���");
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
			new UserAdd("�����û�");
		}

		if(e.getSource()==itemUserDelete){
			new UserDelete();
		}

		if(e.getSource()==itemUserUpdate){
			new UpdatePassword("�޸�����");
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
		new com.bbm.view.Library("ͼ�����ϵͳ");
	}
	
}
