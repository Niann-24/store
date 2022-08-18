package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


@Service //@Service：将当前类对象交给spring管理，可以自动创建对象和对象的维护
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        User byUsername = userMapper.findByUsername(user.getUsername());
        if(byUsername!=null) throw new UsernameDuplicatedException("用户名被占用！！！");//用户名已注册
        //将密码和盐值设为整体加密
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(user.getPassword(), salt);
        user.setPassword(md5Password);//设置密码加密后的密码
        user.setSalt(salt);//保存盐值
        // 补全数据
        user.setIsDelete(0);// is_delete =0
        //四个日志信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());
        Integer result = userMapper.insert(user);
        if(result!=1) throw new InsertException("未知异常");//数据插入时产生的异常
    }

    /**
     * 登录页面
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if(user==null) throw new UserNonentityException("用户名不存在");
        if(user.getIsDelete() == 1) throw new UserNonentityException("用户名不存在");
        User LoginUser = userMapper.UserLogin(username, getMD5Password(password, user.getSalt()));
        if(LoginUser == null) throw new PasswordErrorException("密码错误");
        return LoginUser;
    }

    /**
     * 修改密码

     * @return User
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result==null) throw  new UserNonentityException("未找到该用户");
        String dataPwd = getMD5Password(oldPassword, result.getSalt());
        if(!dataPwd.equals(result.getPassword())) throw new PasswordErrorException("原密码错误");
        //将新密码更新
        String newDataPwd = getMD5Password(newPassword, result.getSalt());
        Integer i = userMapper.updatePassword(uid, newDataPwd, username, new Date());
        if(i != 1) throw new InsertException("更新数据产生异常");
    }


    /**
     * 修改个人资料
     * @param uid
     * @param Phone
     * @param Email
     */
    @Override
    public String alertData(Integer uid, String Phone, String Email,String gender) {
        int sex= gender.equals("男")? 0:1;
        User result = userMapper.updateData(uid, Phone, Email, sex);
        if(result == null) throw new InsertException("更新个人信息失败！");
        return result.getUsername();
    }




    //md5加密算法处理
    private String getMD5Password(String password,String salt){
        //md5加密算法的方法进行三次加密
        for (int i=0;i < 3;i++){password= DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();}
       return password;
    }

}
