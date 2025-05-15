package thread.sync;

import java.util.concurrent.Semaphore;

public class SemaphoreTryAcquireExample {

    private static final Semaphore semaphore = new Semaphore(2);

    static class Worker extends Thread {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " sta tentando di accedere alla risorsa...");

            if (semaphore.tryAcquire()) {
                try {
                    System.out.println(name + " ha ottenuto accesso alla risorsa.");

                    Thread.sleep(2000);

                    System.out.println(name + " ha finito di usare la risorsa.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(name + " ha rilasciato la risorsa.");
                }
            } else {
                System.out.println(name + " NON ha potuto accedere alla risorsa (occupata).");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Worker("Thread-" + i).start();
        }
    }
}