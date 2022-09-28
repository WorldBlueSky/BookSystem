package com.bbm.db;

import com.bbm.model.Book;
import com.bbm.model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDao {

    //增删改查

    // 增
    public static int insertReader(Reader reader,String typeName){
        Connection connection = Dao.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;
        // 读者表中 typeid 与 读者类型表中 typeid 相联系
        // 根据读者的类型名 typename 找到读者类型编号 typeid

        try {
            // 拼接sql语句 从读者类型表 readertype 中根据 typename查找 typeid
            String sql1="select typeid from readertype where typename=?";
            statement = connection.prepareStatement(sql1);
             // 占位符替换
            statement.setString(1,typeName);

              // 执行sql查询语句
            resultSet = statement.executeQuery();

            int typeID = -1;

            if(resultSet.next()){
                typeID = resultSet.getInt("typeid");
            }
            // 根据类型名拿到读者类型的id了

            System.out.println(typeID);

            String sql2="insert into reader values (?,?,?,?,?,?,?,?,?)";

            // 占位符替换
            statement = connection.prepareStatement(sql2);
            statement.setString(1,reader.getReaderid());
            statement.setString(2,reader.getName());
            statement.setString(3,reader.getSex());
            statement.setInt(4,reader.getAge());
            statement.setString(5,reader.getPhone());
            statement.setString(6,reader.getDept());
            statement.setString(7,reader.getRegdate());
            statement.setInt(8,typeID);
            statement.setString(9,typeName);

//            System.out.println(sql2);

            // 执行sql增加语句
            ret = statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }

        return ret;
    }


    // 删  根据读者的编号进行删除操作
    public static int deleteReader(String readerid){

        // 先定义数据库连接，预处理
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;


        try{
            //1.获取到数据库连接
            connection = Dao.getConnection();
            //2.拼装sql语句
            String sql="delete from reader where readerid = ?";
            statement = connection.prepareStatement(sql);

            // 占位符替换
            statement.setString(1,readerid);

            // 3.执行sql语句
            ret = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Dao.close(null,statement,connection);
        }
        return ret;
    }


    // 改
    public static int updateReader(Reader reader){
        Connection connection = Dao.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;


        try {
            // 拼接sql语句 从读者类型表 readertype 中根据 typename查找 readerid
            String sql1="select typeid from readertype where typename= ?" ;
            statement = connection.prepareStatement(sql1);
            // 占位符替换
            statement.setString(1,reader.getTypename());

            System.out.println(reader.getTypename());

            // 执行sql查询语句
            resultSet = statement.executeQuery();

            int typeID = -1;

            if(resultSet.next()){
                typeID = resultSet.getInt("typeid");
            }

            System.out.println(typeID);
            // 根据类型名拿到读者类型的id了

            //update book set bookname='计算机网络',author='肖朝晖',
            //publish='北京理工大学出版社',price=34,
            //typeid=1,publishdate='20180101' where isbn='003'

            // 拼接sql 修改语句
            String sqlUpdat="update reader set name=?,sex=?,age=?,phone=?,dept=?,regdate=?,typeid=? ,typename=? where readerid=?";
            statement = connection.prepareStatement(sqlUpdat);

            // 占位符替换

            statement.setString(1,reader.getName());
            statement.setString(2,reader.getSex());
            statement.setInt(3,reader.getAge());
            statement.setString(4,reader.getPhone());
            statement.setString(5,reader.getDept());
            statement.setString(6,reader.getRegdate());
            statement.setInt(7,typeID);
            statement.setString(8,reader.getTypename());
            statement.setString(9,reader.getReaderid());


            // 执行sql语句
            ret = statement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }
        return ret;
    }

    // 查
    public static List<Reader> selectReader(String s1, String s2){
        //一个是下拉框中选中的字符串，一个是

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reader> list =new ArrayList<Reader>();


        try {
            //1.连接数据库
            connection = Dao.getConnection();

            // 2.拼接sql语句
            String sql = "select  readerid ,name,sex,age,phone,dept,regdate,reader.typeid,readertype.typename from reader JOIN readertype on reader.typeid=readertype.typeid";
//            System.out.println("执行到了if的前一行");

            if (s1.equals("读者编号")){
//                System.out.println("执行了if判断");
                sql = sql+" where readerid='" + s2 + "'";
            }

//            System.out.println("执行了if判断之后的条件");

            System.out.println(sql);

            //3.执行sql查询语句
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            //可以包括多类的查询条件，根据前面的界面来完善。
            while(resultSet.next()) {
                Reader reader = new Reader();
                reader.setReaderid(resultSet.getString("readerid"));
                reader.setName(resultSet.getString("name"));
                reader.setSex(resultSet.getString("sex"));
                reader.setAge(resultSet.getInt("age"));
                reader.setPhone(resultSet.getString("phone"));
                reader.setDept(resultSet.getString("dept"));
                reader.setRegdate(resultSet.getString("regdate"));
                reader.setTypename(resultSet.getString("typename"));
                list.add(reader);
            }
            return list;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }

        return null;
    }

}
