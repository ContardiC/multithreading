package thread.creation.example2;

public class Vault {
    private int password;
    public Vault(int password){
        this.password = password;
    }
    public boolean isCorrectPassword(int guess){
        // anche se le credenziali sono corrette rallentiamo
        // di 5 ms
        try{
            Thread.sleep(5);
        }catch (InterruptedException e){

        }
        return this.password == guess;
    }
}
