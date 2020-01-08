package tx.xml.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx.xml.dao.BookShopDao;
import tx.xml.service.BookShopService;
import tx.xml.service.Cashier;

import java.util.ArrayList;
import java.util.List;

public class TestTransaction {


    private BookShopDao bookShopDao;

    private BookShopService bookShopService;

    private Cashier cashier;

    @Before
    public void init(){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-tx_xml.xml");
        bookShopDao=ctx.getBean("bookShopDaoImpl", BookShopDao.class);
        bookShopService=ctx.getBean("bookShopServiceImpl", BookShopService.class);

        cashier=ctx.getBean("cashierImpl", Cashier.class);
    }

    @Test
    public void testTx(){
    bookShopService.buyBook("Tom","ISBN-004");
    }

    @Test
    public void testCheckOut(){
        List<String> isbns=new ArrayList<>();
        isbns.add("ISBN-002");
        isbns.add("ISBN-003");
        cashier.checkOut("Tom",isbns);
    }

}
