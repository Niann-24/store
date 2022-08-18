package store.service;

import com.cy.store.StoreApplication;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = StoreApplication.class)//标注当前类为测试类，不会跟项目一块打包发送
@RunWith(SpringRunner.class)//表示启动这个单元测试类（不写不能运行单元测试） 参数必须是SpringRunner的实例类型
public class UserServiceImplTest {

    @Resource
    private IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("年年");
            user.setPassword("123");
            System.out.println(user);
            userService.reg(user);
            System.out.println("OK！");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User test = userService.login("年年", "123");
        System.out.println(test);
    }

    @Test
    public void test(){
        userService.changePassword(1,"年年123","123","321");
    }
}
