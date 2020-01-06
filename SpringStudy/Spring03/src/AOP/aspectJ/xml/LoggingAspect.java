package AOP.aspectJ.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;


import java.util.Arrays;


public class LoggingAspect {


    public void beforeMethod(JoinPoint joinPoint) {
        //获取方法的参数
        Object[] args = joinPoint.getArgs();
        //方法的名字
        String methodName = joinPoint.getSignature().getName();

        System.out.println("LoggingAspect==>The method " + methodName + " begin with " + Arrays.asList(args));
    }


    public void afterMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        //方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect==>The method " + methodName + " end with " + Arrays.asList(args));
    }


    public void afterReturningMehtod(JoinPoint joinPoint, Object result) {
        //方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect==>The method " + methodName + " end with: " + result);
    }


    public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException ex) {
        //方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect==> Thew method " + methodName + " occurs Exception: " + ex);

    }

//    /**
//     * 环绕通知：环绕着目标方法执行。可以理解为是前置 后置 返回 异常 通知的结合体，更新是动态代理的整个过程。
//     *
//     * 环绕通知和前面几个不同时使用。
//     */
//    @Around(value = "execution(* AOP.aspectJ.annotation.*.*(..))")
//    public Object aroundMethod(ProceedingJoinPoint pjp) {
//        //执行目标方法
//        try {
//            //前置
//            Object result = pjp.proceed();
//            //返回
//            return result;
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }finally {
//            //后置
//        }
//        return null;
//    }

}


