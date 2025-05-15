package thread.sync;

import java.util.concurrent.Semaphore;

public class EsercizioSemaphore {
    public static void main(String[] args) {
        final int NUMERO_RISORSE_DISPONIBILI = 3; // Il numero massimo di risorse utilizzabili contemporaneamente
        final int NUMERO_TASK = 5; // Il numero di thread che proveranno ad accedere alle risorse

        // Crea il Semaphore con il numero di permessi pari al numero di risorse disponibili
        Semaphore semaforo = new Semaphore(NUMERO_RISORSE_DISPONIBILI);

        // Crea un pool di risorse (semplice array per questo esempio)
        RisorsaLimitata[] poolRisorse = new RisorsaLimitata[NUMERO_RISORSE_DISPONIBILI];
        for (int i = 0; i < NUMERO_RISORSE_DISPONIBILI; i++) {
            poolRisorse[i] = new RisorsaLimitata(i + 1);
        }

        // Crea e avvia i thread (TaskUtilizzatore)
        for (int i = 0; i < NUMERO_TASK; i++) {
            Thread thread = new Thread(new TaskUtilizzatore(semaforo, poolRisorse, i + 1));
            thread.start();
        }
    }
}