package com.bbm.db;

import com.bbm.model.Reader;
import com.bbm.model.ReaderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTypeDao {

    //增删改查

    // 增
    public static int insertReaderType(ReaderType readerType) {

        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "insert into readertype values (?,?,?,?)";
            statement = connection.prepareStatement(sql);

            // 占位符防止sql注入，最好不要直接拼接到sql语句中
            statement.setInt(1,readerType.getTypeid());
            statement.setString(2, readerType.getTypename());
            statement.setInt(3, readerType.getMaxborrownum());
            statement.setInt(4, readerType.getLimit());
            //3.执行sql语句
            ret = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dao.close(null, statement, connection);
        }
        return ret;
    }

    // 删   因为读者类型编号是主键，所以是唯一的，所以就根据主键来删除记录
    public static int deleteReaderType(int typeid) {
        int ret = 0;
        Connection connection = null;
        PreparedStatement statement = null;


        try {
            //1.拿到数据库连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "delete from readertype where typeid =?";
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
    public static int updateReaderType(ReaderType readerType, int typeid) {
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "update readertype set typename=?,maxborrownum=?,`limit`=? where typeid= ?";
            statement = connection.prepareStatement(sql);

            // 占位符防止sql注入，最好不要直接拼接到sql语句中
            statement.setString(1, readerType.getTypename());
            statement.setInt(2, readerType.getMaxborrownum());
            statement.setInt(3, readerType.getLimit());
            statement.setInt(4, typeid);
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
    public static List<ReaderType> selectReaderType() {
        List<ReaderType> list = new ArrayList<ReaderType>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "select *  from readertype";
            statement = connection.prepareStatement(sql);

            //3.执行sql语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReaderType readerType = new ReaderType();
                readerType.setTypeid(resultSet.getInt("typeid"));
                readerType.setTypename(resultSet.getString("typename"));
                readerType.setMaxborrownum(resultSet.getInt("maxborrownum"));
                readerType.setLimit(resultSet.getInt("limit"));
                list.add(readerType);
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
    public static List<ReaderType> selectReaderTypeById(int typeid) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReaderType> list = new ArrayList<ReaderType>();

        try {
            //1.先拿到数据库的连接
            connection = Dao.getConnection();
            //2.拼接sql语句
            String sql = "select *  from readertype where typeid =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,typeid);

            //3.执行sql语句
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                ReaderType readerType = new ReaderType();
                readerType.setTypeid(resultSet.getInt("typeid"));
                readerType.setTypename(resultSet.getString("typename"));
                readerType.setMaxborrownum(resultSet.getInt("maxborrownum"));
                readerType.setLimit(resultSet.getInt("limit"));
                list.add(readerType);
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




