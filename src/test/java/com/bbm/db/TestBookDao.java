package com.bbm.db;

import com.bbm.model.Book;
import com.bbm.model.Reader;
import org.junit.Test;

import java.util.List;

public class TestBookDao {

    /**
     * 测试BookDao 的方法
     */

    @Test
    public void testBookDaoInsert(){
          // 增加的方法 参数是 book,typename
        // 因为用户传入的book只有typename，没有typeid
        // 要传入typename找到typeid，然后填进去即可 添加完整的图书信息

        Book book = new Book();
        book.setBookName("计算机网络");
        book.setAuthor("谢希仁");
        book.setPublish("清华大学出版社");
        book.setISBN("12345566");
        book.setPublishDate("2002-1-1");
        book.setPrice(13.00);

        // 我没有给这个book对象传入 typename ,typeid

        // typename作为参数 ，typeid在其他表中查找

        int ret = BookDao.insertBook(book,"计算机类");

        if(ret==1){
            System.out.println("添加成功!");
        }else{
            System.out.println("添加失败!");
        }

    }

    @Test
    public void testBookDaoDelete(){
       // 根据ISBN进行删除
       int ret = BookDao.deleteBook("1111111");
       if(ret==1){
           System.out.println("删除成功!");
       }else{
           System.out.println("删除失败!");
       }
    }

    @Test
    public void testBookDaoSelect(){
      List<Book> list = BookDao.selectBook("书名","计算机网络");
        for (Book book:list) {
            System.out.println(book);
        }
    }


    @Test
    public void testBookDaoUpdate(){
      //TODO
    }
}
