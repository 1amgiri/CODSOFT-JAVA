import java.util.*;
class Numgame{
    //Game
    void randgame(){
        Scanner sc=new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(50) + 1;
        int n=6;
        int k=3;
        int total=0;
        System.out.println("**** Guess a number between 1-50 ****");
        do {
            System.out.println("NOTE:- You're having only "+ n +" ATTEMPTS");
            System.out.println("Game Starts Now");
            System.out.println("\n");
            int guess=sc.nextInt();
            if(guess>number){
                if(n==1){
                    System.out.println("Your guess number is TOO HIGH");
                    System.out.println("You lost the game!"+ "It is "+number+"...Try Again");
                    System.out.println("\n");
                    menu();
                }
                else{
                    System.out.println("------Your guess number is TOO HIGH------");
                }
            }
            else if(guess<number){
                if(n==1){
                    System.out.println("Your guess number is TOO LOW");
                    System.out.println("You lost the game!"+  "It is "+number+"...Try Again");
                    System.out.println("\n");
                    menu();
                }
                else{
                    System.out.println("------Your guess number is TOO LOW------");
                }
            }
            else{
                System.out.println("------Your Guess is Correct!------");
                System.out.println("Well played! Your Score = "+ n +"/6");
                System.out.println("\n");
                System.out.println("Do you want to play again ??");
                System.out.println("Option 1: Yes\n Option 2: No\n Option 3: Menu");
                int select=sc.nextInt();
                if(select==1){
                    randgame();
                }
                else if(select==2){
                    return;
                }
                else if(select==3){
                    menu();
                }
                else{
                    System.out.println("Invalid Option...opening Menu");
                }
            }
            n--;
        } while (n!=0);
    }
    //Menu
    void menu(){
        Scanner sc=new Scanner(System.in);
        int m=3;
        do { 
            System.out.println("----------------------------------------");
            System.out.println("*****WELCOME TO RANDOM NUMBER GAME*****");
            System.out.println("\n");
            System.out.println("Option 1 : Start the Game");
            System.out.println("Option 2 : Game Rules");
            System.out.println("Option 3 : Exit");
            System.out.println("\n");
            System.out.println("Select the option below:");
            int choice=sc.nextInt();
            switch(choice){
                case 1: randgame();
                        break;
                case 2: rules();
                        break;
                case 3: System.out.println("Successfully Exited");
                        break;
                default: System.out.println("Invalid Choice! Enter given option");
                        menu();
            }
        } while (m!=3);
    }
    //Rules
    void rules(){
        System.out.println("----------------------------------------");
        System.out.println("RULE 1: Guess the Number between 1-50 only.");
        System.out.println("RULE 2: Your score will given based on the number of Attempts taken.");
        System.out.println("RULE 3: You will have 6 Rounds. After that you can REPLAY the game.");
        System.out.println("----------------------------------------");
        menu();
    }
    public static void main(String args[]){
        Numgame game=new Numgame();
        game.menu();
    }
}