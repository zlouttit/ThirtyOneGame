public class FuncTest{
	
	public static void main(String args[]){
		Card[] deck = Setup.deckGen();
		Setup.deckShuffle(deck);
		Player[] players = new Player[3];

		for(int i = 0; i < players.length; i++)
			players[i] = new Player("Test Name");
		int deckIndex = Setup.dealCards(players, deck);

		System.out.println(deckIndex);
		System.out.println(players[0]);
	}
}