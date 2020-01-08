package tx.annotation.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx.annotation.dao.BookShopDao;
import tx.annotation.service.BookShopService;
import tx.annotation.service.Cashier;

import java.util.ArrayList;
import java.util.List;

public class TestTransaction {


    private BookShopDao bookShopDao;

    private BookShopService bookShopService;

    private Cashier cashier;

    @Before
    public void init(){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-tx.xml");
        bookShopDao=ctx.getBean("bookShopDaoImpl",BookShopDao.class);
        bookShopService=ctx.getBean("bookShopServiceImpl",BookShopService.class);

        cashier=ctx.getBean("cashierImpl",Cashier.class);
    }

    @Test
    public void testTx(){
    bookShopService.buyBook("Tom","ISBN-001");
    }

    @Test
    public void testCheckOut(){
        List<String> isbns=new ArrayList<>();
        isbns.add("ISBN-002");
        isbns.add("ISBN-003");
        cashier.checkOut("Tom",isbns);
    }

}
