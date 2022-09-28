package com.bbm.db;

import com.bbm.model.ReaderType;
import org.junit.Test;

import java.util.List;

public class TestReaderTypeDao {

    @Test
    public void testInsert(){
        ReaderType readerType=new ReaderType();
        readerType.setTypeid(10);
        readerType.setTypename("射手");
        readerType.setMaxborrownum(10);
        readerType.setLimit(100);

        int ret = ReaderTypeDao.insertReaderType(readerType);
       if(ret==0){
           System.out.println("增加失败!");
       }else{
           System.out.println("增加成功!");
       }
    }

    @Test
    public void testDetele(){
        int ret = ReaderTypeDao.deleteReaderType(10);
        if(ret==0){
            System.out.println("删除失败!");
        }else{
            System.out.println("删除成功!");
        }
    }

    @Test
    public void testSelect(){
        // 测试查询全部用户
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
        readerType.setTypename("射手");

        int ret = ReaderTypeDao.updateReaderType(readerType,1);
        if(ret==1){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");
        }
    }
}
