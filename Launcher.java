import java.util.Scanner;
public class Launcher {

    private final int NUM_PLAYERS = 4;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Thirty-One!\n\nPlease enter your name:");
        String playerName = in.next();
        Game g = new Game(NUM_PLAYERS, playerName);

        System.out.println("Ok " + playerName + ", let's get started.\n");


    }

}
