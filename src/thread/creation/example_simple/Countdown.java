package thread.creation.example_simple;

public class Countdown extends Thread{

    public Countdown(String name){
        super(name);
    }
    public void run(){
        for(int i = 59 ; i >= 0; i-- ){
            System.out.println("Sono: " +
            Thread.currentThread().getName()
            + " " + i
            );
        }
    }
}