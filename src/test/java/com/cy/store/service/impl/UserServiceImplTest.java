package com.cy.store.service.impl;

import com.cy.store.StoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@SpringBootTest(classes = StoreApplication.class)//标注当前类为测试类，不会跟项目一块打包发送
@RunWith(SpringRunner.class)//表示启动这个单元测试类（不写不能运行单元测试） 参数必须是SpringRunner的实例类型
public class UserServiceImplTest {

    @Resource
    UserServiceImpl service;

    @Test
    public void alertData() {
        service.alertData(28,"123456780","123@qq.com","男");
    }
}