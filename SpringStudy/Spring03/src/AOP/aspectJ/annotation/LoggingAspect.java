package AOP.aspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 日志切面
 */


@Component  //先标识为一个组件
@Aspect     //标识为一个切面
@Order(2)
public class LoggingAspect {

    /**
     * 前置通知：在目标方法执行之前执行
     */
    @Before(value = "execution(public int AOP.aspectJ.annotation.ArithmeticCalculatorImpl.add(int ,int ))")
    public void beforeMethod(JoinPoint joinPoint) {
        //获取方法的参数
        Object[] args = joinPoint.getArgs();
        //方法的名字
        String methodName = joinPoint.getSignature().getName();

        System.out.println("LoggingAspect==>The method " + methodName + " begin with " + Arrays.asList(args));
    }

    /**
     * 后置通知：在目标方法执行之后执行，不管目标方法有没有抛出异常。不能获取方法的结果
     * execution(* AOP.aspectJ.annotation.*.*(..))  //泛型匹配
     * <p>
     * 连接点对象： JoinPoint
     */
    @After(value = "execution(* AOP.aspectJ.annotation.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        //方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect==>The method " + methodName + " end with " + Arrays.asList(args));
    }

    /**
     * 返回通知：在目标方法正常执行结束后执行，可以获取到方法的返回值;
     * <p>
     * 获取方法的返回值：通过returning 来指定一个名字，必须要与方法的一个形参名一致
     */
    @AfterReturning(value = "execution(* AOP.aspectJ.annotation.*.*(..))", returning = "result")
    public void afterReturingMehtod(JoinPoint joinPoint, Object result) {
        //方法的名字
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LoggingAspect==>The method " + methodName + " end with: " + result);
    }

    /**
     * 异常通知：在目标方法抛出异常后执行
     * <p>
     * 获取方法的异常：通过throwing来指定一个名字，必须要与方法的一个形参名一致
     * <p>
     * 可以通过形参中异常的类型，来设置抛出指定异常才会执行的异常通知
     */
    @AfterThrowing(value = "execution(* AOP.aspectJ.annotation.*.*(..))", throwing = "ex")
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


