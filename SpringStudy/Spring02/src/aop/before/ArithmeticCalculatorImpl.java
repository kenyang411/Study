package aop.before;

public class ArithmeticCalculatorImpl implements ArithmeticCalaulator {

    @Override
    public int add(int i, int j) {
        System.out.println("日志记录: The method add begin with [" + i + "," + j + "]");
        var result = i + j;
        System.out.println("日志记录: The method add end with:" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志记录: The method sub begin with [" + i + "," + j + "]");
        var result = i - j;
        System.out.println("日志记录: The method sub end with:" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志记录: The method mul begin with [" + i + "," + j + "]");
        var result = i * j;
        System.out.println("日志记录: The method mul end with:" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志记录: The method div begin with [" + i + "," + j + "]");
        var result = i / j;
        System.out.println("日志记录: The method div end with:" + result);
        return result;
    }
}
