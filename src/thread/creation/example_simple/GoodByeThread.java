package thread.creation.example_simple;

public class GoodByeThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Good Bye!");
    }
}
