package com.bbm.db;

import com.bbm.model.BookType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBookTypeDao {

    @Test
    public void testInsert(){
        BookType bookType = new BookType();
        bookType.setTypename("小说");
        bookType.setTypeid(3);

        int ret= BookTypeDao.insertBookType(bookType);
        if(ret==0){
            System.out.println("插入失败!");
        }else{
            System.out.println("插入成功!");
        }
    }

    @Test
    public void testDelete(){

        int ret  = BookTypeDao.deleteBookType(3);
        if(ret==1){
            System.out.println("删除成功!");
        }else{
            System.out.println("删除失败!");
        }
    }

    @Test
    public void testUpdate(){
        BookType bookType = new BookType();
        bookType.setTypeid(1);
        bookType.setTypename("管理类");

        int ret = BookTypeDao.updateBookType(bookType);
        if(ret==1){
            System.out.println("修改成功!");
        }else{
            System.out.println("修改失败!");
        }
    }

    @Test
    public void testSelect(){
        List<BookType> list = new ArrayList<BookType>();
        list = BookTypeDao.selectBookType();

        for (BookType bookType:list) {
            System.out.println(bookType);
        }
    }

    @Test
    public void testSelectById(){
        BookType bookType= new BookType();
//        bookType = BookTypeDao.selectBookTypeById(1);
        System.out.println(bookType);
    }


}
