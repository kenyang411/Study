package annotation.service;

import annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * @Autowired 完成bean属性的自动装配
     *
     * 工作机制： 首先会使用byType的方式进行自动装配，如果能唯一匹配，则装配成功，如果匹配到多个兼容类型的bean，
     *           还会尝试使用byName的方式进行唯一确定，如果能唯一确定，则装配成功，如果不能唯一确定，则装配失败，抛出异常。
     *           如果两个dao层都继承自一个接口，将会出现异常，这是要给 @Repository添加名字。名字就是依赖注入的名字,示例： @Repository("userDao")
     *
     *           默认情况下，使用@Autowired标注的属性必须被装配，如果装配不了，也会抛出异常。可以使用@Autowired(require=false)设置不是必须被装配。
     *           如果匹配到多个兼容类型的bean，可以使用@Qualifier来进一步指定要装配的bean的ID值。
     *
     *          @Autowired和@Qualifier 注解可在成员变量上，也可以加在对应的set方法上。
     */
    @Autowired
//    @Qualifier("userDaoJdbcImpl")
    private UserDao userDao;

    @Override
    public void handAddUser() {
        userDao.addUser();
    }
}
