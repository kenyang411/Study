package aop.proxy;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //将动态生成的代理类保存下来
        Properties properties=System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");


        //目标对象
        ArithmeticCalaulator target= new ArithmeticCalculatorImpl();

        //获取代理对象
        Object obj=new ArithmeticCalculatorProxy(target).getProxy();

        //转回具体的类型
        ArithmeticCalaulator proxy= (ArithmeticCalaulator) obj;

        int i=10;
        int j=20;
        int sum= proxy.add(i,j);
        System.out.println(sum);
    }
}
