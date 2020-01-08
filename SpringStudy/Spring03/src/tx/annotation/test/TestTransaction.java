package tx.annotation.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx.annotation.dao.BookShopDao;
import tx.annotation.service.BookShopService;

public class TestTransaction {


    private BookShopDao bookShopDao;

    private BookShopService bookShopService;

    @Before
    public void init(){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-tx.xml");
        bookShopDao=ctx.getBean("bookShopDaoImpl",BookShopDao.class);
        bookShopService=ctx.getBean("bookShopServiceImpl",BookShopService.class);
    }

    @Test
    public void testTx(){
    bookShopService.buyBook("Tom","ISBN-001");
    }
}
