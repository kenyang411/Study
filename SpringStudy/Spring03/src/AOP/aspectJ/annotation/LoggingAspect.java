package AOP.aspectJ.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */


@Component  //先标识为一个组件
@Aspect     //标识为一个切面
public class LoggingAspect {

    /**
     * 前置通知：在目标方法执行之前执行
     */
    @Before(value = "execution(public int AOP.aspectJ.annotation.ArithmeticCalculatorImpl.add(int ,int ))")
public void beforeMethod(){
        System.out.printf("LoggingAspect==>The method xxx begin with [x,y]");
}
}
