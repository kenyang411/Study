package AOP.aspectJ.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 验证切面
 */
@Component      //标识为组件
@Aspect         //标识为切面
@Order(1)        //设置切面优先级  2147483647(默认值)
public class ValidationAspect {

    /**
     * 声明切入点表达式
     * @param joinPoint
     */
@Pointcut("execution(* AOP.aspectJ.annotation.*.*(..)))")
public void declarePointCut(){ }

//    @Before(value = "execution(* AOP.aspectJ.annotation.*.*(..)))")
    @Before("declarePointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        //获取方法名
        String methodName=joinPoint.getSignature().getName();

        //获取参数
        Object[] args=joinPoint.getArgs();
        System.out.println("ValidationAspect==>The method "+ methodName + " begin with "+ Arrays.asList(args));
    }
}
