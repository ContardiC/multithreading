package thread.creation.example1;

public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloThread());
        t1.start();
    }
}
