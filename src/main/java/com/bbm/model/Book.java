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
	
	private String publish;  // 哪个出版社出版

	private String ISBN;

	//应该为日期型，考虑操作简单，设为字符串类型
	private String publishDate;  // 出版日期

	private Double price;  // 图书价格

	private int typeID;//图书类型号

	private String typeName;//图书类型名

}
