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
	JComboBox cmbBookType;//��Ͽ�
	private JButton btnAdd,btnReset,btnExit;
	public BookAdd(String s)
	{
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
		btnPanel.add(btnAdd);
		btnPanel.add(btnReset);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);		
		
		setVisible(true);		
	}
	public static void main(String[] args) {
		new BookAdd("ͼ�����");

	}

}
