package com.bbm.db;

import com.bbm.model.ReaderType;
import org.junit.Test;

import java.util.List;

public class TestReaderTypeDao {

    @Test
    public void testInsert(){
        ReaderType readerType=new ReaderType();
        readerType.setTypeid(10);
        readerType.setTypename("����");
        readerType.setMaxborrownum(10);
        readerType.setLimit(100);

        int ret = ReaderTypeDao.insertReaderType(readerType);
       if(ret==0){
           System.out.println("����ʧ��!");
       }else{
           System.out.println("���ӳɹ�!");
       }
    }

    @Test
    public void testDetele(){
        int ret = ReaderTypeDao.deleteReaderType(10);
        if(ret==0){
            System.out.println("ɾ��ʧ��!");
        }else{
            System.out.println("ɾ���ɹ�!");
        }
    }

    @Test
    public void testSelect(){
        // ���Բ�ѯȫ���û�
        List<ReaderType> list  = ReaderTypeDao.selectReaderType();
        for (ReaderType readerType:list) {
            System.out.println(readerType);
        }
    }

    @Test
    public void testSelectByid(){
        ReaderType readerType =new ReaderType();
//        readerType = ReaderTypeDao.selectReaderTypeById(1);
        System.out.println(readerType);
    }

    @Test
    public void testUpdate(){
        ReaderType readerType=new ReaderType();
        readerType.setTypeid(1);
        readerType.setTypename("����");

        int ret = ReaderTypeDao.updateReaderType(readerType,1);
        if(ret==1){
            System.out.println("�޸ĳɹ�!");
        }else{
            System.out.println("�޸�ʧ��!");
        }
    }
}
