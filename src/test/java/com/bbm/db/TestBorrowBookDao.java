package com.bbm.db;

import com.bbm.model.BorrowBook;
import org.junit.Test;

import java.util.List;

public class TestBorrowBookDao {

    @Test
    public void testInsert(){
        int ret = BorrowBookDao.borrowBook("23","0000000","2022-1-1");
        if(ret==0){
            System.out.println("���ʧ��!");
        }else{
            System.out.println("��ӳɹ�!");
        }
    }

    @Test
    public void testSelect(){
        List<BorrowBook> list = BorrowBookDao.selectBorrowBook();
        for (BorrowBook borrowBook:list) {
            System.out.println(borrowBook);
        }
    }

    @Test
    public void testDelete(){
        int ret = BorrowBookDao.returnBook("0000000");
        if(ret==0){
            System.out.println("ɾ��ʧ��!");
        }else{
            System.out.println("ɾ���ɹ�!");
        }
    }
}
