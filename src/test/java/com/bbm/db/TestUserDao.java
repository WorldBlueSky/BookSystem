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
            System.out.println("����ʧ��!");
        }else{
            System.out.println("���ӳɹ�!");
        }
    }

//    @Test
//    public void testDelete(){
//       int ret = UserDao.deleteUser(3);
//       if(ret==0){
//           System.out.println("ɾ��ʧ��!");
//       }else{
//           System.out.println("ɾ���ɹ�!");
//       }
//    }
//
//    @Test
//    public void testUpdate(){
//          // ����޸���Ҫ�漰�� �û����޸��������
//        int ret = UserDao.updateUser("root","00000000");
//        if(ret==0){
//            System.out.println("�޸�ʧ��");
//        }else{
//            System.out.println("�޸ĳɹ�");
//        }
//    }


//
//    @Test
//    public void testSelect(){
//        // ��ѯ�����û�
//        List<User> list = UserDao.selectUser();
//        for (User user:list) {
//            System.out.println(user);
//        }
//    }
}
