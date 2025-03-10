package thread.creation.example2;

public class DescendingHackerThread extends HackerThread{
    int MAX_PASSWORD = 9999;
    public DescendingHackerThread(Vault vault){
        super(vault);
    }
    @Override
    public void run(){
        for(int guess = MAX_PASSWORD; guess >= 0; guess--){
            if(vault.isCorrectPassword(guess)){
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
