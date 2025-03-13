package thread.creation.example_simple;

public class HelloTread extends Thread{
    public HelloTread(String name){
        super(name);
        // start();
    }
    public void run(){
        System.out.println("Hello ! " + Thread.currentThread().getName() +
        " e la mia priorità vale: " + Thread.currentThread().getPriority()
        );
    }
}
