public class Game {

    private Player[] players;
    private Card[] deck;
    private int deckIndex; //Index for first card in discard pile


    public Game(int numPlayers, String[] names){
        Setup st = new Setup();
        deck = st.deckGen();
        st.deckShuffle(deck);

        players = new Player[numPlayers];
        for(int i = 0; i < players.length; i++)
            players[i] = new Player(names[i]);

        deckIndex = st.dealCards(players, deck);

    }

    public void swap(Player player, int playerIndex){
        Card temp;
        temp = deck[deckIndex];
        deck[deckIndex] = player.getCard(playerIndex);
        player.setCard(temp, playerIndex);
    }


}
