package com.bbm.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.bbm.db.BookDao;
import com.bbm.model.Book;

// TODO ������¼�

public class BookAdd extends JFrame implements ActionListener {

	private JPanel panel,bookPanel,btnPanel;

	private JLabel labISBN,labType,labName,labAuthor,
	labPublish,labPublishDate,labPrice;

	private JTextField txtISBN,txtName,txtAuthor,
	txtPublish,txtPublishDate,txtPrice;

	JComboBox cmbBookType;//��Ͽ�

	private JButton btnAdd,btnReset,btnExit;//��ť

	public BookAdd(String s){
		super(s);
		setSize(400,200);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);
		//ͼ��������Ϣ
		GridLayout grid1=new GridLayout(4,4);//���񲼾�
		grid1.setHgap(5);
		grid1.setVgap(5);
		bookPanel=new JPanel(grid1);
		labISBN=new JLabel("ISBN:");
		labISBN.setHorizontalAlignment(SwingConstants.CENTER);//����
		txtISBN=new JTextField(15);
		labType=new JLabel("ͼ�����");
		cmbBookType=new JComboBox();
		cmbBookType.addItem("�������");
		cmbBookType.addItem("������");
		labName=new JLabel("������");
		txtName=new JTextField(12);
		labAuthor=new JLabel("����");
		txtAuthor=new JTextField(12);
		labPublish=new JLabel("������");
		txtPublish=new JTextField();
		labPublishDate=new JLabel("��������");
		txtPublishDate=new JTextField(12);
		labPrice=new JLabel("�۸�");
		txtPrice=new JTextField(12);
		//�������ƣ����ߣ������磬���������ڣ��۸񣬿κ��Ҳ��䡣
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
		//����������뵽���
		panel.add(bookPanel,BorderLayout.CENTER);
		btnPanel=new JPanel();
		btnAdd=new JButton("����");
		btnReset=new JButton("����");
		btnExit=new JButton("�˳�");
		btnAdd.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
		
		btnPanel.add(btnAdd);
		btnPanel.add(btnReset);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);		
		
		setVisible(true);		
	}
	public static void main(String[] args) {
		new BookAdd("ͼ�����");

	}
	public void actionPerformed(ActionEvent e){

		//���ú��˳��κ����

		if(e.getSource()==btnAdd){//����
			Book b1=new Book();
			b1.setISBN(txtISBN.getText());
			b1.setAuthor(txtAuthor.getText());
			b1.setBookName(txtName.getText());
			b1.setPublish(txtPublish.getText());
			b1.setPublishDate(txtPublishDate.getText());
			b1.setPrice(Double.parseDouble(txtPrice.getText()));
			String typeName=cmbBookType.getSelectedItem()
					.toString().trim();
			int i=BookDao.insertBook(b1, typeName);
			if(i==1)
				JOptionPane.showMessageDialog(null, "�ɹ�");
			else
				JOptionPane.showMessageDialog(null, "���ɹ�");
		}

		if(e.getSource()==btnExit){//�˳�
			System.exit(1);
		}
		if(e.getSource()==btnReset) {// ����
			//����ı������������
			txtISBN.setText("");
			txtName.setText("");
			txtAuthor.setText("");
			txtPublish.setText("");
			txtPublishDate.setText("");
			txtPrice.setText("");
		}

	}

}