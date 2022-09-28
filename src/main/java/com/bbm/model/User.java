package com.bbm.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    // 这是系统登陆的 用户信息

    // 用户的id
    private int id;

    // 用户的名字
    private String name;

    // 用户密码
    private String password;


}
