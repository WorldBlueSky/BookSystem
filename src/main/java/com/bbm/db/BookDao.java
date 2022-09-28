package com.bbm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbm.model.Book;

public class BookDao{
	//根据ISBN号删除图书信息
  public static int deleteBook(String ISBN) {

  	// 先定义数据库连接，预处理
	  Connection connection = null;
	  PreparedStatement statement = null;
	  int ret = 0;

	  try{
		  //1.获取到数据库连接
		  connection = Dao.getConnection();
		  //2.拼装sql语句
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


  //增加图书信息
  public static int insertBook(Book b,String typeName) {
  	  //稍微复杂：图书表中包括的是类型编号，界面设计时是类型的名称，
	  //所以，在增加之前，需要先将类型名称转换成类型编号
	  //根据类型名查找到相应的类型编号，涉及到图书类型表

	  Connection connection = Dao.getConnection();
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  int ret = 0;
	  // 根据图书的类型名找到图书编号

	  try {
		  // 拼接sql语句
		  String sql1="select typeid from booktype where typename='" +typeName+"'";
		  statement = connection.prepareStatement(sql1);
		  resultSet = statement.executeQuery();

		  int typeID = -1;

		  if(resultSet.next()){
		  	typeID = resultSet.getInt("typeid");
		  }
		  // 根据类型名拿到图书类型的id了

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

  //查询功能
  public static List<Book> selectBook(String s1, String s2){
	  //根据下拉框的选择 进行查询
	  // 第一种 下拉框是全部，查询全部
	  // 第二种 下拉框是书名，文本框输入具体的值，根据这两个条件进行查询

	  Connection connection = null;
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  List<Book> listBook =new ArrayList<Book>();

	  try {
		  //1.连接数据库
		  connection = Dao.getConnection();

		  // 2.拼接sql语句
		  String sql = "SELECT ISBN,bookname,author,publish,publishDate,price,book.typeid,book.typename from book JOIN booktype "
				  + "on book.typeid=booktype.typeid";
		  if (s1.equals("书名"))
			  sql = sql + " where bookname='" + s2 + "'";

		  //3.执行sql查询语句
		  statement = connection.prepareStatement(sql);

		  resultSet = statement.executeQuery();

		  //可以包括多类的查询条件，根据前面的界面来完善。
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
  
  //修改
  public static int updateBook(Book b){
	  Connection connection = Dao.getConnection();
	  PreparedStatement statement = null;
	  ResultSet resultSet = null;
	  int ret = 0;


	  try {
		  // 拼接sql语句
		  String sql1="select typeid from booktype where typename='" +b.getTypeName()+"'";
		  statement = connection.prepareStatement(sql1);
		  resultSet = statement.executeQuery();

		  int typeID = -1;

		  if(resultSet.next()){
			  typeID = resultSet.getInt("typeid");
		  }

		  //update book set bookname='计算机网络',author='肖朝晖',
		  //publish='北京理工大学出版社',price=34,
		  //typeid=1,publishdate='20180101' where isbn='003'

		  // 拼接sql 修改语句
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
