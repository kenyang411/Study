package AOP.aspectJ.xml;


public class ArithmeticCalculatorImpl implements ArithmeticCalaulator {

    @Override
    public int add(int i, int j) {
        var result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        var result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        var result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        var result = i / j;
        return result;
    }
}
