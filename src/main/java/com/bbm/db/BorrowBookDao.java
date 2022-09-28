package com.bbm.db;

import com.bbm.model.Book;
import com.bbm.model.BorrowBook;
import com.bbm.model.Reader;
import netscape.security.UserTarget;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookDao {
//    BorrowBook 表中 放的都是 借走的书，没借走的书都不在这里

// 这个涉及到 图书借阅 与 归还

//    有点儿搞不懂功能需求

    //增删改查

    // 增 就相当于 借阅
    public static int borrowBook(String readerid,String ISBN,String borrowDate){
       // 借阅需要知道 借书人的信息、书的信息

//        根据图书借阅表的标签和文本框，我们往bookBorrow表中插入信息

        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;

        try {
            //1. 获取数据库连接
            connection = Dao.getConnection();

           //2.拼接sql语句
            String sql = "insert into borrowbook(readerid,ISBN,borrowdate) values(?,?,?)";

            statement = connection.prepareStatement(sql);

           // 占位符替换
            statement.setString(1,readerid);
            statement.setString(2,ISBN);
            statement.setString(3,borrowDate);

            //3.执行sql语句
            ret = statement.executeUpdate();

            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dao.close(null,statement,connection);
        }

        return 0;
    }


    // TODO
    // 删 就相当于 归还 , 根据ISBN进行删除  //
    public static int returnBook(String ISBN){
        // 将借的书信息 从 表中删除

        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;

        try {
            //1. 获取数据库连接
            connection = Dao.getConnection();

            //2.拼接sql语句
            String sql = "delete from borrowbook where ISBN = ?";

            statement = connection.prepareStatement(sql);

            // 占位符替换
            statement.setString(1,ISBN);

            //3.执行sql语句
            ret = statement.executeUpdate();

            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dao.close(null,statement,connection);
        }

        return 0;
    }

    // 改 改变图书的借阅状态，跟增删差不多
    // 但是前端页面中并没有这个功能
    public static int updateBookState(){
        return 0;
    }

    // 查 只显示被借走的书
    public static List<BorrowBook> selectBorrowBook(){
        // 这个查询功能只 查三个东西 (ISBN，bookname，借书日期)

        // borrowbook 里面没有bookname属性，后来我自己又添加了，否则没办法接收 联表查询的结果

          Connection connection = null;
          PreparedStatement statement = null;
          ResultSet resultSet = null;
          List<BorrowBook> list = new ArrayList<BorrowBook>();

        try {
            //1.获取数据库连接
            connection = Dao.getConnection();

            //2. 拼接sql语句

            String sql = "select book.ISBN,book.bookname,borrowbook.borrowdate from book join borrowbook on borrowbook.ISBN = book.ISBN";

            //3. 执行sql语句

            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                BorrowBook borrowBook = new BorrowBook();
                borrowBook.setISBN(resultSet.getString("ISBN"));
                borrowBook.setBookname(resultSet.getString("bookname"));
                borrowBook.setBorrowdate(resultSet.getString("borrowdate"));
                list.add(borrowBook);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }

        return null;
    }
}
