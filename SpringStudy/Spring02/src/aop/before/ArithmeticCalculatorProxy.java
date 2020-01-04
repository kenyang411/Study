package aop.before;

import com.sun.source.tree.ReturnTree;

import java.lang.annotation.Retention;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生成代理对象。
 * <p>
 * JDK的动态代理：
 * 1.Proxy:是所有动态代理类的父类，专门用户生成代理类或者是代理对象
 * public static Class<?> getPRoxyClass(ClassLoader loader,Class<?> ... interfaces)   用于生成代理类的Class对象。
 *
 * public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces InvocationHandler h)     用于生成代理对象
 * <p>
 * 2.InvocationHandler：  完成动态代理的整个过程
 * public Object invoke(Object proxy,Method method,Object[] args) throws Throwable;
 */
public class ArithmeticCalculatorProxy {
    //动态代理： 目标对象  如何获取代理对象   代理要做什么？

    //目标对象
    private ArithmeticCalaulator target;

    public ArithmeticCalculatorProxy(ArithmeticCalaulator target) {
        this.target = target;
    }

    //获取代理对象的方法
    public Object getProxy() {

        //代理对象
        Object proxy;
        /**
         * loader:ClassLoader对象，类加载器对象。帮我们加载动态生成的代理类。
         * interfaces: 接口集；提供目标对象的所有接口。目的是让代理对象保证和表木对象都有接口中相同的方法。
         * h
         */

        ClassLoader loader=target.getClass().getClassLoader();
        Class [] interfaces=target.getClass().getInterfaces();
        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
            /**
             *  invoke: 代理对象调用代理方法，会回来调用invoke方法。
             */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return null;
            }
        });
        return proxy;
    }


}
