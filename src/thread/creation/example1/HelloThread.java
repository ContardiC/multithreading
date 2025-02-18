package thread.creation.example1;

public class HelloThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
    
}
