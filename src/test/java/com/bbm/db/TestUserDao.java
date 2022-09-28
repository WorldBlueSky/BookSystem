package com.bbm.db;

import com.bbm.model.User;
import org.junit.Test;

import java.util.List;

public class TestUserDao {
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("root");
        user.setPassword("root");
        int ret = UserDao.insertUser(user);
        if(ret==0){
            System.out.println("增加失败!");
        }else{
            System.out.println("增加成功!");
        }
    }

//    @Test
//    public void testDelete(){
//       int ret = UserDao.deleteUser(3);
//       if(ret==0){
//           System.out.println("删除失败!");
//       }else{
//           System.out.println("删除成功!");
//       }
//    }
//
//    @Test
//    public void testUpdate(){
//          // 这个修改主要涉及到 用户的修改密码操作
//        int ret = UserDao.updateUser("root","00000000");
//        if(ret==0){
//            System.out.println("修改失败");
//        }else{
//            System.out.println("修改成功");
//        }
//    }


//
//    @Test
//    public void testSelect(){
//        // 查询所有用户
//        List<User> list = UserDao.selectUser();
//        for (User user:list) {
//            System.out.println(user);
//        }
//    }
}
