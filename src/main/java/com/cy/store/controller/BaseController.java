package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

//控制层类的基类
public class BaseController {
    /** 操作成功！*/
    public static final int OK=200;

    /* 请求处理方法 */
    //ExceptionHandler 会自动将异常对象传递给此方法的参数列表上
    @ExceptionHandler(ServiceException.class)//统一处理抛出的异常
    public JsonResultVO<Void> handleException(Throwable e ){
        if (e instanceof UsernameDuplicatedException) return new JsonResultVO<>(4000,"用户名已被占用",null);
        if(e instanceof InsertException) return new JsonResultVO<>(5000,"产生未知异常",null);
        if(e instanceof UserNonentityException) return new JsonResultVO<>(3000,"用户名不存在",null);
        if(e instanceof PasswordErrorException) return  new JsonResultVO<>(2000,"密码错误",null);
        if(e instanceof  OldPasswordErrorException) return new JsonResultVO<>(2000,"旧密码错误",null);
        return null;
    }

    /**
     * 获取sessionID
     * @param session
     * @return
     */
    protected final Integer getuidSession(HttpSession session){
        return  Integer.valueOf(session.getAttribute("uid").toString()) ;
    }

    /**
     * 获取当前登用户的username
     */
        protected  final String getUsernameSession(HttpSession session){
            return session.getAttribute("username").toString();
    }
}
