package thread.creation.example1;

public class GoodByeThread extends Thread{

    public GoodByeThread(String threadName){
        super(threadName);
    }
    public void run(){
        System.out.println("GoodBye!");
    }
}
