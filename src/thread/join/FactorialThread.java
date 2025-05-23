package thread.join;

import java.math.BigInteger;

public class FactorialThread extends Thread{
    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber){
        this.inputNumber = inputNumber;
    }

    @Override
    public void run(){
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    public BigInteger factorial(long n){
        BigInteger tempResult = BigInteger.ONE;

        for(long i = n; i > 0; i--){
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }
    public boolean isFinished(){
        return isFinished;
    }
    public BigInteger getResult(){
        return result;
    }

}

