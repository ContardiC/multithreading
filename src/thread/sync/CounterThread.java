package thread.sync;

public class CounterThread extends Thread{
    private Counter counter;
    public CounterThread(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for(int i=0;i<1000;i++){
            counter.increment();
            System.out.println(counter.count);
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join(); //Manda in attesa il Thread principale fino alla fine dell'esecuzione di t1
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
