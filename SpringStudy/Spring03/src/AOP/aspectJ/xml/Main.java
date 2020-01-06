package AOP.aspectJ.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //注解
        //ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-aspectJ_annotation.xml");

        //XML配置
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-aspectJ_xml.xml");
        ArithmeticCalaulator ac= ctx.getBean("arithmeticCalculatorImpl", ArithmeticCalaulator.class);
        int result=ac.add(1,2);
        System.out.println("Main Result:"+ result);

//        result=ac.div(10,0);
//        System.out.println("Main Result: "+ result);
    }
}
