import java.util.Scanner;
public class Game {

    private Player[] players;
    private Card[] deck;
    private int deckIndex; //Index for first card in discard pile


    public Game(int numPlayers, String[] names){
        Setup st = new Setup();
        deck = st.deckGen();
        st.deckShuffle(deck);

        players = new Player[numPlayers];
        players[0] = new Human(names[0]);
        for(int i = 1; i < players.length; i++)
            players[i] = new Player(names[i]);

        deckIndex = st.dealCards(players, deck);

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

            //Drawing a card
            if (turnVal == 1) {
                deckIndex++;
                System.out.println("You have drawn a/an " + deck[deckIndex].toString() + ".\n");
                turnVal = -1;

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
            }else{

            }

        // Knocking
        }else{

        }
        in.close;
    }

}
