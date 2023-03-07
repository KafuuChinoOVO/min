import com.min.pojo.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyText{
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
////        UserServiceImpl user = (UserServiceImpl) context.getBean("userServiceImpl");
//        UserServiceReduce user = (UserServiceReduce) context.getBean("userServiceReduce");
//        user.calculation();

//        UserServiceImpl userService = new UserServiceImpl();
//
//        Proxys proxy = new Proxys(userService);
//        proxy.calculation();
//        UserServiceImpl userService = new UserServiceImpl();
//        ProxyInvocationhandler pih = new ProxyInvocationhandler();
//        pih.setTarget(userService);
//        UserService proxy = (UserService) pih.getProxy();
//        proxy.calculation();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.calculation1();
    }
}
