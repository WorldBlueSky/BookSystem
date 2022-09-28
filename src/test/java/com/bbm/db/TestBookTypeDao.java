package com.bbm.db;

import com.bbm.model.BookType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBookTypeDao {

    @Test
    public void testInsert(){
        BookType bookType = new BookType();
        bookType.setTypename("С˵");
        bookType.setTypeid(3);

        int ret= BookTypeDao.insertBookType(bookType);
        if(ret==0){
            System.out.println("����ʧ��!");
        }else{
            System.out.println("����ɹ�!");
        }
    }

    @Test
    public void testDelete(){

        int ret  = BookTypeDao.deleteBookType(3);
        if(ret==1){
            System.out.println("ɾ���ɹ�!");
        }else{
            System.out.println("ɾ��ʧ��!");
        }
    }

    @Test
    public void testUpdate(){
        BookType bookType = new BookType();
        bookType.setTypeid(1);
        bookType.setTypename("������");

        int ret = BookTypeDao.updateBookType(bookType);
        if(ret==1){
            System.out.println("�޸ĳɹ�!");
        }else{
            System.out.println("�޸�ʧ��!");
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
