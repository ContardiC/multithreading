package thread.creation.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{
    static int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        int randNum = random.nextInt(0,MAX_PASSWORD);
        Vault vault = new Vault(randNum);

        ArrayList<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread : threads){
            thread.start();
        }
    }

}