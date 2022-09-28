package com.bbm.db;

import com.bbm.model.Book;
import com.bbm.model.Reader;
import org.junit.Test;

import java.util.List;

public class TestBookDao {

    /**
     * ����BookDao �ķ���
     */

    @Test
    public void testBookDaoInsert(){
          // ���ӵķ��� ������ book,typename
        // ��Ϊ�û������bookֻ��typename��û��typeid
        // Ҫ����typename�ҵ�typeid��Ȼ�����ȥ���� ���������ͼ����Ϣ

        Book book = new Book();
        book.setBookName("���������");
        book.setAuthor("лϣ��");
        book.setPublish("�廪��ѧ������");
        book.setISBN("12345566");
        book.setPublishDate("2002-1-1");
        book.setPrice(13.00);

        // ��û�и����book������ typename ,typeid

        // typename��Ϊ���� ��typeid���������в���

        int ret = BookDao.insertBook(book,"�������");

        if(ret==1){
            System.out.println("��ӳɹ�!");
        }else{
            System.out.println("���ʧ��!");
        }

    }

    @Test
    public void testBookDaoDelete(){
       // ����ISBN����ɾ��
       int ret = BookDao.deleteBook("1111111");
       if(ret==1){
           System.out.println("ɾ���ɹ�!");
       }else{
           System.out.println("ɾ��ʧ��!");
       }
    }

    @Test
    public void testBookDaoSelect(){
      List<Book> list = BookDao.selectBook("����","���������");
        for (Book book:list) {
            System.out.println(book);
        }
    }


    @Test
    public void testBookDaoUpdate(){
      //TODO
    }
}
