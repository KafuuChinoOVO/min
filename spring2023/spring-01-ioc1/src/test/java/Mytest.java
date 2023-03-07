import com.min.dao.UserDaoImpl;
import com.min.dao.UserDaoMysqlImpl;
import com.min.dao.UserDaoOracleImpl;
import com.min.service.UserService;
import com.min.service.UserServiceImpl;

public class Mytest {

    public static void main(String[] args){

        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
