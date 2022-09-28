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

    //��ɾ�Ĳ�

    // ��
    public static int insertReader(Reader reader,String typeName){
        Connection connection = Dao.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;
        // ���߱��� typeid �� �������ͱ��� typeid ����ϵ
        // ���ݶ��ߵ������� typename �ҵ��������ͱ�� typeid

        try {
            // ƴ��sql��� �Ӷ������ͱ� readertype �и��� typename���� typeid
            String sql1="select typeid from readertype where typename=?";
            statement = connection.prepareStatement(sql1);
             // ռλ���滻
            statement.setString(1,typeName);

              // ִ��sql��ѯ���
            resultSet = statement.executeQuery();

            int typeID = -1;

            if(resultSet.next()){
                typeID = resultSet.getInt("typeid");
            }
            // �����������õ��������͵�id��

            System.out.println(typeID);

            String sql2="insert into reader values (?,?,?,?,?,?,?,?,?)";

            // ռλ���滻
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

            // ִ��sql�������
            ret = statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }

        return ret;
    }


    // ɾ  ���ݶ��ߵı�Ž���ɾ������
    public static int deleteReader(String readerid){

        // �ȶ������ݿ����ӣ�Ԥ����
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;


        try{
            //1.��ȡ�����ݿ�����
            connection = Dao.getConnection();
            //2.ƴװsql���
            String sql="delete from reader where readerid = ?";
            statement = connection.prepareStatement(sql);

            // ռλ���滻
            statement.setString(1,readerid);

            // 3.ִ��sql���
            ret = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Dao.close(null,statement,connection);
        }
        return ret;
    }


    // ��
    public static int updateReader(Reader reader){
        Connection connection = Dao.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;


        try {
            // ƴ��sql��� �Ӷ������ͱ� readertype �и��� typename���� readerid
            String sql1="select typeid from readertype where typename= ?" ;
            statement = connection.prepareStatement(sql1);
            // ռλ���滻
            statement.setString(1,reader.getTypename());

            System.out.println(reader.getTypename());

            // ִ��sql��ѯ���
            resultSet = statement.executeQuery();

            int typeID = -1;

            if(resultSet.next()){
                typeID = resultSet.getInt("typeid");
            }

            System.out.println(typeID);
            // �����������õ��������͵�id��

            //update book set bookname='���������',author='Ф����',
            //publish='��������ѧ������',price=34,
            //typeid=1,publishdate='20180101' where isbn='003'

            // ƴ��sql �޸����
            String sqlUpdat="update reader set name=?,sex=?,age=?,phone=?,dept=?,regdate=?,typeid=? ,typename=? where readerid=?";
            statement = connection.prepareStatement(sqlUpdat);

            // ռλ���滻

            statement.setString(1,reader.getName());
            statement.setString(2,reader.getSex());
            statement.setInt(3,reader.getAge());
            statement.setString(4,reader.getPhone());
            statement.setString(5,reader.getDept());
            statement.setString(6,reader.getRegdate());
            statement.setInt(7,typeID);
            statement.setString(8,reader.getTypename());
            statement.setString(9,reader.getReaderid());


            // ִ��sql���
            ret = statement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }finally {
            Dao.close(resultSet,statement,connection);
        }
        return ret;
    }

    // ��
    public static List<Reader> selectReader(String s1, String s2){
        //һ������������ѡ�е��ַ�����һ����

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reader> list =new ArrayList<Reader>();


        try {
            //1.�������ݿ�
            connection = Dao.getConnection();

            // 2.ƴ��sql���
            String sql = "select  readerid ,name,sex,age,phone,dept,regdate,reader.typeid,readertype.typename from reader JOIN readertype on reader.typeid=readertype.typeid";
//            System.out.println("ִ�е���if��ǰһ��");

            if (s1.equals("���߱��")){
//                System.out.println("ִ����if�ж�");
                sql = sql+" where readerid='" + s2 + "'";
            }

//            System.out.println("ִ����if�ж�֮�������");

            System.out.println(sql);

            //3.ִ��sql��ѯ���
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            //���԰�������Ĳ�ѯ����������ǰ��Ľ��������ơ�
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
