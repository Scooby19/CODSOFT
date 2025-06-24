import java.util.Scanner;
import java.util.Random;
//NUMBER GAME :)
public class task1{
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    int guess;
    int randomNumber = ran.nextInt(100)+1;
    void welcome(){
        System.out.println("WELCOME TO THE NUMBER GUESSING GAME");
    }
    void check(){
        System.out.println("Enter your guess number between 1 to 100");
      
        do{
            guess = sc.nextInt();
            if(guess>randomNumber){
                System.out.println("YOUR GUESS IS QUITE HIGHER THAN ACTUAL VALUE");
            }
            else if(guess<randomNumber){
                System.out.println("YOUR GUESS IS QUITE LOW THAN THE NUMBER");
            }
            else{
                System.out.println("CONGRATULATIONS! CORRECT GUESS...  :)");
            }

        }while(guess!=randomNumber);
    }
    public static void main(String[] args) {
        task1 obj = new task1();
        obj.welcome();
        obj.check();
    }
}