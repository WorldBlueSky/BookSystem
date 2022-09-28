package com.bbm.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BorrowBook {

    // 这本书 借出来的时间
    private String borrowdate;

    // 这本书超期的罚款
    private double fine;

    // 这本书的 ISBN
    private String ISBN;

    // 这本书被哪个读者借走了 ，读者id
    private String readerid;

    // 这本书 归还的最后期限
    private String returndate;

    // 借书的名称
    private String bookname;




}
