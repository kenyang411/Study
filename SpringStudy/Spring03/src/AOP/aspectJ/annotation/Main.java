package AOP.aspectJ.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-aspectJ_annotation.xml");

        ArithmeticCalaulator ac= ctx.getBean("arithmeticCalculatorImpl",ArithmeticCalaulator.class);
        int result=ac.add(1,2);
        System.out.println("Main Result:"+ result);
    }
}
