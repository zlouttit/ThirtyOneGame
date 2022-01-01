public class FuncTest{
	
	public static void main(String args[]){
		Card[] deck = Setup.deckGen();
		Setup.deckShuffle(deck);
		Human[] players = new Human[3];

		for(int i = 0; i < players.length; i++)
			players[i] = new Human(String.format("Joe %d",i+1));
		int deckIndex = Setup.dealCards(players, deck);

		System.out.println(deckIndex);
		System.out.println(players[0]);

		String[] names =  {"Bob", "Steve"};
		Game ng = new Game(2, names);
		System.out.println(ng.humanTurn());
	}
}