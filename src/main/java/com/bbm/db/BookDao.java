package com.bbm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbm.model.Book;

public class BookDao{
	//����ISBN��ɾ��ͼ����Ϣ
  public static int deleteBook(String ISBN) {

  	// �ȶ������ݿ����ӣ�Ԥ����
	  Connection connection = null;
	  PreparedStatement statement = null;
	  int ret = 0;

	  try{
		  //1.��ȡ�����ݿ�����
		  connection = Dao.getConnection();
		  //2.ƴװsql���
		  String sql="delete from book where ISBN='"+ISBN+"'";
		  statement = connection.prepareStatement(sql);
		  ret = statement.executeUpdate();
	  } catch (SQLException throwables) {
		  throwables.printStackTrace();
	  }finally {
	  	Dao.close(null,statement,connection);
	  }
	  return ret;
  }


  //����ͼ����Ϣ
  public static int insertBook(Book b,String typeName) {
  	  //��΢���ӣ�ͼ����а����������ͱ�ţ��������ʱ�����͵����ƣ�
	  //���ԣ�������֮ǰ����Ҫ�Ƚ���������ת�������ͱ��
	  //�������������ҵ���Ӧ�����ͱ�ţ��漰��ͼ�����ͱ�

	  Connection connection = Dao.getConnection();
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  int ret = 0;
	  // ����ͼ����������ҵ�ͼ����

	  try {
		  // ƴ��sql���
		  String sql1="select typeid from booktype where typename='" +typeName+"'";
		  statement = connection.prepareStatement(sql1);
		  resultSet = statement.executeQuery();

		  int typeID = -1;

		  if(resultSet.next()){
		  	typeID = resultSet.getInt("typeid");
		  }
		  // �����������õ�ͼ�����͵�id��

		  String sql2="insert into Book(ISBN,bookname,author,publish,publishdate,price,typeid,typename)"
				  +"values('"+b.getISBN()+"','"+b.getBookName()+"','"+b.getAuthor()
				  +"','"+b.getPublish()+"','"+b.getPublishDate()
				  +"',"+b.getPrice()+","+typeID+",'"+typeName+"'"+")";

		  System.out.println(sql2);
		  statement = connection.prepareStatement(sql2);

		  ret = statement.executeUpdate(sql2);


	  } catch (SQLException throwables) {
		  throwables.printStackTrace();
	  }finally {
	  	Dao.close(resultSet,statement,connection);
	  }

	  return ret;
  }

  //��ѯ����
  public static List<Book> selectBook(String s1, String s2){
	  //�����������ѡ�� ���в�ѯ
	  // ��һ�� ��������ȫ������ѯȫ��
	  // �ڶ��� ���������������ı�����������ֵ�������������������в�ѯ

	  Connection connection = null;
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  List<Book> listBook =new ArrayList<Book>();

	  try {
		  //1.�������ݿ�
		  connection = Dao.getConnection();

		  // 2.ƴ��sql���
		  String sql = "SELECT ISBN,bookname,author,publish,publishDate,price,book.typeid,book.typename from book JOIN booktype "
				  + "on book.typeid=booktype.typeid";
		  if (s1.equals("����"))
			  sql = sql + " where bookname='" + s2 + "'";

		  //3.ִ��sql��ѯ���
		  statement = connection.prepareStatement(sql);

		  resultSet = statement.executeQuery();

		  //���԰�������Ĳ�ѯ����������ǰ��Ľ��������ơ�
		  while(resultSet.next()) {
			  Book b1 = new Book();
			  b1.setISBN(resultSet.getString("ISBN"));
			  b1.setBookName(resultSet.getString("bookname"));
			  b1.setPublish(resultSet.getString("publish"));
			  b1.setAuthor(resultSet.getString("author"));
			  b1.setPublishDate(resultSet.getString("publishdate"));
			  b1.setPrice(resultSet.getDouble("price"));
			  b1.setTypeID(resultSet.getInt("typeid"));
			  b1.setTypeName(resultSet.getString("typename"));
			  listBook.add(b1);
		  }
		  return listBook;

	  }catch (SQLException e){
	  	  e.printStackTrace();
	  }finally {
	  	Dao.close(resultSet,statement,connection);
	  }

	  return null;

  }
  
  //�޸�
  public static int updateBook(Book b){
	  Connection connection = Dao.getConnection();
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  int ret = 0;


	  try {
		  // ƴ��sql���
		  String sql1="select typeid from booktype where typename='" +b.getTypeName()+"'";
		  statement = connection.prepareStatement(sql1);
		  resultSet = statement.executeQuery();

		  int typeID = -1;

		  if(resultSet.next()){
			  typeID = resultSet.getInt("typeid");
		  }

		  //update book set bookname='���������',author='Ф����',
		  //publish='��������ѧ������',price=34,
		  //typeid=1,publishdate='20180101' where isbn='003'

		  // ƴ��sql �޸����
		  String sqlUpdat="update book set bookname='"+b.getBookName()
		  +"',author='"+b.getAuthor()+"',publish='"+b.getPublish()
		  +"',price="+b.getPrice()+",typeid="+typeID+",publishdate='"
		  +b.getPublishDate()+"' where isbn='"+b.getISBN()+"'";

		  statement = connection.prepareStatement(sqlUpdat);
		  ret = statement.executeUpdate();

	  } catch(SQLException e){
	  	   e.printStackTrace();
	  }finally {
	  	Dao.close(resultSet,statement,connection);
	  }
	  return ret;
  }

	public static void main(String[] args) {
		BookDao.selectBook("","");
	}

}
