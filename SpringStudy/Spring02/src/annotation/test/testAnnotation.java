package annotation.test;

import annotation.controller.UserController;
import annotation.dao.UserDao;
import annotation.dao.UserDaoImpl;
import annotation.service.UserService;
import annotation.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnnotation {
    @Test
    public void Test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-annotation.xml");
        UserController uc=ctx.getBean("userController",UserController.class);
        System.out.println("userController:"+uc);

        uc.register();      //自动装配

//        UserService uService=ctx.getBean("userServiceImpl",UserServiceImpl.class);
//        System.out.println("userService:"+uService);
//
//        UserDao uDao=ctx.getBean("userDaoImpl",UserDaoImpl.class);
//        System.out.println("userDao:"+uDao);
    }

}
