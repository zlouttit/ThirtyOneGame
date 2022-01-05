import java.util.Scanner;
public class Game {

    private Player[] players;
    private Card[] deck;
    private int deckIndex; //Index for first card in discard pile
    private boolean lastTurn;
    private final int NUM_CARDS = 52;

    public Game(int numPlayers, String humanName){
        Setup st = new Setup();
        deck = st.deckGen();
        st.deckShuffle(deck);

        players = new Player[numPlayers];
        players[0] = new Human(humanName);
        for(int i = 1; i < players.length; i++) {
            String compName = "Computer #" + i;
            players[i] = new Player(compName);
        }
        deckIndex = st.dealCards(players, deck);
        lastTurn = false;

    }

    private void swap(Player player, int playerIndex){
        Card temp;
        temp = deck[deckIndex];
        deck[deckIndex] = player.getCard(playerIndex);
        player.setCard(temp, playerIndex);
    }

    public void humanTurn(){
        System.out.println(players[0]);
        System.out.println("The card in the discard pile is a/an " + deck[deckIndex].toString() + ".\n");

        Scanner in = new Scanner(System.in);
        int turnVal = 0;
        String userMessage;

        while(turnVal < 1 || turnVal > 3) {
            try {
                System.out.println("Your options are either drawing a card (1), swapping with the discard card (2)," +
                        "or knocking (3). \nWhat would you like to do?");

                userMessage = in.next();
                turnVal = Integer.parseInt(userMessage);
                if(turnVal < 1 || turnVal > 3)
                    throw new Exception();

            }catch(Exception e){
                System.out.println("\nInvalid input, please enter 1, 2, or 3.\n");
            }
        }

        if(turnVal < 3) {
            turnVal = -1;

            //Drawing a card
            if (turnVal == 1) {
                deckIndex++;
                System.out.println("You have drawn a/an " + deck[deckIndex].toString() + ".\n");

                while(turnVal < 0 || turnVal > 3) {
                    try {
                        System.out.println("Your options are either discarding (0), or swapping with the " +
                                players[0].getCard(0).toString() + "(1)," +
                                players[0].getCard(1).toString() + "(2), or " +
                                players[0].getCard(2).toString() + "(3)." +
                                "\nWhat would you like to do?");

                        userMessage = in.next();
                        turnVal = Integer.parseInt(userMessage);
                        if(turnVal < 0 || turnVal > 3)
                            throw new Exception();

                    }catch(Exception e){
                        System.out.println("\nInvalid input, please enter 0, 1, 2, or 3.\n");
                    }
                }
                if(turnVal > 0)
                    swap(players[0], turnVal -1 );

            //Swapping with discard card
            }else {

                while (turnVal < 1 || turnVal > 3) {
                    try {
                        System.out.println("You can either swap with the " +
                                players[0].getCard(0).toString() + "(1)," +
                                players[0].getCard(1).toString() + "(2), or " +
                                players[0].getCard(2).toString() + "(3)." +
                                "\nWhat would you like to do?");

                        userMessage = in.next();
                        turnVal = Integer.parseInt(userMessage);
                        if (turnVal < 1 || turnVal > 3)
                            throw new Exception();

                    } catch (Exception e) {
                        System.out.println("\nInvalid input, please enter 1, 2, or 3.\n");
                    }
                }
            }

            if(turnVal > 0)
                swap(players[0], turnVal -1 );


        // Knocking
        }else{
            System.out.println("\nYou've knocked the table. Last turn everyone!\n");
            lastTurn = true;
        }
        in.close;
    }

    public void computerTurn(Player computer){

    }

    public boolean isCards(){
        return deckIndex >= NUM_CARDS;
    }

    public boolean isLastTurn(){
        return lastTurn;
    }

}
