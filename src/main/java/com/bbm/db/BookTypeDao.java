package com.bbm.db;

import com.bbm.model.Book;
import com.bbm.model.BookType;
import com.bbm.model.ReaderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeDao {


    //增删改查

    // 增
    public static int insertBookType(BookType bookType) {
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();

            //2.拼接sql语句
            String sql = "insert into booktype values (?,?)";
            statement = connection.prepareStatement(sql);

            // 占位符防止sql注入，最好不要直接拼接到sql语句中
            statement.setInt(1, bookType.getTypeid());
            statement.setString(2,bookType.getTypename());

            //3.执行sql语句
            ret = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }
        return ret;
    }

    // 删   因为书籍类型编号是主键，所以是唯一的，所以就根据主键来删除记录
    public static int deleteBookType(int typeid) {
        int ret = 0;
        Connection connection = null;
        PreparedStatement statement = null;


        try {
            //1.拿到数据库连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "delete from booktype where typeid =?";
            statement = connection.prepareStatement(sql);

            // 占位符替换
            statement.setInt(1, typeid);
            // 3.执行sql语句
            ret = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }

        return ret;
    }

    // 改  因为主键是唯一的，所以根据主键id进行修改读者类型信息
    public static int updateBookType(BookType bookType) {
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "update booktype set typename=? where typeid= ?";
            statement = connection.prepareStatement(sql);

            // 占位符防止sql注入，最好不要直接拼接到sql语句中
            statement.setString(1, bookType.getTypename());
            statement.setInt(2, bookType.getTypeid());

            //3.执行sql语句
            ret = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }
        return ret;
    }

    // 查  查找所有的读者类型
    public static List<BookType> selectBookType() {
        List<BookType> list = new ArrayList<BookType>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "select *  from booktype";
            statement = connection.prepareStatement(sql);

            //3.执行sql语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookType bookType = new BookType();
                bookType.setTypeid(resultSet.getInt("typeid"));
                bookType.setTypename(resultSet.getString("typename"));
                list.add(bookType);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }
        return null;
    }


    // 查  按照指定的 读者编号进行查找读者类型
    public static List<BookType> selectBookTypeById(int typeid) {

        List<BookType> list = new ArrayList<BookType>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        BookType bookType = new BookType();

        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "select *  from booktype where typeid =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,typeid);

            //3.执行sql语句
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                bookType.setTypeid(resultSet.getInt("typeid"));
                bookType.setTypename(resultSet.getString("typename"));
                list.add(bookType);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }
        return null;
    }


}
