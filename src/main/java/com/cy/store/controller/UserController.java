package com.cy.store.controller;


import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResultVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("/users")
@RestController // RestController= @Controller+@ReponseBody
public class UserController extends BaseController{
    @Resource
    private IUserService userService;

    /**
     * 注册接口
     * @param user
     * @return JsonResultVo
     */
    @Transactional//事务
    @PostMapping("reg")
    public JsonResultVO<Void> reg(User user){
        userService.reg(user);
        return  new JsonResultVO<>(OK);
    }

    /**
     * 用户登入接口

     * @return username
     */
    @PostMapping("login")
    public JsonResultVO<User> login(String username, String password ,HttpSession session ){
        User login = userService.login(username, password) ;
        //存储用户登录信息
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());
        return new JsonResultVO<User>(OK,"登入成功！",login);
    }

    /*
      修改密码
     */
    @RequestMapping("passwd")
    public JsonResultVO<Void> changePwd(String oldPassword,String newPassword,HttpSession session){
        Integer uid=getuidSession(session);
        String username=getUsernameSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResultVO<>(OK,"修改成功!",null);
    }

    /*
        更新个人资料
     */
    @GetMapping("UpdatePersonalInfo")
    public JsonResultVO<String> UpdatePersonalInfo(String phone,String email,String gender,HttpSession session){
        Integer uid=getuidSession(session);
        String username = userService.alertData(uid, phone, email, gender);
        return new JsonResultVO<String>(OK,"更新成功！","用户名："+username);
    }
}
