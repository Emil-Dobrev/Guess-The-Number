import java.util.Random;
import java.util.Scanner;



public class Main {
   static int bestScore = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

           boolean isGame = true ;
          while(isGame){
              isGame = Game();
              if(isGame == false){
                  System.out.printf("Nice game! Your best score is: %d  \n" , bestScore);
                  System.out.printf("Press '1' to play again.\nPress '2' to quit.\n");
                  int select = Integer.parseInt(scn.nextLine());
                  if(select==1){
                      isGame = true;
                  }else if(select == 2){
                      return;
                  }
              }

          }





    }
    private static boolean  Game(){
        Scanner scn = new Scanner(System.in);
        int guessCount = 0 ;
        int computerNumber = (int) (Math.random()*100+1);
        int guess = 0 ;
        boolean didWon = true ;

        System.out.println("Please enter an number between 1 - 100") ;

        while(guess != computerNumber) {
         try {
             guess = Integer.parseInt(scn.nextLine());
         }catch (NumberFormatException e){
             System.out.println("Incorrect input! Please enter number between 1 - 100");
             guess = Integer.parseInt(scn.nextLine());
         }

            guessCount = checkInput(guess,guessCount) ;
            determineGuess(guess , computerNumber , guessCount);
            if(guessCount ==10){
                didWon = false ;
                break;
            }
        }
        if(didWon){
            bestScore = checkBest(bestScore ,  guessCount);
        }

        return false;
    }

    private static int checkInput(int guess , int guesCount  ) {
        if(guess < 1 || guess > 100){
            System.out.println("Your guess is invalid");
            return guesCount ;

        }else{
            return  guesCount+1 ;
        }
    }

    private static void determineGuess(int guess, int computerNumber, int guessCount ) {
        if(guess == computerNumber){
            System.out.println("Correct! Total guesses: " + guessCount);

        }else if (guess > computerNumber  && guess >= 1 && guess <=100 ){
            System.out.println("Your guess is too high, try again!");
        }else if ( guess < computerNumber && guess >= 1 && guess <=100){
            System.out.println("Your guess is too low, try again!");
        }

    }
     private static int checkBest(int bestScore , int guessCount) {
        if(bestScore < guessCount){
            return  guessCount ;
        }
        return bestScore;
     }


}
