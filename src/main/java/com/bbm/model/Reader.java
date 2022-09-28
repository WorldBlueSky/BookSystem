package com.bbm.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Reader {

    // 读者的年龄
    private int age;

    // 读者所在的部门
    private String dept;

    // 读者借书的最大期限天数 ，联表查询
    private  int limit;

    // 读者最多能借几本书， 联表查询
    private int maxborrownum;

    //读者的姓名
    private String name;

    // 读者的手机号码
    private String phone;

    // 读者的用户id
    private String readerid;

    // 注册日期
    private String regdate;

    // 读者的性别、
    private String sex;

    //读者的 类型id
    private int typeid;

    //读者的 类型名字
    private  String typename;


}
