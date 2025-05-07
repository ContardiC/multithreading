package thread.join;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> inputNumbers = Arrays.asList(0L, 34235L, 3544L, 232L, 23L, 4656L);
        // Vogliamo calcolare il fattoriale di ogni elemento

        // Creiamo la lista di threads
        List<FactorialThread> threads = new ArrayList<>();
        for(long inputNumber : inputNumbers){
            threads.add(new FactorialThread(inputNumber));
        }

        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            try {
                thread.join(2000); // decido un tempo massimo in modo che se un numero sia troppo grande da calcolare in un tempo ragionevole lo termino
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // controllando se il thread è finito con il metodo isFinished (metodo troppo dispendioso per CPU)
        for(int i = 0; i < inputNumbers.size(); i++){
            FactorialThread factorialThread = threads.get(i);
            if(factorialThread.isFinished()){ // race condition
                System.out.println("Factorial of: " + inputNumbers.get(i) + "is " + factorialThread.getResult());
            }else{
                System.out.println("The calculation for " + inputNumbers.get(i) + "is still in progress");
            }
        }
    }
}