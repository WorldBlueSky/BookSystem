package com.bbm.db;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Dao {

    //����MYSQL���ݿ�����	
//    protected static String dbClassName = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bookSystem?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true" ;
    private static  final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // ��ȡ���ݿ�����
    private static volatile DataSource dataSource = null;

    // ����ģʽ������ݿ�ʵ��
    private static DataSource getDataSource(){
        if (dataSource==null) {
            synchronized (Dao.class) {
                if(dataSource==null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    // ������ݿ�����
    public static Connection getConnection(){
        try {
           return getDataSource().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    //������Դ
    public static void close(ResultSet resultSet, PreparedStatement statement ,Connection connection){

        if (resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
