package thread.sync;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class RisorsaLimitata {
    private int id;

    public RisorsaLimitata(int id) {
        this.id = id;
    }

    public void usa() throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName() + " sta usando la Risorsa " + id);
        // Simula l'utilizzo della risorsa
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Thread " + Thread.currentThread().getName() + " ha finito di usare la Risorsa " + id);
    }
}

class TaskUtilizzatore implements Runnable {
    private Semaphore semaforo;
    private RisorsaLimitata[] risorse; // Pool di risorse
    private int idTask;

    public TaskUtilizzatore(Semaphore semaforo, RisorsaLimitata[] risorse, int idTask) {
        this.semaforo = semaforo;
        this.risorse = risorse;
        this.idTask = idTask;
    }

    @Override
    public void run() {
        System.out.println("Task " + idTask + " avviato.");
        try {
            System.out.println("Task " + idTask + " in attesa di acquisire un permesso...");
            semaforo.acquire(); // Acquisisce un permesso (blocca se non disponibile)
            System.out.println("Task " + idTask + " ha acquisito un permesso.");

            // Trova una risorsa disponibile (in questo semplice esempio, ne prendiamo una a caso)
            RisorsaLimitata risorsaInUso = null;
            for (RisorsaLimitata r : risorse) {
                // In un'applicazione reale, dovresti gestire l'assegnazione delle risorse in modo più sofisticato
                // Qui per semplicità, assumiamo che ogni permesso corrisponda all'accesso a una risorsa generica del pool.
                risorsaInUso = r;
                break;
            }

            if (risorsaInUso != null) {
                risorsaInUso.usa(); // Utilizza la risorsa
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release(); // Rilascia il permesso
            System.out.println("Task " + idTask + " ha rilasciato un permesso.");
        }
         System.out.println("Task " + idTask + " terminato.");
    }
}
