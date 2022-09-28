package com.bbm.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {


	private String bookName;

	private String author;
	
	private String publish;  // �ĸ����������

	private String ISBN;

	//Ӧ��Ϊ�����ͣ����ǲ����򵥣���Ϊ�ַ�������
	private String publishDate;  // ��������

	private Double price;  // ͼ��۸�

	private int typeID;//ͼ�����ͺ�

	private String typeName;//ͼ��������

}
