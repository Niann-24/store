package com.cy.store.service;

import com.cy.store.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService {
    //用户注册接口
    void  reg(User user);

    //用户登入接口
    User login(String username,String password);

    //修改密码接口
    void changePassword(Integer uid,String username,String oldPassword,String newPassword);


    //修改个人资料
    String alertData(Integer uid,String Phone,String Email,String gender);

}
