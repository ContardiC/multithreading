package thread.creation.example_simple;

public class App {
    public static void main(String[] args) {

        // System.out.println(Thread.currentThread().getName());
        // HelloTread t1 = new HelloTread("FontanaThread");
        // System.out.println("Il main ha priorità : " + Thread.currentThread().getPriority());
        
        // t1.setPriority(8);
        // // GoodByeThread gt = new GoodByeThread();
        // // Thread t2 = new Thread(gt);
        // t1.start();

        // // t2.start();
        // Thread t3 = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println("Hi!");
        //     }
        // });
        // t3.start();       
        Thread t1 = new Countdown("Gianni");
        Countdown t2 = new Countdown("Maka");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
