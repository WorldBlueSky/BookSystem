package com.bbm.db;

import com.bbm.model.Reader;
import com.bbm.model.ReaderType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReaderDao {

    @Test
    public void testInsert(){
        Reader reader = new Reader();

        // ����typeid  �� typename ������һ��
        reader.setName("������");
        reader.setSex("��");
        reader.setAge(30);
        reader.setPhone("1398989889");
        reader.setDept("�������");
        reader.setRegdate("2021-21-1");
        reader.setReaderid("0010");

        int ret =ReaderDao.insertReader(reader,"��ʦ");
        if(ret==0){
            System.out.println("����ʧ��!");
        }else{
            System.out.println("���ӳɹ�!");
        }
    }

    @Test
    public void testDelete(){
        int ret =ReaderDao.deleteReader("12");
        if(ret==0){
            System.out.println("ɾ��ʧ��!");
        }else{
            System.out.println("ɾ���ɹ�!");
        }
    }

    @Test
    public void testSelect(){
        // ������������ѡ���Ӧ���ֲ�ѯ
        List<Reader> list = new ArrayList<Reader>();
        // ���ݶ��߱�Ž��в�ѯ
        list = ReaderDao.selectReader("���߱��","1111");
        for (Reader reader:list) {
            System.out.println(reader);
        }
    }
}
