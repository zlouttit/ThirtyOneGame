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

    public void swap(Player player, int playerIndex){
        Card temp;
        temp = deck[deckIndex];
        deck[deckIndex] = player.getCard(playerIndex);
        player.setCard(temp, playerIndex);
    }

    public int humanTurn(){
        System.out.println(players[0]);
        System.out.println("The card in the discard pile is a/an " + deck[deckIndex].toString() + ".\n");

        Scanner in = new Scanner(System.in);
        System.out.println("Your options are either drawing a card (1), swapping with the discard card (2)," +
                "or knocking (3). \nWhat would you like to do?");
        return in.nextInt();
    }


}
