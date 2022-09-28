package com.bbm.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReaderType {
    // 读者类型编号
    private int typeid;
    // 可借图书期限天数
    private int limit;
    // 可借图书数量
    private int maxborrownum;
    // 读者类型名称
    private String typename;


}
