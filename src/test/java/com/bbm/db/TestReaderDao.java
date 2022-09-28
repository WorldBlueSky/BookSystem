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

        // 除了typeid  和 typename 都设置一下
        reader.setName("凌凌漆");
        reader.setSex("男");
        reader.setAge(30);
        reader.setPhone("1398989889");
        reader.setDept("间谍部门");
        reader.setRegdate("2021-21-1");
        reader.setReaderid("0010");

        int ret =ReaderDao.insertReader(reader,"教师");
        if(ret==0){
            System.out.println("增加失败!");
        }else{
            System.out.println("增加成功!");
        }
    }

    @Test
    public void testDelete(){
        int ret =ReaderDao.deleteReader("12");
        if(ret==0){
            System.out.println("删除失败!");
        }else{
            System.out.println("删除成功!");
        }
    }

    @Test
    public void testSelect(){
        // 下拉框有两个选项，对应两种查询
        List<Reader> list = new ArrayList<Reader>();
        // 根据读者编号进行查询
        list = ReaderDao.selectReader("读者编号","1111");
        for (Reader reader:list) {
            System.out.println(reader);
        }
    }
}
