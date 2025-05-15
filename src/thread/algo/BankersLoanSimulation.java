package thread.algo;
import java.util.Random;

public class BankersLoanSimulation {
    static final int NUM_SOCI = 3;
    static final int TOTAL_FONDI = 30000;
    static int[] max = {10000, 20000, 30000};       // Importi richiesti
    static int[] allocation = {0, 0, 0};            // Somme già concesse
    static int[] need = new int[NUM_SOCI];          // Quello che manca
    static int available = TOTAL_FONDI;

    static final Object lock = new Object();

    static class Socio extends Thread {
        int id;
        Random rand = new Random();

        Socio(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Due acconti
                for (int i = 0; i < 2; i++) {
                    int richiesta = rand.nextInt(need[id] / 2 + 1);
                    richiediFido(richiesta);
                    Thread.sleep(rand.nextInt(1000) + 500); // Simula tempo reale
                }

                // Saldo finale
                richiediFido(need[id]);

                System.out.println("Socio " + id + " ha ricevuto l'intero fido.");
                Thread.sleep(rand.nextInt(3000) + 1000); // Simula uso del fido

                // Restituzione totale
                restituisciFido();
                System.out.println("Socio " + id + " ha restituito il fido.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void richiediFido(int amount) throws InterruptedException {
            synchronized (lock) {
                while (!puoEssereSoddisfatta(id, amount)) {
                    lock.wait();
                }

                allocation[id] += amount;
                need[id] -= amount;
                available -= amount;

                System.out.println("Socio " + id + " riceve " + amount + "€. Totale: " + allocation[id] + "€. Disponibili: " + available + "€");
                lock.notifyAll();
            }
        }

        void restituisciFido() {
            synchronized (lock) {
                available += allocation[id];
                allocation[id] = 0;
                need[id] = max[id];
                lock.notifyAll();
            }
        }
    }

    static boolean puoEssereSoddisfatta(int id, int richiesta) {
        if (richiesta > need[id]) return false;
        if (richiesta > available) return false;

        int tempAvailable = available - richiesta;

        int[] tempNeed = new int[NUM_SOCI];
        int[] tempAllocation = new int[NUM_SOCI];

        // Copia manuale dei valori
        for (int i = 0; i < NUM_SOCI; i++) {
            tempNeed[i] = need[i];
            tempAllocation[i] = allocation[i];
        }

        tempNeed[id] -= richiesta;
        tempAllocation[id] += richiesta;

        boolean[] finish = new boolean[NUM_SOCI];
        int temp = tempAvailable;

        for (int count = 0; count < NUM_SOCI; count++) {
            boolean found = false;
            for (int i = 0; i < NUM_SOCI; i++) {
                if (!finish[i] && tempNeed[i] <= temp) {
                    temp += tempAllocation[i];
                    finish[i] = true;
                    found = true;
                }
            }
            if (!found) break;
        }

        for (boolean f : finish)
            if (!f) return false;

        return true;
    }

    public static void main(String[] args) {
        // Inizializzazione del vettore need
        for (int i = 0; i < NUM_SOCI; i++) {
            need[i] = max[i];
        }

        System.out.println("Inizio simulazione banca...\n");

        for (int i = 0; i < NUM_SOCI; i++) {
            new Socio(i).start();
        }
    }
}