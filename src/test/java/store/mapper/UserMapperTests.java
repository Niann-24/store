package store.mapper;


import com.cy.store.StoreApplication;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = StoreApplication.class)//标注当前类为测试类，不会跟项目一块打包发送
@RunWith(SpringRunner.class)//表示启动这个单元测试类（不写不能运行单元测试） 参数必须是SpringRunner的实例类型
public class UserMapperTests {


//    @Autowired    idea有检测功能，接口不能直接创建bean的（mybatis 动态代理技术来解决)
    @Resource
     private UserMapper mapper;


    @Test
    public void insert(){
        User user=new User();
        user.setUsername("Test01");
        user.setPassword("123");
        Integer insert = mapper.insert(user);
        System.out.println(insert);
    }


    @Test
    public void findByUsername(){
        User user=mapper.findByUsername("年年");
        System.out.println(user);
    }

    @Test
    public void test(){
        mapper.findByUid(21);
    }


}
