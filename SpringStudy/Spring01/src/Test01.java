import Model.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    private ApplicationContext ctx=null;

    @Before
    public void init(){
        //创建IOC容器对象
        ctx=new ClassPathXmlApplicationContext("spring-in.xml");
    }

    @Test
    public void testAddress2(){
        Address address=ctx.getBean("address2",Address.class);
        System.out.println(address);
    }

    @Test
    public void testAddress1(){
        Address address=ctx.getBean("address1",Address.class);
        System.out.println(address);
    }



}
