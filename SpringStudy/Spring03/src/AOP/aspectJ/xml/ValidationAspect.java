package AOP.aspectJ.xml;

import org.aspectj.lang.JoinPoint;


import java.util.Arrays;


public class ValidationAspect {


    public void beforeMethod(JoinPoint joinPoint){
        //获取方法名
        String methodName=joinPoint.getSignature().getName();

        //获取参数
        Object[] args=joinPoint.getArgs();
        System.out.println("ValidationAspect==>The method "+ methodName + " begin with "+ Arrays.asList(args));
    }
}
