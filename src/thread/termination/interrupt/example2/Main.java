package thread.termination.interrupt.example2;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("24444444444"), new BigInteger("232323232323232323")));
        // thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }
    public static class LongComputationTask implements Runnable{
        BigInteger base;
        BigInteger power;
        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+power+" = "+pow(base,power));
        }
        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            // Example: base=2 power=3
            //          result = 1
            //          i = 0; i!=power; i++
            //              result=result*base
            return result;
        }
    }
}
