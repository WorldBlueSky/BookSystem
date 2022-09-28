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
		setTitle("ͼ�����");//���ñ���
		setSize(500,500);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);
		selectConditionPane=new JPanel();
		cmbChoice=new JComboBox();
		cmbChoice.addItem("ȫ��");
		cmbChoice.addItem("����");
		txtSelect=new JTextField(20);
		selectConditionPane.add(cmbChoice);
		selectConditionPane.add(txtSelect);
		panel.add(selectConditionPane,BorderLayout.NORTH);
		//�м����
		centerPanel=new JPanel();
		selectResultPane=new JPanel();

		//���м�����м��� ����ͬʱ�ڱ��м��������ݿ��в�ѯ��������
		table=new JTable();
		scrollPane=new JScrollPane(table);
		String name=cmbChoice.getSelectedItem().toString();
		String value=txtSelect.getText();
		Object[][] r1=getSelect(BookDao.selectBook(name, value));
		String[] colName= {"ISBN","����","����",
				"������","��������","����","����"};
		table=new JTable(r1,colName);//���е�����
		scrollPane.setViewportView(table);//�����������ϵ����
		scrollPane.setPreferredSize(new Dimension(400,240));//���С
		selectResultPane.add(scrollPane);



		bookPane=new JPanel(new GridLayout(4,4));
		//4��4�У���Ҫ����ÿ��������ӵ�bookPane�У�����6���κ����
		labISBN=new JLabel("ISBN��");
		labType=new JLabel("ͼ������");
		labName=new JLabel("����");
		labAuthor=new JLabel("����");
		labPublish=new JLabel("������");
		labPublishDate=new JLabel("��������");
		labPrice=new JLabel("�۸�");
		txtISBN=new JTextField(8);
		cmbType=new JComboBox();
		cmbType.addItem("�������");
		cmbType.addItem("������");
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
		btnSelect=new JButton("��ѯ");
		btnModify=new JButton("�޸�");
		btnDelete=new JButton("ɾ��");
		btnExit=new JButton("�˳�");


		//��Ӽ���
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

		if(e.getSource()==btnExit){//�˳�
			System.exit(1);
		}

		if(e.getSource()==btnDelete){//ɾ��
			String ISBN=txtISBN.getText().trim();
			//����BookDao�е�deleteBook������������Ӱ�������
			int i= BookDao.deleteBook(ISBN);
			if(i==1)
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
			else
				JOptionPane.showMessageDialog(null, "û�ɹ�");
		}

		if(e.getSource()==btnModify){//�޸�
			Book b1=new Book();
			b1.setISBN(txtISBN.getText().trim());
			b1.setAuthor(txtAuthor.getText().trim());
			b1.setBookName(txtName.getText().trim());
			b1.setPublish(txtPublish.getText().trim());
			b1.setPublishDate(txtPublishDate.getText().trim());
			//ע�����͵�ת��
			b1.setPrice(Double.parseDouble(txtPrice.getText().trim()));
			//������
			b1.setTypeName(cmbType.getSelectedItem().toString());
			int i=BookDao.updateBook(b1);
			if(i>0)
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			else
				JOptionPane.showMessageDialog(null, "û�ɹ�");
		}
		if(e.getSource()==btnSelect){
			//��ѯ
			String name=cmbChoice.getSelectedItem().toString();
			String value=txtSelect.getText();
			Object[][] r1=getSelect(BookDao.selectBook(name, value));
			String[] colName= {"ISBN","����","����",
					"������","��������","����","����"};
			table=new JTable(r1,colName);//���е�����
			scrollPane.setViewportView(table);//�����������ϵ����
		}
	}
	//�Ѳ�ѯ�Ľ���ŵ�һ����ά�����У�Ŀ����Ҫ�ŵ�JTable��
	Object[][] getSelect(List<Book> list){
		String[] colName= {"ISBN","����","����",
				"������","��������","����","����"};
		//����һ����������7�еĶ�ά���ݣ��и���list���ж�
		Object[][] results=new Object[list.size()][colName.length];
		//��list�е�ÿһ��Book�еĸ����зŵ���ά���ݵĸ�������
		for(int i=0;i<list.size();i++){
			Book b1=list.get(i);//��ȡlist�е�ÿһ��Book
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
