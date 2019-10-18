package com.example.pojo;

import com.example.enumration.SexEnum;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

/**
 * com.example.pojo
 *
 * @author zhangdongxiao
 * @create 2019-08-26 16:56
 * @desc
 */
//@Entity(name = "user")
//@Table(name = "t_user")
@Alias(value = "user")
public class User {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @Column(name = "user_name")
    private String userName;
    private String note;
    //    @Convert(converter = SexConverter.class)
    private SexEnum sex;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
